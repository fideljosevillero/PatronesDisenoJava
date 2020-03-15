package com.design.patterns.creational.factorymethod;

import org.junit.jupiter.api.Test;

public class FactoryMethodTest {
    @Test
    void testFactoryMethod(){
        Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
    }
}
