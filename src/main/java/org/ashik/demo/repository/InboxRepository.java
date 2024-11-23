package org.ashik.demo.repository;

import org.ashik.demo.model.Inbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InboxRepository extends JpaRepository<Inbox, Integer> {
}