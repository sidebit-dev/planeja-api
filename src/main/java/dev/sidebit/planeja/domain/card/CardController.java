package dev.sidebit.planeja.domain.card;

import dev.sidebit.planeja.domain.card.dto.CardDetail;
import dev.sidebit.planeja.domain.card.dto.CardForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("{id}")
    public ResponseEntity<CardDetail> getDetail(@PathVariable("id") UUID id){
        var result = service.getDetails(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody CardForm dataAtualization){
        service.upadate(id, dataAtualization);
        return ResponseEntity.noContent().build();
    }
}
