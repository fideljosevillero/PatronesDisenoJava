package com.design.patterns.structural.flyweight;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class FlyweigthTest {
    //@Test
    void testFlyweigth(){
        for(int i=0; i<15; i++){
            Enemy enemy = EnemyFactory.getEnemy(getRandomEnemyType());
            enemy.setWeapon(getRandomWeapon());
            enemy.lifePoints();
        }
    }

    private String getRandomWeapon(){
        Random r = new Random();
        //int randInt = r.nextInt(weapon.length);
        return ""; //weapon[randInt];
    }

    private String getRandomEnemyType(){
        Random r = new Random();
        //int randInt = r.nextInt(enemyType.length);
        return ""; //enemyType[randInt];
    }

}
