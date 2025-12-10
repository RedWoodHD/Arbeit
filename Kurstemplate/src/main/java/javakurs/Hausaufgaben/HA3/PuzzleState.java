package javakurs.Hausaufgaben.HA3;

public interface PuzzleState {

    /**
     * Gibt den inneren Zustand in menschenlesbarer Form auf der Konsole aus
     */
    void show();

    /**
     * Berechnet den nächsten Zustand anhand der übergebenen Aktion. Wenn der Schritt verboten ist, wird "null"
     * geliefert.
     *
     * @param action die Aktion, die ausgeführt werden soll
     * @return der aus der Aktion resultierende Folgezustand oder "null", wenn es keinen gibt.
     */
    PuzzleState step(Action action);

    /**
     * Gibt ein Iterable zurück, um die Aktionen zu erhalten, die zu validen Folgezuständen führen.
     */
    Iterable<Action> possibleActions();

}
