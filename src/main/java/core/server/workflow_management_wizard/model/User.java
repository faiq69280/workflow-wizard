package core.server.workflow_management_wizard.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_name"})
})
@Entity
public class User extends BaseEntity {

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Workflow> workflows = new ArrayList<>();

    public User() {}
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Workflow> getWorkflows() { return workflows; }
    public void setWorkflows(List<Workflow> workflows) { this.workflows = workflows; }
}

