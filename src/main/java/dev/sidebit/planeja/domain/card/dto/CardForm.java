package dev.sidebit.planeja.domain.card.dto;

import dev.sidebit.planeja.domain.card.model.CardNetwork;

public record CardForm(String name, CardNetwork cardNetwork) {
}
