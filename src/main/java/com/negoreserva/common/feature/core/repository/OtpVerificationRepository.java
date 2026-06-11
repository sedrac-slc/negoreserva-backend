package com.negoreserva.common.feature.core.repository;

import com.negoreserva.common.feature.core.model.OtpVerificationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface OtpVerificationRepository<T extends OtpVerificationModel> extends JpaRepository<T, Long> {

}