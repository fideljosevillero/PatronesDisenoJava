package com.design.patterns.behavioral.visitor;

import org.junit.jupiter.api.Test;

public class VisitorTest {
    @Test
    void testVisitor(){
        OfertaElement ofertaElement = new OfertaGasolina();
        ofertaElement.accept(new BlackCreditCardVisitor());

        ofertaElement = new OfertaVuelos();
        ofertaElement.accept(new ClassicCreditCardVisitor());
    }
}
