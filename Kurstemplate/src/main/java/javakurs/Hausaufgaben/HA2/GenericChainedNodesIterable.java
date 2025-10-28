package javakurs.Hausaufgaben.HA2;

import java.util.Iterator;

public class GenericChainedNodesIterable<TYPE> extends GenericChainedNodes<TYPE> implements Iterable<TYPE>
{
    public GenericChainedNodesIterable(TYPE data)
    {
        super(data);
    }

    public static void main(String[] args)
    {
        final GenericChainedNodesIterable<String> f1 = new GenericChainedNodesIterable<>("Start");
        final GenericChainedNodesIterable<String> f2 = new GenericChainedNodesIterable<>("Mitte");
        final GenericChainedNodesIterable<String> f3 = new GenericChainedNodesIterable<>("Ende");
        f1.setNextNode(f2).setNextNode(f3);

        for (final String nextElement : f1)
        {
            System.out.println(nextElement);
        }
    }

    @Override
    public Iterator<TYPE> iterator()
    {
        final GenericChainedNodesIterable<TYPE> me = this;
        return new Iterator<>()
        {
            GenericChainedNodes<TYPE> currentNode = me;
            @Override
            public boolean hasNext()
            {
                return currentNode != null;
            }

            @Override
            public TYPE next()
            {
                TYPE value = currentNode.getData();
                currentNode = currentNode.getNextNode();
                return value;
            }
        };

    }
}

