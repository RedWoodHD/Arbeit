package javakurs.ErsteStunde;

import javakurs.ErsteStunde.gefäß.Tasse;
import javakurs.ErsteStunde.getränke.Kakao;

public class Main
{
    public static void main(String[] args)
    {
        Tasse tasse = new Tasse();
        Kakao kakao = new Kakao(100,50,true,70,50,tasse);
        if (kakao!= null){
            System.out.println("Kakao wurde gemacht");
        }
    }
}
