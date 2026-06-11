package com.negoreserva.common.feature.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class CommonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonIgnore
    protected long id;
    @Column(nullable = false, unique = true, updatable = false)
    protected UUID uuid;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    protected Instant updatedAt;

    @PrePersist
    public void onCreate() {
        if(uuid == null) { uuid = UUID.randomUUID(); }
    }
}