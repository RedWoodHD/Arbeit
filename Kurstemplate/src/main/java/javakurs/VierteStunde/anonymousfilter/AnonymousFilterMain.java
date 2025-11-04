package javakurs.VierteStunde.anonymousfilter;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class AnonymousFilterMain
{
   private AnonymousFilterMain()
   {
      throw new IllegalStateException("keine Instanzen von Main-Klassen erlaubt");
   }

   public static void main(String[] args)
   {
      final List<Integer> integerList = new ArrayList<>();
      for(int i = 0; i <= 20; i++)
      {
         integerList.add(i);
      }

      exampleTask(integerList);
      task1(integerList);
      task2(integerList);
      task3(integerList);
      task4(integerList);
      task5(integerList);
   }

   /**
    * Filtere alle Zahlen heraus, die größer gleich 5 und kleiner gleich 10 sind
    */
   private static void exampleTask(final List<Integer> integerList)
   {
      final List<Integer> onlyNumbersBetween5And10 = ListFilterUtil.filterList(
         integerList, new AnonymousFilter()
         {
            @Override
            protected boolean filter1(int elementToCheck)
            {
               return elementToCheck >= 5;
            }

            @Override
            protected boolean filter2(int elementToCheck)
            {
               return elementToCheck <= 10;
            }

            @Override
            protected FilterConjunctionEnum filterConjunction()
            {
               return FilterConjunctionEnum.AND;
            }
         });

      AnonymousFilterTest.checkTask0(onlyNumbersBetween5And10);
   }

   /**
    * Filtere alle Zahlen heraus, die ungerade sind und kleiner als 10 sind
    */
   private static void task1(final List<Integer> integerList)
   {
      final List<Integer> unevenNumbersSmallerThan10 = ListFilterUtil.filterList(integerList, new AnonymousFilter()
      {
         @Override
         protected boolean filter1(int elementToCheck)
         {
            return  elementToCheck %2 != 0;
         }

         @Override
         protected boolean filter2(int elementToCheck)
         {
            return elementToCheck <=10;
         }

         @Override
         protected FilterConjunctionEnum filterConjunction()
         {
            return FilterConjunctionEnum.AND;
         }
      }); //null mit AnonymousFilter ersetzen
      AnonymousFilterTest.checkTask1(unevenNumbersSmallerThan10);
   }

   /**
    * Filtere alle Zahlen heraus, die durch 5 teilbar sind aber nicht durch 10 teilbar sind
    */
   private static void task2(final List<Integer> integerList)
   {
      final List<Integer> dividableBy5ButNotBy10 = ListFilterUtil.filterList(integerList, new AnonymousFilter()
      {
         @Override
         protected boolean filter1(int elementToCheck)
         {
            return elementToCheck % 5 != 0 ;
         }

         @Override
         protected boolean filter2(int elementToCheck)
         {
            return elementToCheck % 10 != 0;
         }

         @Override
         protected FilterConjunctionEnum filterConjunction()
         {
            return FilterConjunctionEnum.XOR;
         }
      }); //null mit AnonymousFilter ersetzen
      AnonymousFilterTest.checkTask2(dividableBy5ButNotBy10);
   }

   /**
    * Filtere alle Zahlen heraus, dessen Quersumme größer als 8 ist
    */
   private static void task3(final List<Integer> integerList)
   {
      final List<Integer> digitSumBiggerThan8 = ListFilterUtil.filterList(integerList, new AnonymousFilter()
      {
         @Override
         protected boolean filter1(int elementToCheck)
         {
            return getQueersumme(elementToCheck) > 8;
         }

         private int getQueersumme(int number)
         {
            String numberString = Integer.toString(number);
            char[] numbers =numberString.toCharArray();

            int sum=0;
            for (int i = 0; i < numberString.length(); i++)
            {
                sum = Integer.parseInt(String.valueOf(numbers[i])) + sum;
            }
            return sum;
         }

         @Override
         protected boolean filter2(int elementToCheck)
         {
            return false;
         }

         @Override
         protected FilterConjunctionEnum filterConjunction()
         {
            return FilterConjunctionEnum.OR;
         }
      }); //null mit AnonymousFilter ersetzen
      AnonymousFilterTest.checkTask3(digitSumBiggerThan8);
   }

   /**
    * Filtere alle Zahlen heraus, dessen Wurzel größer als 4 ist oder durch 9 teilbar ist, aber nicht beides
    */
   private static void task4(final List<Integer> integerList)
   {
      final List<Integer> squareRootBiggerThan4XorDividableBy9 = ListFilterUtil.filterList(integerList, null); //null mit AnonymousFilter ersetzen
      AnonymousFilterTest.checkTask4(squareRootBiggerThan4XorDividableBy9);
   }

   /**
    * Filtere alle Zahlen heraus, wo entweder <br>
    * 1.) Jede Ziffer kleiner als 3 oder <br>
    * 2.) Jede Ziffer größer als 7 ist
    */
   private static void task5(final List<Integer> integerList)
   {
      final List<Integer> allDigitsSmallerThan3OrBiggerThan7 = ListFilterUtil.filterList(integerList, null); //null mit AnonymousFilter ersetzen
      AnonymousFilterTest.checkTask5(allDigitsSmallerThan3OrBiggerThan7);
   }
}
