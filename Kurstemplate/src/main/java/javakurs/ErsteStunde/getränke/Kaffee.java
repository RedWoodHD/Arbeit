package javakurs.ErsteStunde.getränke;

import javakurs.ErsteStunde.gefäß.Gefäß;

public class Kaffee extends Heißgetränk
{
    protected String herkunft;

    public Kaffee(double temperatur, double menge, boolean zucker, String herkunft, Gefäß gefäß)
    {
        super(temperatur, menge, zucker,gefäß);
        this.herkunft = herkunft;
    }

}
