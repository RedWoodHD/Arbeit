package javakurs;

import lombok.Getter;
import lombok.Setter;

public class HelloKurs
{
   @Getter
   @Setter
   private int something;
   public static void main(String[] args)
   {
      final HelloKurs helloKurs = new HelloKurs();
      helloKurs.setSomething(12);
      System.out.println("Hello Kurs " + helloKurs.getSomething());
   }
}
