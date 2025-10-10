package javakurs.Hausaufgaben.HA2;

@SuppressWarnings("LombokGetterMayBeUsed")
public class GenericTask1<TYPE_1, TYPE_2>
{
   private final TYPE_1 element1;
   private final TYPE_2 element2;

   public GenericTask1(final TYPE_1 element1, final TYPE_2 element2)
   {
      this.element1 = element1;
      this.element2 = element2;
   }
}
