package javakurs.ErsteStunde.getränke;

import javakurs.ErsteStunde.gefäß.Gefäß;

public class Kakao extends Heißgetränk
{
    private double kakaoanteil;
    private double milchanteil;

    public Kakao(double temperatur, double menge, boolean zucker, double kakaoanteil, double milchanteil, Gefäß gefäß)
    {
        super(temperatur,menge,zucker,gefäß);
        this.kakaoanteil = kakaoanteil;
        this.milchanteil = milchanteil;
    }
}
