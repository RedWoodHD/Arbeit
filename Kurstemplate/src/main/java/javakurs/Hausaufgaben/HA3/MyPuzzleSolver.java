package javakurs.Hausaufgaben.HA3;

import javakurs.Day_07.puzzle_game.GraphTest;

import java.util.*;
import java.util.function.Predicate;

/**
 * Implementiert diese Klasse aus, anhand der im Unterricht definierten Designentscheidungen, die ihr hoffentlich alle mitgeschrieben habt :-)
 */
public final class MyPuzzleSolver implements PuzzleSolver
{

    Graph<PuzzleState, Action> graph;

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

    @Override
    public List<Action> solve(PuzzleState initialState, Predicate<PuzzleState> isGoal)
    {
        if (isGoal.test(initialState))
        {
            return List.of();
        }
        Graph<PuzzleState, Action>.Vertex startingPoint = null;
        List<Graph<PuzzleState, Action>.Vertex> vertexList = graph.getVertexStream().toList();
        for (Graph<PuzzleState, Action>.Vertex currentVertex : vertexList)
        {
            if (currentVertex.getValue().equals(initialState))
            {
                startingPoint = currentVertex;
                break;
            }
        }
        if (!vertexList.contains(startingPoint))
        {
            throw new IllegalArgumentException("Der Startpunkt ist nicht im Graphen vorhanden");
        }
        final Map<Graph<PuzzleState, Action>.Vertex, Graph<PuzzleState, Action>.Vertex> parent = new HashMap<>();
        final Map<Graph<PuzzleState, Action>.Vertex, Action> actionFromParent = new HashMap<>();
        // BFS Strukturen
        final Queue<Graph<PuzzleState, Action>.Vertex> queue = new LinkedList<>();
        final Set<Graph<PuzzleState, Action>.Vertex> visited = new HashSet<>();

        visited.add(startingPoint);
        queue.add(startingPoint);

        Graph<PuzzleState, Action>.Vertex foundGoalVertex = null;

        while (!queue.isEmpty())
        {
            Graph<PuzzleState, Action>.Vertex currentVertex = queue.poll();
            for (Graph<PuzzleState, Action>.Edge currentEdge : currentVertex.getIncidenceOutStream().toList())
            {
                Graph<PuzzleState, Action>.Vertex omegaVertex = currentEdge.getOmega();

                // schon besucht?
                if (visited.contains(omegaVertex))
                {
                    continue;
                }
                visited.add(omegaVertex);
                parent.put(omegaVertex, currentVertex);             // woher komme ich?
                actionFromParent.put(omegaVertex, currentEdge.getValue()); // welche Action war das?
                queue.add(omegaVertex);

                if (isGoal.test(omegaVertex.getValue()))
                {
                    foundGoalVertex = omegaVertex;
                    queue.clear();
                    break;
                }
            }
        }
        if (foundGoalVertex == null)
        {
            return null;
        }
        // 4. Backtrack vom Ziel zum Start
        LinkedList<Action> result = new LinkedList<>();
        Graph<PuzzleState, Action>.Vertex track = foundGoalVertex;

        while (track != null && !track.equals(startingPoint))
        {
            Action currentAction = actionFromParent.get(track);
            if (currentAction == null)
            {
                return null;
            }
            result.addFirst(currentAction);
            track = parent.get(track);
        }
        return result;
    }

}
