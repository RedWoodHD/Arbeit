package javakurs.DritteStunde.Generic;

public class ObjectVixen extends ObjectFox<Integer>
{
    public ObjectVixen(int number, ObjectFox<Integer> nachfolger)
    {
        super(number, nachfolger);
    }
}
