package javakurs.VierteStunde.anonymousfilter;

public enum FilterConjunctionEnum
{
   /**
    * Filter 1 und Filter 2 müssen true zurückgeben, damit der Wert gefiltert wird
    */
   AND,

   /**
    * Filter 1 oder Filter 2 müssen true zurückgeben, damit der Wert gefiltert wird
    */
   OR,

   /**
    * Filter 1 oder Filter 2, aber nicht beide gleichzeitig, müssen true zurückgeben, damit der Wert gefiltert wird
    */
   XOR
}
