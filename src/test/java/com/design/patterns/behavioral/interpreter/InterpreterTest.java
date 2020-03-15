package com.design.patterns.behavioral.interpreter;

import org.junit.jupiter.api.Test;

public class InterpreterTest {

    @Test
    void testInterpreter(){
        Expression cero = new TerminalExpression("0");
        Expression uno = new TerminalExpression("1");

        Expression containBoolean = new OrExpression(cero, uno);
        Expression containsOneAndCero = new AndExpression(cero, uno);

        System.out.println(containBoolean.interpret("cero"));
        System.out.println(containBoolean.interpret("0"));

        System.out.println(containsOneAndCero.interpret("0"));
        System.out.println(containsOneAndCero.interpret("0, 1"));
    }
}
