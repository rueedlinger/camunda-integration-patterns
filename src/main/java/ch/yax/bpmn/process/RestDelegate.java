package ch.yax.bpmn.process;


import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("restDelegate")
public class RestDelegate implements JavaDelegate {

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {
        log.info("do rest call");
    }
}
