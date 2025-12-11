package javakurs.Hausaufgaben.HA3;

import javakurs.Day_07.puzzle_game.Graph;
import javakurs.Day_07.puzzle_game.ThreeByThreePuzzleStateArrayImplementation;

import java.util.*;
import java.util.function.Predicate;

/**
 * Implementiert diese Klasse aus, anhand der im Unterricht definierten Designentscheidungen, die ihr hoffentlich alle mitgeschrieben habt :-)
 */
public final class MyPuzzleSolver implements PuzzleSolver
{

    javakurs.Day_07.puzzle_game.Graph<javakurs.Day_07.puzzle_game.PuzzleState, javakurs.Day_07.puzzle_game.Action> graph;

    public MyPuzzleSolver()
    {
        graph = new javakurs.Day_07.puzzle_game.Graph<>();
        final Map<javakurs.Day_07.puzzle_game.PuzzleState, javakurs.Day_07.puzzle_game.Graph<javakurs.Day_07.puzzle_game.PuzzleState, javakurs.Day_07.puzzle_game.Action>.Vertex> vertexMap = new HashMap<>();
        final Queue<javakurs.Day_07.puzzle_game.PuzzleState> queue = new LinkedList<>();
        final Set<javakurs.Day_07.puzzle_game.PuzzleState> marker = new HashSet<>();
        final javakurs.Day_07.puzzle_game.PuzzleState startingPointWhereWeConstruateTheGraph = new ThreeByThreePuzzleStateArrayImplementation(new byte[]{1, 2, 3, 4, 5, 8, 6, 7, 0});

        javakurs.Day_07.puzzle_game.Graph<javakurs.Day_07.puzzle_game.PuzzleState, javakurs.Day_07.puzzle_game.Action>.Vertex startVertex = graph.createVertex(startingPointWhereWeConstruateTheGraph);
        vertexMap.put(startingPointWhereWeConstruateTheGraph, startVertex);
        marker.add(startingPointWhereWeConstruateTheGraph);
        queue.add(startingPointWhereWeConstruateTheGraph);

        while (!queue.isEmpty())
        {
            final javakurs.Day_07.puzzle_game.PuzzleState currentState = queue.poll();
            for (javakurs.Day_07.puzzle_game.Action currentAction : currentState.possibleActions())
            {
                javakurs.Day_07.puzzle_game.PuzzleState nextState = currentState.step(currentAction);
                javakurs.Day_07.puzzle_game.Graph<javakurs.Day_07.puzzle_game.PuzzleState, javakurs.Day_07.puzzle_game.Action>.Vertex currentVertex = vertexMap.get(currentState);
                Graph<javakurs.Day_07.puzzle_game.PuzzleState, javakurs.Day_07.puzzle_game.Action>.Vertex nextVertex = vertexMap.get(nextState);
                if (nextVertex == null)
                {
                    nextVertex = graph.createVertex(nextState);
                    vertexMap.put(nextState, nextVertex);
                    queue.add(nextState);
                }
                // Knoten für next erzeugen/holen
                graph.createEdge(currentVertex, nextVertex, currentAction);

            }
        }
        System.out.println("Kanten haben wir: " + graph.countEdges());
        System.out.println("Knoten haben wir: " + graph.countVertices());
    }

    @Override
    public List<Action> solve(PuzzleState initialState, Predicate<PuzzleState> isGoal)
    {
        // Wenn wir schon am Ziel sind, brauchen wir nicht zu suchen (das war Philips Idee, ich hatte den Aspekt übersehen)
        if (isGoal.test(initialState))
        {
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
        while (foundGoalState == null && !buffer.isEmpty())
        {
            // Wir ziehen uns den nächsten Zustand aus dem Puffer
            final PuzzleState currentState = buffer.poll();

            // Wir iterieren über alle möglichen Folgezustände (hier: Kombination aus Action und PuzzleState)
            for (final Action nextAction : currentState.possibleActions())
            {
                final PuzzleState nextState = currentState.step(nextAction);

                // Wenn wir bereits hier waren, ignorieren wir den Zustand
                if (marker.contains(nextState))
                {
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
                if (isGoal.test(nextState))
                {
                    foundGoalState = nextState;
                    break;
                }
            }
        }

        // Wenn wir nichts gefunden haben, liefern wir "null", gemäß Spezifikation des Interfaces
        if (foundGoalState == null)
        {
            return null;
        }

        // Wir berechnen die Ergebnisliste
        final List<Action> result = new LinkedList<>();

        // initialState (da komm ich her)
        // foundGoalState (da bin ich jetzt)

        PuzzleState trackBack = foundGoalState; // wo bin ich gerade?

        // Wir navigieren rückwärts durch das Ergebnis von foundGoalState zu initialState und schreiben die Actions dahin mit
        while (!initialState.equals(trackBack))
        {
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
