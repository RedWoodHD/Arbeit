package javakurs.VierteStunde.methodreferrence;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class MethodReferenceMain
{
   private MethodReferenceMain()
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
   }

   /**
    * Benutze die Klasse {@link Function}, um einen String zu einem Integer zu mappen
    */
   private static void exampleTask()
   {
      final String s1 = "4";
      final String s2 = "-9";

      final Function<String, Integer> stringToIntegerConverter = Integer::parseInt;

      final Integer i1 = stringToIntegerConverter.apply(s1);
      final Integer i2 = stringToIntegerConverter.apply(s2);

      MethodReferenceTest.checkTask0(i1, i2);
   }

   /**
    * Benutze die Klasse {@link Function}, um einen String zu einem Integer zu mappen.
    * Implementiere die Function, indem du eine Methodenreferenz auf {@link #customParseIntImplementation(String)} verweist.
    */
   private static void task1()
   {
      final String s1 = "4";
      final String s2 = "-9";

      final Function<String, Integer> stringToIntegerConverter = MethodReferenceMain::customParseIntImplementation;

      final Integer i1 = stringToIntegerConverter.apply(s1);
      final Integer i2 = stringToIntegerConverter.apply(s2);

      MethodReferenceTest.checkTask1(i1, i2);
   }

   private static int customParseIntImplementation(final String stringToConvert)
   {
      return Integer.parseInt(stringToConvert);
   }

   /**
    * Benutze die Klasse {@link Function}, um die Wurzel von einem Integer zu berechnen
    * Implementiere die Function per Methodenreferenz auf {@link SquareRootCalculator#calculateSquareRoot()}.
    */
   private static void task2()
   {
      final SquareRootCalculator i1 = new SquareRootCalculator(9);
      final SquareRootCalculator i2 = new SquareRootCalculator(16);

      final Function<SquareRootCalculator, Double> squareRootCalculatorFunction = SquareRootCalculator::calculateSquareRoot;

      final Double d1 = squareRootCalculatorFunction.apply(i1);
      final Double d2 = squareRootCalculatorFunction.apply(i2);

      MethodReferenceTest.checkTask2(d1, d2);
   }

   private record SquareRootCalculator(int i)
   {
      private double calculateSquareRoot()
      {
         return Math.sqrt(i);
      }
   }

   /**
    * Benutze die Klasse {@link BiFunction}, um zwei Doubles zu addieren
    * Schreibe selber eine Methode und implementiere die BiFunction per Methodenreferenz.
    */
   private static void task3()
   {
      final Double i1a = 4.2;
      final Double i1b = 8.8;
      final Double i2a = 7.5;
      final Double i2b = 0.5;

      final BiFunction<Double, Double, Integer> doubleAdder = MethodReferenceMain::doubleCalculate;

      final Integer i1 = doubleAdder.apply(i1a,i1b);
      final Integer i2 = doubleAdder.apply(i2a,i2b);

      MethodReferenceTest.checkTask3(i1, i2);
   }
   public static int doubleCalculate(final double n1, final double n2){
      return (int) (n1+n2);
   }

     /**
    * Benutze die Klasse {@link TriFunction}, um die drei Doubles zu addieren.
    * Das Ergebnis soll als Supplier zurückgegeben werden.
    * Der Supplier kann beliebig erzeugt werden.
    */
   private static void task4()
   {
      final Double d1a = 9.5;
      final Double d1b = 3.5;
      final Double d1c = 2.0;

      final Double d2a = 4.5;
      final Double d2b = 3.5;
      final Double d2c = 2.0;

      final TriFunction triFunction = null;

      final Supplier<Integer> c1 = null; //addiere d1a, d1b und d1c
      final Supplier<Integer> c2 = null; //addiere d2a, d2b und d2c

      javakurs.VierteStunde.methodreferrence.MethodReferenceTest.checkTask4(c1, c2);
   }

   @FunctionalInterface
   private interface TriFunction
   {
      Integer calculate(final Double a, final Double b, final Double c);
   }


   /**
    * Benutze einen {@link Consumer}, um den Integer in die Konsole auszugeben. Benutze hierfür eine Methodenreferenz.
    * Schreibe keine eigene Methode. Verwende eine, die es schon gibt.
    */
   private static void task5()
   {
      final Integer i1 = 6;
      final Integer i2 = -2;

      final Consumer<Integer> integerPrinter = System.out::println;

      //Hier der Code für den Aufruf des integerPrinters:
      integerPrinter.accept(i1);
      integerPrinter.accept(i2);
   }

}
