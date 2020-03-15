package com.design.patterns.structural.facade;

import org.junit.jupiter.api.Test;

public class FacadeTest {
    @Test
    void testFacade(){
        CreditMarket creditMarket = new CreditMarket();
        creditMarket.showCreditBlack();
        creditMarket.showCreditGold();
        creditMarket.showCreditSilver();
    }
}
