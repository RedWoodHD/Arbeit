package javakurs.ErsteStunde.getränke;

import javakurs.ErsteStunde.gefäß.Gefäß;

public class Milchkaffee extends Kaffee
{
    private double milchmenge;
    private boolean fettarm;

    public Milchkaffee(double temperatur, double menge, boolean zucker, String herkunft, double milchmenge, boolean fettarm, Gefäß gefäß)
    {
        super(temperatur, menge, zucker, herkunft,gefäß);
        this.milchmenge = milchmenge;
        this.fettarm=fettarm;
    }
}
