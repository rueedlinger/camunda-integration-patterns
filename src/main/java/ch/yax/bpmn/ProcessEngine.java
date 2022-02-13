package ch.yax.bpmn;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
@EnableProcessApplication
public class ProcessEngine {

    @Autowired
    private RuntimeService runtimeService;

    public static void main(final String... args) throws Exception {
        SpringApplication.run(ProcessEngine.class, args);
    }

    @EventListener
    private void processPostDeploy(final PostDeployEvent event) {
        log.info("process engine running: {}", event.getProcessEngine().getName());
    }
}
