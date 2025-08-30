package core.server.workflow_management_wizard.domain;

import core.server.workflow_management_wizard.constant.Category;


public class WorkflowNode {
    private String id;
    private String name;
    private String description;
    private Category category;
    private WorkflowNode nextNode;

    public WorkflowNode(String id, String name, String description, Category category, WorkflowNode nextNode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.nextNode = nextNode;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public WorkflowNode getNextNode() { return nextNode; }
    public void setNextUnit(WorkflowNode nextNode) { this.nextNode = nextNode; }
}
