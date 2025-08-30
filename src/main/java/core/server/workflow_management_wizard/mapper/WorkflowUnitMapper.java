package core.server.workflow_management_wizard.mapper;

import core.server.workflow_management_wizard.domain.WorkflowNode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkflowUnitMapper {
    @Mapping(source = "workflowCategory.category", target = "category")
    WorkflowNode toDomain(core.server.workflow_management_wizard.model.WorkflowUnit workflowUnitModel);
}
