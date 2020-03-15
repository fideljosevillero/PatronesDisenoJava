package com.design.patterns.behavioral.state;

import org.junit.jupiter.api.Test;

public class StateTest {
    @Test
    void testState(){
        MobileAlertStateContext context = new MobileAlertStateContext();
        context.alert();
        context.alert();
        context.setState(new Vibration());
        context.alert();
        context.alert();
        context.setState(new Silent());
        context.alert();
        context.alert();
    }
}
