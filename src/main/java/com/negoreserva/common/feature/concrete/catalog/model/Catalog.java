package com.negoreserva.common.feature.concrete.catalog.model;

import com.negoreserva.common.contract.Sluggable;
import com.negoreserva.common.feature.concrete.catalog.enums.CatalogType;
import com.negoreserva.common.feature.concrete.organization.model.Organization;
import com.negoreserva.common.feature.core.model.ConcreteModel;
import com.negoreserva.common.util.SlugUtils;
import com.negoreserva.common.util.UniqueFieldUtil;
import com.negoreserva.common.variable.EntityVariable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = EntityVariable.CATALOG)
public class Catalog extends ConcreteModel implements Sluggable {
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String description;

    @Size(max = 2048)
    private String imgUrl;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private CatalogType type = CatalogType.NONE;

    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String slug;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public CatalogType getType() {
        return type == null ? CatalogType.NONE : type;
    }

    @PrePersist
    @PreUpdate
    private void applyDefaultType() {
        if (type == null) {
            type = CatalogType.NONE;
        }
    }

    @Override
    public void applySlug() {
        this.slug = organization.getSlug()+"-"+SlugUtils.toSlug(this.name);
    }

    @Override
    public void sanitizeUniqueFields() {
        this.slug = UniqueFieldUtil.fieldDelete(slug, id);
    }
}
