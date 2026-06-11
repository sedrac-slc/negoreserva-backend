package com.negoreserva.common.feature.core.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLRestriction;

import java.time.Instant;
import java.util.UUID;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@SQLRestriction(value = "deleted_at IS NULL AND deleted_by IS NULL")
public class ConcreteModel extends CommonModel {
    protected UUID createdBy;
    protected UUID updatedBy;
    protected UUID deletedBy;
    protected Instant deletedAt;
}