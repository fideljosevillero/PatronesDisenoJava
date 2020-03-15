package com.design.patterns;

import com.design.patterns.behavioral.chainofresponsibility.Tarjeta;
import com.design.patterns.behavioral.command.CreditCard;
import com.design.patterns.behavioral.command.CreditCardActivateCommand;
import com.design.patterns.behavioral.command.CreditCardDesactivateCommand;
import com.design.patterns.behavioral.command.CreditCardInvoker;
import com.design.patterns.behavioral.interpreter.AndExpression;
import com.design.patterns.behavioral.interpreter.Expression;
import com.design.patterns.behavioral.interpreter.OrExpression;
import com.design.patterns.behavioral.interpreter.TerminalExpression;
import com.company.behavioral.iterator.*;
import com.design.patterns.behavioral.mediator.ConcreteColleage1;
import com.design.patterns.behavioral.mediator.ConcreteColleage2;
import com.design.patterns.behavioral.mediator.ConcreteMediator;
import com.design.patterns.behavioral.memento.Article;
import com.design.patterns.behavioral.memento.ArticleMemento;
import com.design.patterns.behavioral.memento.Carataker;
import com.design.patterns.behavioral.observer.Coche;
import com.design.patterns.behavioral.observer.MessagePublisher;
import com.design.patterns.behavioral.observer.Peaton;
import com.design.patterns.behavioral.observer.Semaforo;
import com.design.patterns.behavioral.state.MobileAlertStateContext;
import com.design.patterns.behavioral.state.Silent;
import com.design.patterns.behavioral.state.Vibration;
import com.design.patterns.behavioral.strategy.CapitalStrategyTextFormatter;
import com.design.patterns.behavioral.strategy.Context;
import com.design.patterns.behavioral.strategy.LowerStrategyTestFormatter;
import com.company.behavioral.templatemethod.*;
import com.design.patterns.behavioral.templatemethod.Visa;
import com.company.behavioral.visitor.*;
import com.company.creational.abstractfactory.*;
import com.design.patterns.creational.factorymethod.PaymentFactory;
import com.design.patterns.creational.factorymethod.TypePayment;
import com.design.patterns.creational.prototype.PrototypeCard;
import com.design.patterns.creational.prototype.PrototypeFactory;
import com.design.patterns.structural.bridge.ClassicCreditCard;
import com.design.patterns.structural.bridge.SecureCreditCard;
import com.design.patterns.structural.bridge.UnsecureCreditCard;
import com.design.patterns.structural.composite.CuentaAhorro;
import com.design.patterns.structural.composite.CuentaComponent;
import com.design.patterns.structural.composite.CuentaComposite;
import com.design.patterns.structural.composite.CuentaCorriente;
import com.company.structural.decorator.*;
import com.design.patterns.structural.decorator.Credit;
import com.design.patterns.structural.facade.CreditMarket;
import com.design.patterns.structural.flyweight.Enemy;
import com.design.patterns.structural.flyweight.EnemyFactory;
import com.design.patterns.structural.proxy.Internet;
import com.design.patterns.structural.proxy.ProxyInternet;
import com.design.patterns.behavioral.iterator.CardList;
import com.design.patterns.behavioral.iterator.Iterator;
import com.design.patterns.behavioral.iterator.List;
import com.design.patterns.behavioral.templatemethod.Paypal;
import com.design.patterns.behavioral.visitor.*;
import com.design.patterns.creational.abstractfactory.AbstractFactory;
import com.design.patterns.creational.abstractfactory.FactoryProvider;
import com.design.patterns.creational.abstractfactory.PaymentMethod;
import com.design.patterns.structural.decorator.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //CREACIONALES
	    //probarFactoryMethod();
        //probarAbstractFactory();
        //probarBuilder();
        //probarPrototype();
        //probarSinglenton();

        //COMPORTAMIENTO
        //probarChainOfResponsability();
        //probarCommand();
        //probarIterator();
        //probarMediator();
        //probarMemento();
        //probarObserver();
        //probarState();
        //probarInterpreter();
        //probarStrategy();
        //probarTemplateMethod();
        //probarVisitor();

        //STRUCTURAL
        //probarAdapter();
        //probarBridge();
        //probarComposite();
        //probarDecorator();
        //probarFacade();
        //probarFlyweight();
        probarProxy();

    }

    private static void probarProxy(){
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("udemy.com");
            internet.connectTo("facebook.com");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void probarFlyweight(){
        for(int i=0; i<15; i++){
            Enemy enemy = EnemyFactory.getEnemy(getRandomEnemyType());
            enemy.setWeapon(getRandomWeapon());
            enemy.lifePoints();
        }
    }

    private static String getRandomWeapon(){
        Random r = new Random();
        int randInt = r.nextInt(weapon.length);
        return weapon[randInt];
    }

    private static String getRandomEnemyType(){
        Random r = new Random();
        int randInt = r.nextInt(enemyType.length);
        return enemyType[randInt];
    }

    private static String[] enemyType = {"Private", "Detective"};
    private static String[] weapon = {"Fusil", "Revolver", "Pistola", "Metralleta", "Lanza Granadas", "9mm"};

    private static void probarFacade(){
        CreditMarket creditMarket = new CreditMarket();
        creditMarket.showCreditBlack();
        creditMarket.showCreditGold();
        creditMarket.showCreditSilver();
    }

    private static void probarDecorator(){
        Credit gold = new Gold();

        Credit blackInternationalPayment = new Black();
        blackInternationalPayment = new InternationalPaymentDecorator(blackInternationalPayment);

        Credit goldSecureInternational = new Gold();
        goldSecureInternational = new InternationalPaymentDecorator(goldSecureInternational);
        goldSecureInternational = new SecureDecorator(goldSecureInternational);

        System.out.println("----Tarjeta Gold con configuración----");
        gold.showCredit();

        System.out.println("----Tarjeta Black con configuración----");
        blackInternationalPayment.showCredit();

        System.out.println("----Tarjeta Gold2 con configuración----");
        goldSecureInternational.showCredit();

    }

    private static void probarComposite(){
        CuentaComponent cuentaCorriente = new CuentaCorriente(1000.0, "Alberto");
        CuentaComponent cuentaAhorro = new CuentaAhorro(20000.0, "Alberto");

        CuentaComposite cuentaComposite = new CuentaComposite();
        cuentaComposite.addCuenta(cuentaCorriente);
        cuentaComposite.addCuenta(cuentaAhorro);

        cuentaComposite.showAccountName();
        cuentaComposite.getAmount();
    }

    private static void probarBridge(){
        com.design.patterns.structural.bridge.CreditCard classic = new ClassicCreditCard(new UnsecureCreditCard());
        classic.realizarPago();

        classic = new ClassicCreditCard(new SecureCreditCard());
        classic.realizarPago();
    }

    private static void probarAdapter(){
        com.design.patterns.structural.adapter.CreditCard creditCard = new com.design.patterns.structural.adapter.CreditCard();
        creditCard.pay("classic");
        creditCard.pay("gold");
        creditCard.pay("black");
        creditCard.pay("silver");
    }

    private static void probarVisitor(){
        OfertaElement ofertaElement = new OfertaGasolina();
        ofertaElement.accept(new BlackCreditCardVisitor());

        ofertaElement = new OfertaVuelos();
        ofertaElement.accept(new ClassicCreditCardVisitor());
    }

    private static void probarTemplateMethod(){
        com.design.patterns.behavioral.templatemethod.Payment payment = new Visa();
        payment.makePayment();

        payment = new Paypal();
        payment.makePayment();
    }

    private static void probarStrategy(){
        Context context = new Context(new CapitalStrategyTextFormatter());
        context.publishText("Este texto será convertido a MAYUSCULAS a través del algoritmo");

        context = new Context(new LowerStrategyTestFormatter());
        context.publishText("Esto texto SERA CONVERTIDO a MINUSCULAS a través del algortimo");
    }

    private static void probarInterpreter(){
        Expression cero = new TerminalExpression("0");
        Expression uno = new TerminalExpression("1");

        Expression containBoolean = new OrExpression(cero, uno);
        Expression containsOneAndCero = new AndExpression(cero, uno);

        System.out.println(containBoolean.interpret("cero"));
        System.out.println(containBoolean.interpret("0"));

        System.out.println(containsOneAndCero.interpret("0"));
        System.out.println(containsOneAndCero.interpret("0, 1"));
    }

    private static void probarState(){
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

    private static void probarObserver(){
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

    private static void probarMemento(){
        Carataker carataker = new Carataker();
        Article article = new Article("Alberto", "Memento es una pelicula");
        article.setText(article.getText() + " de Nolan");
        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());
        article.setText(article.getText() + " protagonizada por Guy Pearce");
        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());

        article.setText(article.getText() + " y Leonardo DiCaprio");
        System.out.println(article.getText());

        ArticleMemento memento1 = carataker.getMemento(0);
        ArticleMemento memento2 = carataker.getMemento(1);

        article.restoreMemento(memento1);
        System.out.println(article.getText());


        article.restoreMemento(memento2);
        System.out.println(article.getText());

        article.setText(article.getText() + " del año ");

    }

    private static void probarMediator(){
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
        ConcreteColleage2 user2 = new ConcreteColleage2(mediator);

        mediator.setUser1(user1);
        mediator.setUser2(user2);

        user1.send("Hola soy user1");
        user2.send("Hola user1, soy user2");
    }

    private static void probarIterator(){
        com.design.patterns.behavioral.iterator.Card[] cards = new com.design.patterns.behavioral.iterator.Card[5];
        cards[0] = new com.design.patterns.behavioral.iterator.Card("VISA");
        cards[1] = new com.design.patterns.behavioral.iterator.Card("AMEX");
        cards[2] = new com.design.patterns.behavioral.iterator.Card("MASTER CARD");
        cards[3] = new com.design.patterns.behavioral.iterator.Card("GOOGLE CARD");
        cards[4] = new com.design.patterns.behavioral.iterator.Card("APPLE CARD");

        List lista = new CardList(cards);
        Iterator iterator = lista.iterator();

        while (iterator.hasNext()){
            com.design.patterns.behavioral.iterator.Card tarjeta = (com.design.patterns.behavioral.iterator.Card)iterator.next();
            System.out.println(tarjeta.getType());
        }

    }



    private static void probarCommand(){
        CreditCard creditCard = new CreditCard();
        CreditCard creditCardDeactivate= new CreditCard();

        CreditCardInvoker invoker = new CreditCardInvoker();

        invoker.setCommand(new CreditCardActivateCommand(creditCard));
        invoker.run();
        System.out.println("--------------------");
        invoker.setCommand(new CreditCardDesactivateCommand(creditCardDeactivate));
        invoker.run();
    }

    private static void probarChainOfResponsability(){
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.crediCardRequest(100000);
    }

    private static void probarSinglenton(){
        com.design.patterns.creational.singlenton.Card.getINSTANCE().setCardNumber("1234-1234-1234-1324");
        System.out.println(com.design.patterns.creational.singlenton.Card.getINSTANCE().getCardNumber());
    }

    private static void probarPrototype(){
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

    private static void probarBuilder(){
        com.design.patterns.creational.builder.Card card = new com.design.patterns.creational.builder.Card.CardBuilder("VISA",
                "0000 1111 2222 3333")
                .name("Alberto")
                .expires(2030)
                .credit(true)
                .build();

        System.out.println(card);

        com.design.patterns.creational.builder.Card card2 = new com.design.patterns.creational.builder.Card.CardBuilder("AMEX",
                "9999 9999 9999 9999")
                .build();

        System.out.println(card2);
    }

    private static void probarAbstractFactory(){
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        com.design.patterns.creational.abstractfactory.Card tarjeta = (com.design.patterns.creational.abstractfactory.Card) abstractFactory.create("VISA");

        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("DEBIT");

        System.out.println("Un tarjeta de tipo: " + tarjeta.getCardType() + " con el metodo de pago: " + paymentMethod.doPayment());
    }

    private static void probarFactoryMethod(){
        com.design.patterns.creational.factorymethod.Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
    }
}
