package javakurs.VierteStunde.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class LambdaMain
{
   private LambdaMain()
   {
      throw new IllegalStateException("keine Instanzen von Main-Klassen erlaubt");
   }

   public static void main(String[] args)
   {
      exampleTask();
      task1();
      task2();
      task3();
      task4();
      task5();
      task6();
      task7();
   }

   /**
    * Benutze die Klasse {@link Function}, um einen String zu einem Integer zu mappen
    */
   private static void exampleTask()
   {
      final String s1 = "4";
      final String s2 = "-9";

      final Function<String, Integer> stringToIntegerConverter = string -> Integer.parseInt(string);

      final Integer i1 = stringToIntegerConverter.apply(s1);
      final Integer i2 = stringToIntegerConverter.apply(s2);

      LambdaTest.checkTask0(i1, i2);
   }

   /**
    * Benutze die Klasse {@link BiFunction}, um zwei Doubles zu addieren
    */
   private static void task1()
   {
      final Double i1a = 4.2;
      final Double i1b = 8.8;

      final Double i2a = 7.5;
      final Double i2b = 0.5;

      final BiFunction<Double, Double, Integer> doubleAdder = (aDouble, aDouble2) -> (int) (aDouble + aDouble2);

      final Integer i1 = doubleAdder.apply(i1a,i1b); //addiere i1a und i1b
      final Integer i2 = doubleAdder.apply(i2a,i2b); //addiere i2a und i2b

      LambdaTest.checkTask1(i1, i2);
   }

   /**
    * Benutze die Klasse {@link TriFunction}, um drei Doubles zu addieren.
    * Die Klasse TriFunction ist nicht in normalen Java vorhanden und muss daher implementiert werden
    */
   private static void task2()
   {
      final Double d1a = 4.2;
      final Double d1b = 8.8;
      final Double d1c = 5.0;

      final Double d2a = 7.5;
      final Double d2b = 0.5;
      final Double d2c = 8.0;

      final TriFunction<Double, Double, Double, Integer> doubleAdder  = (aDouble, aDouble2,aDouble3) -> (int) (aDouble + aDouble2 + aDouble3);;

      final Integer i1 = doubleAdder.apply(d1a,d1b,d1c); //addiere d1a, d1b und d1c
      final Integer i2 = doubleAdder.apply(d2a,d2b,d2c); //addiere d2a, d2b und d2c

      LambdaTest.checkTask2(i1, i2);
   }

   private interface TriFunction<T, U, V, R>
   {
       R apply(T t, U u,V v);
   }

   /**
    * Extrahiere den Integer aus dem {@link Task3Record}
    */
   private static void task3()
   {
      final Task3Record o1 = new Task3Record(13);
      final Task3Record o2 = new Task3Record(-18);

      final IntegerExtractor<Task3Record, Integer> intExtractor = (t3) -> t3.i;

      final Integer i1 = intExtractor.extract(o1);
      final Integer i2 = intExtractor.extract(o2);

      LambdaTest.checkTask3(i1, i2);
   }

   private record Task3Record(Integer i)
   {
   }

   private interface IntegerExtractor<T, R>
   {
      R extract(T t);
   }

   /**
    * Benutze die Klasse {@link Predicate}, um zu überprüfen, ob ein Integer eine gerade Zahl ist
    */
   private static void task4()
   {
      final Integer i1 = 3;
      final Integer i2 = 4;

      final Predicate<Integer> evenNumberPredicate = (number) -> number%2 == 0;

      final Boolean b1 = evenNumberPredicate.test(i1);
      final Boolean b2 = evenNumberPredicate.test(i2);

      LambdaTest.checkTask4(b1, b2);
   }

   /**
    * Benutze die Klasse {@link Predicate}, um zu überprüfen, ob ein Integer eine gerade Zahl ist und größer als 5 ist.
    * Benutze {@link Predicate#and(Predicate)} für die jeweiligen Abfragen.
    */
   private static void task5()
   {
      final Integer i1 = 6;
      final Integer i2 = 4;

      final Predicate<Integer> evenNumberPredicate = (number) -> number %2 ==0;
      final Predicate<Integer> biggerThan5Predicate = (number) -> number > 5;
      final Predicate<Integer> combinedPredicate = (number) -> evenNumberPredicate.test(number) && biggerThan5Predicate.test(number);

      final Boolean b1 = combinedPredicate.test(i1);
      final Boolean b2 = combinedPredicate.test(i2);

      LambdaTest.checkTask5(b1, b2);
   }

   /**
    * Benutze die Klasse {@link Predicate}, um zu überprüfen, ob ein Integer eine gerade Zahl ist.
    * Für b2 soll das Predicate aus b1 negiert werden. Dafür gibt es in der Predicate-Klasse eine Methode, die genau dies implementiert.
    */
   private static void task6()
   {
      final Integer i1and2 = 6;

      final Predicate<Integer> evenNumberPredicate = null;
      final Predicate<Integer> evenNumberPredicateNegated = null;

      final Boolean b1 = null;
      final Boolean b2 = null;

      LambdaTest.checkTask6(b1, b2);
   }

   /**
    * Benutze die Klasse {@link Supplier}, um dir den Integer 6 und den Boolean true zu generieren
    */
   private static void task7()
   {
      final Supplier<Integer> number6Supplier = () -> 6;
      final Supplier<Boolean> booleanTrueSupplier = () -> true;

      final Integer i = number6Supplier.get();
      final Boolean b = booleanTrueSupplier.get();

      LambdaTest.checkTask7(i, b);
   }
}
