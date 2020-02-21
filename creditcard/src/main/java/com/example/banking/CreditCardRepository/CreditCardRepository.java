package com.example.banking.CreditCardRepository;

import com.example.banking.CreditCardModel.CreditCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {

    List<CreditCard> getCreditCardsByClientId(String clientId);

    CreditCard getCreditCardById(Long id);

    CreditCard getCreditCardByNumber(String number);
}
