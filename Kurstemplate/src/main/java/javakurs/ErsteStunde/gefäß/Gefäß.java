package javakurs.ErsteStunde.gefäß;

import javakurs.ErsteStunde.getränke.Getränk;

public abstract class Gefäß
{
    private Getränk getränk;

    public Gefäß setGetränk(Getränk getränk)
    {
        this.getränk = getränk;
        return this;
    }
}
