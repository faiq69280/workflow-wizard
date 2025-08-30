package core.server.workflow_management_wizard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class WorkflowUnit extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    WorkflowCategory workflowCategory;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public WorkflowCategory getWorkflowCategory() { return workflowCategory; }
    public void setWorkflowCategory(WorkflowCategory workflowCategory) { this.workflowCategory = workflowCategory; }
}
