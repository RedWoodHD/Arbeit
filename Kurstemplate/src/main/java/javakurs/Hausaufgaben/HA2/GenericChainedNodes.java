package javakurs.Hausaufgaben.HA2;

/**
 * This class contains an element and links to another class
 */
@SuppressWarnings("LombokGetterMayBeUsed")
public class GenericChainedNodes<TYPE>
{
   private final TYPE data;
   private GenericChainedNodes<TYPE> nextNode;

   public GenericChainedNodes(TYPE data)
   {
      this.data = data;
   }

   /**
    * Retrieves the current element in this ChainedList
    */
   public TYPE getData()
   {
      return data;
   }

   /**
    * Retrieves the next element in this ChainedList. Returns null if this is the end of the chain.
    */
   public GenericChainedNodes<TYPE> getNextNode()
   {
      return nextNode;
   }

   /**
    * Changes the next element in this ChainedList.
    */
   public GenericChainedNodes<TYPE> setNextNode(GenericChainedNodes<TYPE> nextNode)
   {
      this.nextNode = nextNode;
      return nextNode;
   }

   /**
    * Returns true if and only if this ChainedList contains more nested elements
    */
   public boolean hasNextNode()
   {
      return nextNode != null;
   }

   /**
    * Prints all this and all nested nodes into the console
    */
   public void printAllNodes()
   {
      System.out.println(data);
      if(nextNode != null)
      {
         nextNode.printAllNodes();
      }
   }
}
