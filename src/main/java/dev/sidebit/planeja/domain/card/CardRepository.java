package dev.sidebit.planeja.domain.card;

import dev.sidebit.planeja.domain.card.model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<CardEntity, UUID> {

    Optional<CardEntity> findByName(String name);
}
