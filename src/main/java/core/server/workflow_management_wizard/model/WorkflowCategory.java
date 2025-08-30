package core.server.workflow_management_wizard.model;

import core.server.workflow_management_wizard.constant.Category;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class WorkflowCategory extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Category category;

    //making fetch types lazy since this is a deeply nested structure.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    WorkflowCategory parentCategory;

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<WorkflowCategory> subCategories = new ArrayList<>();

    @OneToMany(mappedBy = "workflowCategory")
    List<WorkflowUnit> workflowUnits = new ArrayList<>();

    public WorkflowCategory(){}
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public WorkflowCategory getParentCategory() { return parentCategory; }
    public void setParentCategory(WorkflowCategory parentCategory) { this.parentCategory = parentCategory; }

    public List<WorkflowCategory> getSubCategories() { return subCategories; }
    public void setSubCategories(List<WorkflowCategory> subCategories) { this.subCategories = subCategories; }

    public List<WorkflowUnit> getWorkflowUnits() { return workflowUnits; }
    public void setWorkflowUnits(List<WorkflowUnit> workflowUnits) { this.workflowUnits = workflowUnits; }
}
