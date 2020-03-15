package com.design.patterns.creational.singlenton;

import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    void testSingleton(){
        Card.getINSTANCE().setCardNumber("1234-1234-1234-1324");
        System.out.println(com.design.patterns.creational.singlenton.Card.getINSTANCE().getCardNumber());
    }
}
