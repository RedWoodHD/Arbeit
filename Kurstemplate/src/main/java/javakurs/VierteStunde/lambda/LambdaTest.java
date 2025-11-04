package javakurs.VierteStunde.lambda;

import java.util.List;

/**
 * Utility-Klasse, ob die Lambda-Übungsaufgaben korrekt gelöst wurden
 */
public final class LambdaTest
{
   private LambdaTest()
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
      checkTask(13, actual1, 8, actual2, 1);
   }

   /**
    * Überprüft, ob Aufgabe 2 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask2(final Integer actual1, final Integer actual2)
   {
      checkTask(18, actual1, 16, actual2, 2);
   }

   /**
    * Überprüft, ob Aufgabe 3 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask3(final Integer actual1, final Integer actual2)
   {
      checkTask(13, actual1, -18, actual2, 3);
   }

   /**
    * Überprüft, ob Aufgabe 4 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask4(final Boolean actual1, final Boolean actual2)
   {
      checkTask(false, actual1, true, actual2, 4);
   }

   /**
    * Überprüft, ob Aufgabe 5 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask5(final Boolean actual1, final Boolean actual2)
   {
      checkTask(true, actual1, false, actual2, 5);
   }

   /**
    * Überprüft, ob Aufgabe 6 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask6(final Boolean actual1, final Boolean actual2)
   {
      checkTask(true, actual1, false, actual2, 6);
   }

   /**
    * Überprüft, ob Aufgabe 7 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask7(final Integer actual1, final Boolean actual2)
   {
      checkTask(6, actual1, true, actual2, 7);
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
