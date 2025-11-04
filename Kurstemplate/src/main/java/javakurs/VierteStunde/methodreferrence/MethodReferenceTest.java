package javakurs.VierteStunde.methodreferrence;

import java.util.List;
import java.util.function.Supplier;

/**
 * Utility-Klasse, ob die Methodenreferenz-Übungsaufgaben korrekt gelöst wurden
 */
public final class MethodReferenceTest
{
   private MethodReferenceTest()
   {
      throw new IllegalStateException("keine Instanzen von Util-Klassen erlaubt");
   }

   /**
    * Überprüft, ob Aufgabe 0 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask0(final Integer actual1, final Integer actual2)
   {
      checkTask(4, actual1, -9, actual2, 0);
   }

   /**
    * Überprüft, ob Aufgabe 1 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask1(final Integer actual1, final Integer actual2)
   {
      checkTask(4, actual1, -9, actual2, 1);
   }

   /**
    * Überprüft, ob Aufgabe 2 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask2(final Double actual1, final Double actual2)
   {
      checkTask(3.0, actual1, 4.0, actual2, 2);
   }

   /**
    * Überprüft, ob Aufgabe 3 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask3(final Integer actual1, final Integer actual2)
   {
      checkTask(13, actual1, 8, actual2, 3);
   }

   /**
    * Überprüft, ob Aufgabe 4 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask4(final Supplier<Integer> actual1, final Supplier<Integer> actual2)
   {
      if(actual1 == null || actual2 == null)
      {
         checkTask(15, null, 10, null, 4);
      }
      else
      {
         checkTask(15, actual1.get(), 10, actual2.get(), 4);
      }
   }

   /**
    * Überprüft, ob die übergebenen Werte korrekt sind.
    * expected1 und actual1, sowie expected2 und actual2 müssen gleich sein.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    *
    * @param expected1 erwartetes 1. Ergebnis
    * @param actual1   tatsächliches 1. Ergebnis
    * @param expected2 erwartetes 2. Ergebnis
    * @param actual2   tatsächliches 2. Ergebnis
    * @param taskNo    Die vie viel-te Aufgabe es ist
    */
   private static void checkTask(final Object expected1, final Object actual1, final Object expected2, final Object actual2, final int taskNo)
   {
      if(expected1 == null || actual1 == null || expected2 == null || actual2 == null)
      {
         System.err.println("[AUFGABE " + taskNo + "] FEHLER: Die Lösung darf nicht null sein");
         return;
      }

      final boolean solvedCorrectly = expected1.equals(actual1) && expected2.equals(actual2);
      final List<Object> expectedList = List.of(expected1, expected2);
      final List<Object> actualList = List.of(actual1, actual2);

      if(solvedCorrectly)
      {
         System.out.println("[AUFGABE " + taskNo + "] Die Lösung " + actualList + " ist korrekt");
      }
      else
      {
         System.err.println("[AUFGABE " + taskNo + "] FEHLER: Abweichungen in der Lösung" +
                            "\nExpected: " + expectedList +
                            "\nActual:   " + actualList);
      }
   }
}
