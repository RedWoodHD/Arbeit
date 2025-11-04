package javakurs.VierteStunde.anonymousfilter;

import java.util.ArrayList;
import java.util.List;

public final class ListFilterUtil
{
   private ListFilterUtil()
   {
      throw new IllegalStateException("keine Instanzen von Utility-Klassen erlaubt");
   }

   /**
    * Jeder Integer wird überprüft basierend auf den Einstellungen aus dem Filter.
    * Die Integer, welcher die Bedingungen aus dem Filter entsprechen, werden zurückgegeben, die anderen nicht.
    *
    * @param inputList Eine Liste mit integern, die gefiltert werden sollen
    * @param filter    Filtereinstellungen
    * @return gefilterte Integer aus der inputList
    */
   public static List<Integer> filterList(final List<Integer> inputList, final AnonymousFilter filter)
   {
      if(filter == null)
      {
         return null;
      }

      final List<Integer> resultList = new ArrayList<>();
      for(final int element : inputList)
      {
         if(FilterConjunctionEnum.AND == filter.filterConjunction())
         {
            if(filter.filter1(element) && filter.filter2(element))
            {
               resultList.add(element);
            }
         }
         else if(FilterConjunctionEnum.OR == filter.filterConjunction())
         {
            if(filter.filter1(element) || filter.filter2(element))
            {
               resultList.add(element);
            }
         }
         else if(FilterConjunctionEnum.XOR == filter.filterConjunction())
         {
            if(filter.filter1(element) ^ filter.filter2(element))
            {
               resultList.add(element);
            }
         }
      }
      return resultList;
   }
}
