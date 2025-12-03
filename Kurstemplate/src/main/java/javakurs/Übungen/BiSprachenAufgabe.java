package javakurs.Übungen;

public class BiSprachenAufgabe
{

    public static void main(String[] args) {

        String textBlock = """
                Ich habe dich,
                Lotte, so lieb.
                Hast auch du mich
                Lieb? Nein, vergib.
                Nah oder fern,
                Gott sei dir gut.
                Mein Herz hat gern
                An dir geruht.
                """;
        System.out.println(bonnerBiSprache(textBlock));
    }

    // Hausaufgabe, Aufgabe 

    /**
     * @param zeichenabfolge
     * @return Diese Zeichenabfolge mit "bi" rangehangen nach Vokal (außer, wenn zwei Vokale hintereinander)
     */
    //|| element == 'A' || element == 'E' || element == 'I' || element == 'O' || element == 'U';
    // || element == 'A' || element == 'E' || element == 'I' || element == 'O' || element == 'U';
    private static String bonnerBiSprache(String neuZeichenabfolge) {
        String rangehangen = "";
        //String neuZeichenabfolge = zeichenabfolge.toLowerCase();
        for (int i = 0; i < neuZeichenabfolge.length(); i++) {
            char element = neuZeichenabfolge.charAt(i);
            boolean element1 = element == 'a' || element == 'e' || element == 'i' || element == 'o' || element == 'u' || element == 'A' || element == 'E' || element == 'I' || element == 'O' || element == 'U';
            char elDanach;
            boolean element2 = false;
            if (i + 1 < neuZeichenabfolge.length()) {
                elDanach = neuZeichenabfolge.charAt(i + 1);
                element2 = elDanach == 'a' || elDanach == 'e' || elDanach == 'i' || elDanach == 'o' || elDanach == 'u' || elDanach == 'A' || elDanach == 'E' || elDanach == 'I' || elDanach == 'O' || elDanach == 'U';
            }
            if ((element1 && element2) ^ (!element1)) {
                rangehangen += element;
            } else {
                rangehangen += element + "bi";
            }
        }
        return rangehangen;
    }

}


