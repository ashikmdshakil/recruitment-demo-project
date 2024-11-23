package org.ashik.demo.repository;

import org.ashik.demo.model.KeywordDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordDetailsRepository extends JpaRepository<KeywordDetails, String> {
}