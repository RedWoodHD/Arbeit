package javakurs.Hausaufgaben.HA2;

import java.util.Arrays;

@SuppressWarnings("LombokGetterMayBeUsed")
public class GenericTask2<TYPE extends Comparable<TYPE>>
{
   private final TYPE[] array;

   public GenericTask2(final TYPE[] array)
   {
      this.array = array;
   }

   public TYPE[] getType()
   {
      return array;
   }

   public void sort()
   {
      //hier das Array sortieren
      Arrays.sort(array);
   }
}
