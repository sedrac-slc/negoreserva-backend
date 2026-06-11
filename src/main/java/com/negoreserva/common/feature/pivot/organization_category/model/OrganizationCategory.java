package com.negoreserva.common.feature.pivot.organization_category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.negoreserva.common.feature.concrete.category.model.Category;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
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
        name = EntityPivotVariable.ORGANIZATION_CATEGORY,
        uniqueConstraints = {@UniqueConstraint(
                name = "uk_organization_category",
                columnNames = {"category_id", "organization_id"}
        )}
)
public class OrganizationCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonIgnore
    protected long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;
}
