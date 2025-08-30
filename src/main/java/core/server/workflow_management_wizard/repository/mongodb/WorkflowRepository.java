package core.server.workflow_management_wizard.repository.mongodb;

import core.server.workflow_management_wizard.model.kv.WorkflowKeyValue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkflowRepository extends MongoRepository<WorkflowKeyValue, UUID> {}
