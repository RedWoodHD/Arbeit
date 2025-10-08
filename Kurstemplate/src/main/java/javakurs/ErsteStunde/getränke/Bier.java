package javakurs.ErsteStunde.getränke;

import javakurs.ErsteStunde.gefäß.Gefäß;

public class Bier extends Getränk implements AlkoholischesGetränk
{
    private double alkoholgehalt;

    protected Bier(double temperatur, double menge, boolean zucker, Gefäß gefäß)
    {
        super(temperatur, menge, zucker, gefäß);
    }

    @Override
    public double getAlkoholgehalt()
    {
        return alkoholgehalt;
    }
}
