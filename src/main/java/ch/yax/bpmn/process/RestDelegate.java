package ch.yax.bpmn.process;


import ch.yax.bpmn.process.entity.Post;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component("restDelegate")
public class RestDelegate implements JavaDelegate {

    @Value("${rest.endpoint}")
    private String uri;

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {


        final RestTemplate restTemplate = new RestTemplate();
        
        final ResponseEntity<Post> responseEntity = restTemplate.postForEntity(uri, createHttpEntity(delegateExecution), Post.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            processResponse(delegateExecution, responseEntity);
        } else {
            log.error("response was not successful. {}", responseEntity);
            throw new Exception("HTTP status was not successful! " + responseEntity.getStatusCode());
        }


    }

    private void processResponse(final DelegateExecution delegateExecution, final ResponseEntity<Post> responseEntity) throws Exception {
        log.info("response: {}", responseEntity);
        if (responseEntity.getBody() != null) {
            delegateExecution.setVariable(ProcessVariables.POST_ID, responseEntity.getBody().getId());
        } else {
            log.error("Id in response body was missing. {}", responseEntity.getBody());
            throw new Exception("Id in response body was missing");
        }
    }

    private HttpEntity<Post> createHttpEntity(final DelegateExecution delegateExecution) {
        final Post post = new Post();
        post.setBody((String) delegateExecution.getVariable(ProcessVariables.POST_BODY));
        post.setUserId((Long) delegateExecution.getVariable(ProcessVariables.POST_USER_ID));
        post.setTitle((String) delegateExecution.getVariable(ProcessVariables.POST_TITLE));
        return new HttpEntity<>(post);
    }


}
