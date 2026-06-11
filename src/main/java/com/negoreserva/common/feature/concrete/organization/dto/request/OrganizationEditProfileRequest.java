package com.negoreserva.common.feature.concrete.organization.dto.request;


import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrganizationEditProfileRequest {
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String address;
    @Size(max = 1000)
    private String description;
}
