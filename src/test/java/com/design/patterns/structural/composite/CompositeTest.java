package com.design.patterns.structural.composite;

import org.junit.jupiter.api.Test;

public class CompositeTest {
    @Test
    void testComposite(){
        CuentaComponent cuentaCorriente = new CuentaCorriente(1000.0, "Alberto");
        CuentaComponent cuentaAhorro = new CuentaAhorro(20000.0, "Alberto");

        CuentaComposite cuentaComposite = new CuentaComposite();
        cuentaComposite.addCuenta(cuentaCorriente);
        cuentaComposite.addCuenta(cuentaAhorro);

        cuentaComposite.showAccountName();
        cuentaComposite.getAmount();
    }
}
