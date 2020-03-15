package com.design.patterns.behavioral.memento;

import org.junit.jupiter.api.Test;

public class MementoTest {
    @Test
    void testMemento(){
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
}
