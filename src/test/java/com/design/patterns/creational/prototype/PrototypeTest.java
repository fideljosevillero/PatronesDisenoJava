package com.design.patterns.creational.prototype;

import org.junit.jupiter.api.Test;

public class PrototypeTest {
    @Test
    void testPrototype(){
        PrototypeFactory.loadCard();
        try {
            PrototypeCard visa = PrototypeFactory.getInstance(PrototypeFactory.CartType.VISA);
            visa.getCard();

            PrototypeCard amex = PrototypeFactory.getInstance(PrototypeFactory.CartType.AMEX);
            amex.getCard();

        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
