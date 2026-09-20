package dev.sidebit.planeja.domain.card.mapper;

import dev.sidebit.planeja.domain.card.dto.CardDetail;
import dev.sidebit.planeja.domain.card.dto.CardForm;
import dev.sidebit.planeja.domain.card.model.CardEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardEntity toEntity(CardForm form);

    CardDetail toDetail(CardEntity entity);
}
