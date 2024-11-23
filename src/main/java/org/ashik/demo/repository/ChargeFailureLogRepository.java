package org.ashik.demo.repository;

import org.ashik.demo.model.ChargeFailureLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeFailureLogRepository extends JpaRepository<ChargeFailureLog, Integer> {
}