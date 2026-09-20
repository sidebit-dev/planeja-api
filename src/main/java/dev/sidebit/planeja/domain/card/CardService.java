package dev.sidebit.planeja.domain.card;

import dev.sidebit.planeja.common.exceptions.RegisterNotFindException;
import dev.sidebit.planeja.common.exceptions.ValidationException;
import dev.sidebit.planeja.domain.card.dto.CardDetail;
import dev.sidebit.planeja.domain.card.dto.CardForm;
import dev.sidebit.planeja.domain.card.mapper.CardMapper;
import dev.sidebit.planeja.domain.card.model.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CardService {

    @Autowired
    private CardValidator validator;
    @Autowired
    private CardRepository repository;
    @Autowired
    private CardMapper mapper;

    public CardDetail create(CardForm form){
        var result = validator.validate(form, null);

        if(result.isInvalid()){
            throw new ValidationException(result.getFieldInvalids());
        }
        CardEntity entity = mapper.toEntity(form);
        repository.save(entity);
        return mapper.toDetail(entity);
    }

    public CardDetail getDetails(UUID id){
        return repository
                .findById(id)
                .map(mapper::toDetail)
                .orElseThrow( () -> new RegisterNotFindException());
    }

    @Transactional
    public void upadate(UUID id, CardForm dataAtualization) {
        var entity = repository.findById(id)
                .orElseThrow( () -> new RegisterNotFindException());
        var result = validator.validate(dataAtualization, id);
        if(result.isInvalid()){
            throw new ValidationException(result.getFieldInvalids());
        }

        mapper.update(entity,dataAtualization);
// Não precisa do comando abaixo com @Transaction
// repository.save(entity);
    }
}
