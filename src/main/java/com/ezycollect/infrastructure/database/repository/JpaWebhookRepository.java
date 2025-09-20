package com.ezycollect.infrastructure.database.repository;

import com.ezycollect.infrastructure.database.entity.WebhookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaWebhookRepository extends JpaRepository<WebhookEntity, UUID> {
}
