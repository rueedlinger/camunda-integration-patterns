package ch.yax.bpmn;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
public class ProcessEngine {

    @Autowired
    private RuntimeService runtimeService;

    @EventListener
    private void processPostDeploy(final PostDeployEvent event) {
        
    }

    public static void main(final String... args) throws Exception {
        SpringApplication.run(ProcessEngine.class, args);
    }
}
