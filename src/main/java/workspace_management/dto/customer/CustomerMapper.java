package workspace_management.dto.customer;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import workspace_management.entity.Customer;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    CustomerResponseDto toDto(Customer customer);
}
