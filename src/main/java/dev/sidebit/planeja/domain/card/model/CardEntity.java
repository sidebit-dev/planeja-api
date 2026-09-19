package dev.sidebit.planeja.domain.card.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column(nullable = false , length = 30)
    private String name;

    @Column(name = "card_network")
    @Enumerated(EnumType.STRING)
    private CardNetwork cardNetwork;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

//    Inicializar a data de cadastro
    @PrePersist
    public void prePersist(){
        setRegistrationDate(LocalDateTime.now());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardNetwork getCardNetwork() {
        return cardNetwork;
    }

    public void setCardNetwork(CardNetwork cardNetwork) {
        this.cardNetwork = cardNetwork;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
