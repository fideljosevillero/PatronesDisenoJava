package com.design.patterns.behavioral.command;

import org.junit.jupiter.api.Test;

public class CommandTest {

    @Test
    void testCommand(){
        CreditCard creditCard = new CreditCard();
        CreditCard creditCardDeactivate= new CreditCard();

        CreditCardInvoker invoker = new CreditCardInvoker();

        invoker.setCommand(new CreditCardActivateCommand(creditCard));
        invoker.run();
        System.out.println("--------------------");
        invoker.setCommand(new CreditCardDesactivateCommand(creditCardDeactivate));
        invoker.run();
    }
}
