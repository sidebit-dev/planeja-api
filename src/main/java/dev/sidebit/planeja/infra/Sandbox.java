package dev.sidebit.planeja.infra;

import dev.sidebit.planeja.domain.card.CardRepository;
import dev.sidebit.planeja.domain.card.model.CardEntity;
import dev.sidebit.planeja.domain.card.model.CardNetwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sandbox implements CommandLineRunner {
//    Esta classe é para fazer testes
    @Autowired
    private CardRepository repository;

    public void salvarCartao(){
        CardEntity card = new CardEntity();
        card.setName("ITAU Personalité");
        card.setCardNetwork(CardNetwork.AMERICAN_EXPRESS);

        repository.save(card);
    }

    @Override
    public void run(String... args) throws Exception {
//        salvarCartao();
    }
}
