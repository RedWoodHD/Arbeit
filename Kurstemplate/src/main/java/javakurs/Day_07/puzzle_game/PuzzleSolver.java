package javakurs.Day_07.puzzle_game;

import java.util.List;
import java.util.function.Predicate;

interface PuzzleSolver {
    /**
     * Berechnet eine Zugreihenfolge, die vom übergebenen Startzustand zum impliziten Zielzustand führt, wenn es eine
     * gibt. Gibt es keine, wird null geliefert. Falls der übergebene Zustand bereits der/ein Zielzustand ist, wird
     * eine leere Liste geliefert.
     *
     * @param initialState der Startzustand
     * @param isGoal       Prädikat, welches entscheidet, wann das Ziel erreicht ist
     */
    List<Action> solve(PuzzleState initialState, Predicate<PuzzleState> isGoal);

}
