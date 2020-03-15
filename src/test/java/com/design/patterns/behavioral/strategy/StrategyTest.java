package com.design.patterns.behavioral.strategy;

import org.junit.jupiter.api.Test;

public class StrategyTest {
    @Test
    void testStrategy(){
        Context context = new Context(new CapitalStrategyTextFormatter());
        context.publishText("Este texto será convertido a MAYUSCULAS a través del algoritmo");

        context = new Context(new LowerStrategyTestFormatter());
        context.publishText("Esto texto SERA CONVERTIDO a MINUSCULAS a través del algortimo");
    }
}
