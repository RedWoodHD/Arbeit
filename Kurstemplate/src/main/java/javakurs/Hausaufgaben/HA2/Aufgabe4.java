package javakurs.Hausaufgaben.HA2;

public class Aufgabe4
{
    /**
     * bei GenericChainedNodes<?> kann man nur lesen, also Dinge ausgeben oder abrufen, aber nichts Neues hinzufügen oder ändern.
     *
     * Das liegt daran, dass das "?" für einen unbekannten Typ steht.
     * Java weiß also nicht, ob da z. B. String, Integer oder etwas anderes drin ist – und um sicher zu sein, lässt es dich keine neuen Werte herein setzen.
     *
     * Bei GenericChainedNodes<Object> dagegen kennt Java den Typ (Object), also kannst du Elemente hinzufügen, ändern und lesen.
     * GenericChainedNodes<Object> bedeutet, dass die Kette mit dem Typ Object arbeitet.
     * Man weiß also genau, dass sie Object-Werte speichert. Deshalb kann man Elemente hinzufügen und ändern.
     *
     */
}
