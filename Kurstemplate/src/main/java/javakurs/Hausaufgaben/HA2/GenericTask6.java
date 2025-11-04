package javakurs.Hausaufgaben.HA2;

// @formatter:off
public class GenericTask6<TYPE extends GenericTask6.Animal & GenericTask6.Pet>
{
   private TYPE object;

   public static void main(String[] args)
   {
      final GenericTask6<Cat> cat = new GenericTask6<>();
      final GenericTask6<Dog> dog = new GenericTask6<>();
//      final GenericTask6<Lion> lion = new GenericTask6<>(); //kein Pet
//      final GenericTask6<NonAnimal> nonAnimal = new GenericTask6<>(); //kein Animal
   }

   static class Cat extends Animal implements Pet {}

   static class Dog extends Animal implements Pet {}

   static class Lion extends Animal {}

   static class NonAnimal implements Pet {}

   abstract static class Animal {}

   interface Pet {}
}
