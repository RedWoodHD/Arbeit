package javakurs.ErsteStunde.getränke;

import javakurs.ErsteStunde.gefäß.Gefäß;

public abstract class Heißgetränk extends Getränk
{
    public Heißgetränk(double temperatur, double menge, boolean zucker, Gefäß gefäß)
    {
        super(temperatur, menge, zucker,gefäß);
    }

    public boolean erwärmen(double temperatur)
    {
        temperatur = temperatur * 2;
        temperatur -= 10;
        temperatur = temperatur + (temperatur* 0.26);
        return true;
    }


}
