package dev.sidebit.planeja.domain.card;

import dev.sidebit.planeja.domain.card.dto.CardDetail;
import dev.sidebit.planeja.domain.card.dto.CardForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cards")
public class CardController {

    @Autowired
    private CardService service;

    @PostMapping
    public ResponseEntity<CardDetail> create(
            @RequestBody @Valid CardForm newCard){
        CardDetail detail = service.create(newCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(detail);
    }
}
