package com.negoreserva.common.feature.pivot.user_organization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.common.feature.pivot.user_organization.enums.UserOrganizationType;
import com.negoreserva.common.variable.EntityPivotVariable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(
        name = EntityPivotVariable.USER_ORGANIZATION,
        uniqueConstraints = {@UniqueConstraint(
                name = "uk_user_organization_type",
                columnNames = {"user_id", "organization_id", "type"}
        )}
)
public class UserOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonIgnore
    protected long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private UserOrganizationType type = UserOrganizationType.GUEST;

    @Builder.Default
    private Boolean active = false;
}
