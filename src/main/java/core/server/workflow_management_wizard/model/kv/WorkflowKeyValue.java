package core.server.workflow_management_wizard.model.kv;

import core.server.workflow_management_wizard.domain.WorkflowNode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("workflow_key_value")
public class WorkflowKeyValue {
    @Id
    private UUID workflowId;

    private WorkflowNode workFlowLinkedListHead;

    public WorkflowKeyValue(UUID workflowId, WorkflowNode workFlowLinkedListHead) {
        this.workflowId = workflowId;
        this.workFlowLinkedListHead = workFlowLinkedListHead;
    }

    public UUID getWorkflowId() { return workflowId; }
    public void setWorkflowId(UUID workflowId) { this.workflowId = workflowId; }

    public WorkflowNode getWorkFlowLinkedListHead() { return workFlowLinkedListHead; }
    public void setWorkFlowLinkedListHead(WorkflowNode workFlowLinkedListHead) { this.workFlowLinkedListHead = workFlowLinkedListHead; }
}
