package com.design.patterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;

public class AbstractFactoryTest {
    @Test
    void testAbstractFactory(){
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        com.design.patterns.creational.abstractfactory.Card tarjeta = (com.design.patterns.creational.abstractfactory.Card) abstractFactory.create("VISA");

        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("DEBIT");

        System.out.println("Un tarjeta de tipo: " + tarjeta.getCardType() + " con el metodo de pago: " + paymentMethod.doPayment());
    }
}
