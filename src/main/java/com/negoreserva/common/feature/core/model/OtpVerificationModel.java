package com.negoreserva.common.feature.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.negoreserva.common.feature.core.enums.OtpVerificationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLRestriction;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@SQLRestriction("expired_at > CURRENT_TIMESTAMP")
public class OtpVerificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    protected long id;

    @NotBlank
    @Size(max = 100)
    protected String code;

    private boolean valid;

    private Instant expiredAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    protected OtpVerificationType type;

    @JsonIgnore
    public boolean isExpired() {
        return expiredAt == null || Instant.now().isAfter(expiredAt);
    }

    @JsonIgnore
    public boolean isNotExpired() {
        return !isExpired();
    }
}
