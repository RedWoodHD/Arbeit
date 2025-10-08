package javakurs.ErsteStunde.getränke;

import javakurs.ErsteStunde.gefäß.Gefäß;

public class Glühwein extends Heißgetränk implements AlkoholischesGetränk
{
    private double alkoholgehalt;

    public Glühwein(double temperatur, double menge, boolean zucker, Gefäß gefäß)
    {
        super(temperatur, menge, zucker, gefäß);
    }

    @Override
    public double getAlkoholgehalt()
    {
        return alkoholgehalt;
    }
}
