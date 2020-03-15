package com.design.patterns.structural.adapter;

import org.junit.jupiter.api.Test;

public class AdapterTest {
    @Test
    void testAdapter(){
        CreditCard creditCard = new CreditCard();
        creditCard.pay("classic");
        creditCard.pay("gold");
        creditCard.pay("black");
        creditCard.pay("silver");
    }
}
