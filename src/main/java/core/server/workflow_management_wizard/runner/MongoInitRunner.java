package core.server.workflow_management_wizard.runner;


import core.server.workflow_management_wizard.constant.Category;
import core.server.workflow_management_wizard.domain.WorkflowNode;
import core.server.workflow_management_wizard.model.kv.WorkflowKeyValue;
import core.server.workflow_management_wizard.repository.mongodb.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@ConditionalOnProperty(name = "runners.enabled", havingValue = "true", matchIfMissing = false)
class MongoInitRunner implements CommandLineRunner {

    @Autowired
    private  WorkflowRepository repo;

    @Override
    public void run(String... args) {
       WorkflowNode node2 = new WorkflowNode("n2", "Something", "second step", Category.NOTIFICATION, null);
       WorkflowNode node1 = new WorkflowNode("n1", "Approval", "First step", Category.FILE_PROCESSING, node2);
       UUID key = UUID.randomUUID();
       WorkflowKeyValue wf = new WorkflowKeyValue(key, node1);
       repo.save(wf);

        WorkflowKeyValue workflowKeyValueFound = repo.findById(key).orElse(null);
        if (workflowKeyValueFound != null) {
            WorkflowNode nextNode = workflowKeyValueFound.getWorkFlowLinkedListHead();
            while (nextNode  != null){
                System.out.printf("category = %s, name = %s%n", nextNode.getCategory(), nextNode.getName());
                nextNode = nextNode.getNextNode();
            }
        }
    }
}