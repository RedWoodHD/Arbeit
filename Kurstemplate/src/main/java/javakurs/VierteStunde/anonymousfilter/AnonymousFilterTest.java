package javakurs.VierteStunde.anonymousfilter;

import java.util.List;
import java.util.Objects;

/**
 * Utility-Klasse, ob die anonyme-Klassen-Übungsaufgaben korrekt gelöst wurden
 */
public final class AnonymousFilterTest
{
   private AnonymousFilterTest()
   {
      throw new IllegalStateException("keine Instanzen von Utility-Klassen erlaubt");
   }

   /**
    * Überprüft, ob Aufgabe 0 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask0(final List<Integer> listToCheck)
   {
      checkTask(List.of(5, 6, 7, 8, 9, 10), listToCheck, 0);
   }

   /**
    * Überprüft, ob Aufgabe 1 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask1(final List<Integer> listToCheck)
   {
      checkTask(List.of(1, 3, 5, 7, 9), listToCheck, 1);
   }

   /**
    * Überprüft, ob Aufgabe 2 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask2(final List<Integer> listToCheck)
   {
      checkTask(List.of(5, 15), listToCheck, 2);
   }

   /**
    * Überprüft, ob Aufgabe 3 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask3(final List<Integer> listToCheck)
   {
      checkTask(List.of(9, 18, 19), listToCheck, 3);
   }

   /**
    * Überprüft, ob Aufgabe 4 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask4(final List<Integer> listToCheck)
   {
      checkTask(List.of(0, 9, 17, 19, 20), listToCheck, 4);
   }

   /**
    * Überprüft, ob Aufgabe 5 korrekt gelöst wurde.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    */
   public static void checkTask5(final List<Integer> listToCheck)
   {
      checkTask(List.of(0, 1, 2, 8, 9, 10, 11, 12, 20), listToCheck, 5);
   }

   /**
    * Überprüft, ob die übergebenen Werte korrekt sind.
    * expected1 und actual1, sowie expected2 und actual2 müssen gleich sein.
    * Eine Log-Ausgabe verkündet das Ergebnis der Überprüfung.
    *
    * @param expectedList erwartetes Ergebnis
    * @param actualList   tatsächliches Ergebnis
    * @param taskNo       Die vie viel-te Aufgabe es ist
    */
   private static void checkTask(final List<Integer> expectedList, final List<Integer> actualList, final int taskNo)
   {
      if(expectedList == null || actualList == null)
      {
         System.err.println("[AUFGABE " + taskNo + "] FEHLER: Die Liste darf nicht null sein");
         return;
      }

      if(expectedList.size() != actualList.size())
      {
         printListNotMatchingError(expectedList, actualList, taskNo);
         return;
      }

      for(int i = 0; i < expectedList.size(); i++)
      {
         if(!Objects.equals(expectedList.get(i), actualList.get(i)))
         {
            printListNotMatchingError(expectedList, actualList, taskNo);
            return;
         }
      }

      System.out.println("[AUFGABE " + taskNo + "] Die Lösung " + actualList + " ist korrekt");
   }

   private static void printListNotMatchingError(final List<Integer> expectedList, final List<Integer> actualList, final int taskNo)
   {
      System.err.println("[AUFGABE " + taskNo + "] FEHLER: Abweichungen in der Liste" +
                         "\nExpected: " + expectedList +
                         "\nActual:   " + actualList);
   }
}
