package dev.sidebit.planeja.domain.card;

import dev.sidebit.planeja.common.validation.FieldInvalid;
import dev.sidebit.planeja.common.validation.ValidationResult;
import dev.sidebit.planeja.domain.card.dto.CardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CardValidator {

    @Autowired
    private CardRepository repository;

    public ValidationResult validate(CardForm form, UUID id){
        var result = ValidationResult.newCard();

        var isListNotEmpty = !repository.findByNameAndNotId(form.name(), id).isEmpty();
        if(isListNotEmpty){
            result.add(new FieldInvalid("name", "Já cadastrado."));
        }

        return result;
    }
}
