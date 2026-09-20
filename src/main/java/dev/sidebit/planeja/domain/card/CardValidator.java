package dev.sidebit.planeja.domain.card;

import dev.sidebit.planeja.common.validation.FieldInvalid;
import dev.sidebit.planeja.common.validation.ValidationResult;
import dev.sidebit.planeja.domain.card.dto.CardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardValidator {

    @Autowired
    private CardRepository repository;

    public ValidationResult validate(CardForm form){
        var result = ValidationResult.newCard();

        if(repository.findByName(form.name()).isPresent()){
            result.add(new FieldInvalid("name", "Já cadastrado."));
        }

        return result;
    }
}
