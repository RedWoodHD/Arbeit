package javakurs.Day_06.PuzzleGame.main.java.de.shd.javakurs2.puzzle_game;

import java.util.*;
import java.util.function.Predicate;

public class MyPuzzleSolver2 implements PuzzleSolver{

    @Override
    public List<Action> solve(PuzzleState initialState, Predicate<PuzzleState> isGoal) {
        // Wenn wir schon am Ziel sind, brauchen wir nicht zu suchen (das war Philips Idee, ich hatte den Aspekt übersehen)
        if (isGoal.test(initialState)) {
            return List.of();
        }

        // Die Parent-Funktion, damit wir die Zugreihenfolge backtracen können
        final Map<PuzzleState, PuzzleState> parent = new HashMap<>();

        // Die Parent-Action-Funktion, damit wir die tatsächlichen Actions ermitteln können
        final Map<PuzzleState, Action> actionFromParent = new HashMap<>();

        // Der Puffer
        final Queue<PuzzleState> buffer = new LinkedList<>();

        // Der Marker
        final Set<PuzzleState> marker = new HashSet<>();

        // Der gefundene Zielzustand um die Suche frühzeitig abbrechen zu können
        PuzzleState foundGoalState = null;

        // Wir initialisieren sowohl den Marker, als auch den Puffer mit unserem Startzustand
        marker.add(initialState);
        buffer.add(initialState);

        // Wenn wir schon ein Ziel gefunden haben, hören wir auf, ansonsten suchen wir solange, bis der Puffer leer ist
        while (foundGoalState == null && !buffer.isEmpty()) {
            // Wir ziehen uns den nächsten Zustand aus dem Puffer
            final PuzzleState currentState = buffer.poll();

            // Wir iterieren über alle möglichen Folgezustände (hier: Kombination aus Action und PuzzleState)
            for (final Action nextAction : currentState.possibleActions()) {
                final PuzzleState nextState = currentState.step(nextAction);

                // Wenn wir bereits hier waren, ignorieren wir den Zustand
                if (marker.contains(nextState)) {
                    continue;
                }

                // Wenn wir noch nicht hier waren, bearbeiten wir den Zustand

                // Wir waren jetzt "da"
                marker.add(nextState);

                // Wir nehmen den Zustand in die Parent-Funktion auf. Wichtig: Hier müssen wir das rückwärts setzen
                parent.put(nextState, currentState);

                // Ähnlich verfahren wir mit den Actions
                actionFromParent.put(nextState, nextAction);

                // Zuletzt muss der Zustand noch in den Puffer, damit wir später auch seine Folgezustände bearbeiten können
                buffer.add(nextState);

                // Wenn wir bereits am Ziel sind, brechen wir ab
                if (isGoal.test(nextState)) {
                    foundGoalState = nextState;
                    break;
                }
            }
        }

        // Wenn wir nichts gefunden haben, liefern wir "null", gemäß Spezifikation des Interfaces
        if (foundGoalState == null) {
            return null;
        }

        // Wir berechnen die Ergebnisliste
        final List<Action> result = new LinkedList<>();

        // initialState (da komm ich her)
        // foundGoalState (da bin ich jetzt)

        PuzzleState trackBack = foundGoalState; // wo bin ich gerade?

        // Wir navigieren rückwärts durch das Ergebnis von foundGoalState zu initialState und schreiben die Actions dahin mit
        while (!initialState.equals(trackBack)) {
            // Wir fügen die Actions vorne ein, weil wir ja rückwärts gehen, die Zugfolge aber gerne vorwärts hätten.
            // Hier ist es wichtig eine LinkedList zu nehmen. Eine ArrayList wäre ineffizient.
            // Alternativ könnte man auch einfach "add" aufrufen und die Liste am Ende einmal reversen.
            result.addFirst(actionFromParent.get(trackBack));

            // Das hier ist die fortgeschrittenere Variante von "i--" in einer Schleife.
            trackBack = parent.get(trackBack);
        }

        return result;
    }
}
