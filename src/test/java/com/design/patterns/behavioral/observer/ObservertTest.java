package com.design.patterns.behavioral.observer;

import org.junit.jupiter.api.Test;

public class ObservertTest {
    @Test
    void testObserver(){
        Coche coche = new Coche();
        Peaton peaton = new Peaton();
        MessagePublisher messagePublisher = new MessagePublisher();

        messagePublisher.attach(coche);
        messagePublisher.attach(peaton);
        messagePublisher.notifyUpdate(new Semaforo("ROJO_COCHE"));
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
        messagePublisher.notifyUpdate(new Semaforo("VERDE_COCHE"));
    }
}
