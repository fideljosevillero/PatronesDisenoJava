package com.design.patterns.behavioral.chainofresponsibility;

import org.junit.jupiter.api.Test;

public class ChainOfResponsibilityTest {
    @Test
    void testChainOfResponsibility(){
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.crediCardRequest(100000);
    }
}
