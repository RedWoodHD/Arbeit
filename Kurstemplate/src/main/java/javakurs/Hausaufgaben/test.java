package javakurs.Hausaufgaben;

import javakurs.Hausaufgaben.HA2.GenericTask1;

public class test
{
    public static void main(String[] args)
    {
        System.out.println("Test");
        GenericTask1<String, String> genericTask1 = new GenericTask1<>("String","String");

        System.out.println(genericTask1.getElement1());
        System.out.println(genericTask1.getElement2());

    }
}
