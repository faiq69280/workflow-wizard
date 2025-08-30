package core.server.workflow_management_wizard.model;

import jakarta.persistence.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

//this wouldn't be stored directly
@Table
@Entity
public class Workflow extends BaseEntity {
    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "workflow", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<ExecutionContext> executionContexts = new ArrayList<>();

    public Workflow() {}
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
