package org.ashik.demo.repository;

import org.ashik.demo.model.ChargeConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeConfigRepository extends JpaRepository<ChargeConfig, String> {
}