package javakurs.ErsteStunde.getränke;

import javakurs.ErsteStunde.gefäß.Gefäß;

public abstract class Getränk
{
    protected double temperatur;
    protected double menge;
    protected boolean zucker;
    private Gefäß gefäß;

    protected Getränk(double temperatur, double menge, boolean zucker, Gefäß gefäß)
    {
        this.gefäß = gefäß;
        gefäß.setGetränk(this);
        this.temperatur = temperatur;
        this.menge = menge;
        this.zucker = zucker;
    }
}
