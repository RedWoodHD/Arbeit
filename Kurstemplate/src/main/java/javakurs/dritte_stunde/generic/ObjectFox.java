package javakurs.dritte_stunde.generic;

public class ObjectFox<E extends Number>
{
    E element;
    ObjectFox<E> nachfolger;

    public ObjectFox(E element, ObjectFox<E> nachfolger)
    {
        this.element = element;
        this.nachfolger = nachfolger;
    }
}
