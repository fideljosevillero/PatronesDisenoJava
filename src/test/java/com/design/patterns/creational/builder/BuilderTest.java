package com.design.patterns.creational.builder;

import org.junit.jupiter.api.Test;

public class BuilderTest {
    @Test
    void testBuilder(){
        Card card = new Card.CardBuilder("VISA",
                "0000 1111 2222 3333")
                .name("Alberto")
                .expires(2030)
                .credit(true)
                .build();

        System.out.println(card);

        Card card2 = new Card.CardBuilder("AMEX",
                "9999 9999 9999 9999")
                .build();

        System.out.println(card2);
    }
}
