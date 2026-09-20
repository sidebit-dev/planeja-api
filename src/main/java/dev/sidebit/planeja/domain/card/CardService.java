package dev.sidebit.planeja.domain.card;

import dev.sidebit.planeja.common.exceptions.ValidationException;
import dev.sidebit.planeja.domain.card.dto.CardDetail;
import dev.sidebit.planeja.domain.card.dto.CardForm;
import dev.sidebit.planeja.domain.card.mapper.CardMapper;
import dev.sidebit.planeja.domain.card.model.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardValidator validator;
    @Autowired
    private CardRepository repository;
    @Autowired
    private CardMapper mapper;

    public CardDetail create(CardForm form){
        var result = validator.validate(form);

        if(result.isInvalid()){
            throw new ValidationException(result.getFieldInvalids());
        }
        CardEntity entity = mapper.toEntity(form);
        repository.save(entity);
        return mapper.toDetail(entity);
    }
}
