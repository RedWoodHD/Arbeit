package javakurs.ErsteStunde.getränke;

import javakurs.ErsteStunde.gefäß.Gefäß;

public class Tee extends Heißgetränk
{
    private String sorte;
    private int ziehzeit;

    public Tee(double temperatur, double menge, boolean zucker, Gefäß gefäß)
    {
        super(temperatur, menge, zucker, gefäß);
    }
}
