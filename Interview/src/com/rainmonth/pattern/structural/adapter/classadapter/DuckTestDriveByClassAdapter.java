
package com.rainmonth.pattern.structural.adapter.classadapter;


import com.rainmonth.pattern.structural.adapter.Duck;
import com.rainmonth.pattern.structural.adapter.MallardDuck;
import com.rainmonth.pattern.structural.adapter.WildTurkey;

public class DuckTestDriveByClassAdapter {

    public static void main(String[] args) {

        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck fakeDuck = new TurkeyClassAdapter();

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(duck);

        System.out.println("\nThe fake Duck says...");
        testDuck(fakeDuck);
        
    }

    public static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
