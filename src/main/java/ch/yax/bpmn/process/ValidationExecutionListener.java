package ch.yax.bpmn.process;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@Component("validationExecutionListener")
public class ValidationExecutionListener implements ExecutionListener {

    @Override
    public void notify(final DelegateExecution delegateExecution) throws Exception {
        log.info("validate process inputs for event name: {}", delegateExecution.getEventName());
        if (StringUtils.isEmpty(delegateExecution.getBusinessKey())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BusinessKey not set");
        }
    }
}
