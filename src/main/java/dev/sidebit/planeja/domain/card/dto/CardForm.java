package dev.sidebit.planeja.domain.card.dto;

import dev.sidebit.planeja.domain.card.model.CardNetwork;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CardForm(
        @NotBlank(message = "Campo obrigatório.")
        String name,
        @NotNull(message = "Campo obrigatório.")
        CardNetwork cardNetwork) {
}
