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

    public TYPE_1 getElement1()
    {
        GenericTask1 copy = new GenericTask1(element1, element2);
        return (TYPE_1) copy.element1;
    }

    public TYPE_2 getElement2()
    {
        GenericTask1 copy = new GenericTask1(element1, element2);
        return (TYPE_2) copy.element2;
    }

    static <T1, T2 extends T1> GenericTask1<T1, T2> of(T1 element1, T2 element2)
    {
        return new GenericTask1<>(element1, element2);
    }

    static <TYPE_1, TYPE_2> TYPE_1 returnElement1(GenericTask1<TYPE_1, TYPE_2> genericTask1)
    {
        return genericTask1.element1;
    }

}
