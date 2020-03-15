package com.design.patterns.behavioral.templatemethod;

import org.junit.jupiter.api.Test;

public class TemplateMethodTest {
    @Test
    void testTemplateMethod(){
        Payment payment = new Visa();
        payment.makePayment();

        payment = new Paypal();
        payment.makePayment();
    }
}
