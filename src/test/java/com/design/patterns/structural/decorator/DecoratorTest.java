package com.design.patterns.structural.decorator;

import org.junit.jupiter.api.Test;

public class DecoratorTest {
    @Test
    void testDecorator(){
        Credit gold = new Gold();

        Credit blackInternationalPayment = new Black();
        blackInternationalPayment = new InternationalPaymentDecorator(blackInternationalPayment);

        Credit goldSecureInternational = new Gold();
        goldSecureInternational = new InternationalPaymentDecorator(goldSecureInternational);
        goldSecureInternational = new SecureDecorator(goldSecureInternational);

        System.out.println("----Tarjeta Gold con configuración----");
        gold.showCredit();

        System.out.println("----Tarjeta Black con configuración----");
        blackInternationalPayment.showCredit();

        System.out.println("----Tarjeta Gold2 con configuración----");
        goldSecureInternational.showCredit();
    }
}
