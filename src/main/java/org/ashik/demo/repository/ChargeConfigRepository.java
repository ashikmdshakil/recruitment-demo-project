package org.ashik.demo.repository;

import org.ashik.demo.model.ChargeConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChargeConfigRepository extends JpaRepository<ChargeConfig, String> {
    Optional<ChargeConfig> findByOperator(String operator);
}