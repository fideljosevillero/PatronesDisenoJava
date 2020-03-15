package com.design.patterns.structural.bridge;

import org.junit.jupiter.api.Test;

public class BridgeTest {
    @Test
    void testBridge(){
        CreditCard classic = new ClassicCreditCard(new UnsecureCreditCard());
        classic.realizarPago();

        classic = new ClassicCreditCard(new SecureCreditCard());
        classic.realizarPago();
    }
}
