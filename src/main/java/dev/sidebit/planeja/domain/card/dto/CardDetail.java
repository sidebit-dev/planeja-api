package dev.sidebit.planeja.domain.card.dto;

import dev.sidebit.planeja.domain.card.model.CardNetwork;

import java.time.LocalDateTime;

public record CardDetail(String id, String name, CardNetwork cardNetwork, LocalDateTime registrationDate) {
}
