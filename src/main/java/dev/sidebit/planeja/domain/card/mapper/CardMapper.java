package dev.sidebit.planeja.domain.card.mapper;

import dev.sidebit.planeja.domain.card.dto.CardDetail;
import dev.sidebit.planeja.domain.card.dto.CardForm;
import dev.sidebit.planeja.domain.card.model.CardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardEntity toEntity(CardForm form);

    CardDetail toDetail(CardEntity entity);

    void update(@MappingTarget CardEntity entity, CardForm dataAtualization);
}
