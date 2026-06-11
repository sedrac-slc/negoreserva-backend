package com.negoreserva.common.feature.pivot.org_user_role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.negoreserva.common.feature.concrete.org_role.model.OrgRole;
import com.negoreserva.common.feature.concrete.user.model.User;
import com.negoreserva.common.variable.EntityPivotVariable;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(
        name = EntityPivotVariable.ORG_USER_ROLE,
        uniqueConstraints = {@UniqueConstraint(
                name = "uk_org_user_role",
                columnNames = {"user_id", "role_id"}
        )}
)
public class OrgUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonIgnore
    protected long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private OrgRole role;
}
