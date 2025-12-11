package javakurs.Day_07.puzzle_game;

import java.util.*;
import java.util.function.Predicate;

/**
 * Implementiert diese Klasse aus, anhand der im Unterricht definierten Designentscheidungen, die ihr hoffentlich alle mitgeschrieben habt :-)
 */


public final class MyPuzzleSolver implements PuzzleSolver
{
    Graph<PuzzleState,Action> graph;
    public MyPuzzleSolver()
    {
        graph = new Graph<>();
        final Map<PuzzleState, Graph<PuzzleState, Action>.Vertex> vertexMap = new HashMap<>();
        final Queue<PuzzleState> queue = new LinkedList<>();
        final Set<PuzzleState> marker = new HashSet<>();
        final PuzzleState startingPointWhereWeConstruateTheGraph = new ThreeByThreePuzzleStateArrayImplementation(new byte[]{1, 2, 3, 4, 5, 8, 6, 7, 0});

        Graph<PuzzleState, Action>.Vertex startVertex = graph.createVertex(startingPointWhereWeConstruateTheGraph);
        vertexMap.put(startingPointWhereWeConstruateTheGraph, startVertex);
        marker.add(startingPointWhereWeConstruateTheGraph);
        queue.add(startingPointWhereWeConstruateTheGraph);

        while (!queue.isEmpty())
        {
            final PuzzleState currentState = queue.poll();
            for (Action currentAction : currentState.possibleActions())
            {
                PuzzleState nextState = currentState.step(currentAction);
                Graph<PuzzleState, Action>.Vertex currentVertex = vertexMap.get(currentState);
                Graph<PuzzleState, Action>.Vertex nextVertex = vertexMap.get(nextState);
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

    /**
     * Berechnet eine Zugreihenfolge, die vom übergebenen Startzustand zum impliziten Zielzustand führt, wenn es eine
     * gibt. Gibt es keine, wird null geliefert. Falls der übergebene Zustand bereits der/ein Zielzustand ist, wird
     * eine leere Liste geliefert.
     *
     * @param initialState der Startzustand
     * @param isGoal       Prädikat, welches entscheidet, wann das Ziel erreicht ist
     */
    @Override
    public List<Action> solve(PuzzleState initialState, Predicate<PuzzleState> isGoal)
    {
        return List.of();
    }
}