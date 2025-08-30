package core.server.workflow_management_wizard.model;

import core.server.workflow_management_wizard.constant.Status;
import jakarta.persistence.*;

import java.util.Date;

@Table
@Entity
public class ExecutionContext extends BaseEntity {
    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_id")
    Workflow workflow;

    public ExecutionContext() {}
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Workflow getWorkflow() { return workflow; }
    public void setWorkflow(Workflow workflow) { this.workflow = workflow; }
}
