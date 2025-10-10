package javakurs.dritte_stunde.generic;

public class Typ
{
    int integer;
    String  String;
    double doublee;

    public Typ setInteger(int integer)
    {
        this.integer = integer;
        return this;
    }

    public Typ setString(String string)
    {
        String = string;
        return this;
    }

    public Typ setDoublee(double doublee)
    {
        this.doublee = doublee;
        return this;
    }
}
