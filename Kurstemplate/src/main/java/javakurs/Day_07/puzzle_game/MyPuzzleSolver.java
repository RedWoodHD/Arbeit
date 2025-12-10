package javakurs.Day_07.puzzle_game;

import java.util.*;
import java.util.function.Predicate;

/**
 * Implementiert diese Klasse aus, anhand der im Unterricht definierten Designentscheidungen, die ihr hoffentlich alle mitgeschrieben habt :-)
 */
public final class MyPuzzleSolver implements PuzzleSolver
{

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

    @Override
    public List<Action> solveWithGraph(PuzzleState initialState, Predicate<PuzzleState> isGoal)
    {
        Graph<PuzzleState, Action> myGraph = new Graph<>();
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
                myGraph.createVertex(currentState);
                myGraph.createVertex(nextState);
//                myGraph.createEdge(myGraph.getVertex().get)
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

    @Override
    public List<Action> solveWithGraph2(PuzzleState initialState, Predicate<PuzzleState> isGoal)
    {
        // --- 1) Kompletten Graphen erzeugen ---
        Graph<PuzzleState, Action> graph = new Graph<>();
        Map<PuzzleState, Graph<PuzzleState, Action>.Vertex> vertexMap = new HashMap<>();
        Queue<PuzzleState> frontier = new LinkedList<>();

        // Startknoten
        Graph<PuzzleState, Action>.Vertex initialVertex = graph.createVertex(initialState);
        vertexMap.put(initialState, initialVertex);
        frontier.add(initialState);

        // Vollständiger Zustandsraum:
        while (!frontier.isEmpty())
        {

            PuzzleState current = frontier.poll();
            Graph<PuzzleState, Action>.Vertex currentVertex = vertexMap.get(current);

            for (Action action : current.possibleActions())
            {

                PuzzleState next = current.step(action);
                System.out.println("PuzzleState next = current.step(action);");

                Graph<PuzzleState, Action>.Vertex nextVertex;
                if (vertexMap.containsKey(next))
                {
                    nextVertex = vertexMap.get(next);
                }
                else
                {
                    nextVertex = graph.createVertex(next);
                    vertexMap.put(next, nextVertex);
                    frontier.add(next);
                }

                // Kante erzeugen (immer, auch wenn Zustand bekannt)
                graph.createEdge(currentVertex, nextVertex, action);
            }
        }

        // --- 2) BFS über den fertigen Graphen ---

        if (isGoal.test(initialState))
        {
            return List.of();
        }

        Map<Graph<PuzzleState, Action>.Vertex, Graph<PuzzleState, Action>.Vertex> parent = new HashMap<>();
        Map<Graph<PuzzleState, Action>.Vertex, Action> parentAction = new HashMap<>();

        Queue<Graph<PuzzleState, Action>.Vertex> queue = new LinkedList<>();
        Set<Graph<PuzzleState, Action>.Vertex> visited = new HashSet<>();

        queue.add(initialVertex);
        visited.add(initialVertex);

        Graph<PuzzleState, Action>.Vertex goalVertex = null;

        while (!queue.isEmpty())
        {

            Graph<PuzzleState, Action>.Vertex currentVertex = queue.poll();

            List<Graph<PuzzleState, Action>.Edge> outgoing =
                    currentVertex.getIncidenceOutStream().toList();

            for (Graph<PuzzleState, Action>.Edge edge : outgoing)
            {

                Graph<PuzzleState, Action>.Vertex nextVertex = edge.getOmega();

                if (visited.contains(nextVertex))
                {
                    System.out.println("Skip");
                    continue;
                }

                visited.add(nextVertex);
                System.out.println("visited.add(nextVertex);");
                parent.put(nextVertex, currentVertex);
                parentAction.put(nextVertex, edge.getValue());
                queue.add(nextVertex);

                if (isGoal.test(nextVertex.getValue()))
                {
                    goalVertex = nextVertex;
                    break;
                }
            }

            if (goalVertex != null)
            {
                break;
            }
        }

        if (goalVertex == null)
        {
            return null;
        }

        // --- 3) Pfad zurückverfolgen ---
        LinkedList<Action> result = new LinkedList<>();
        Graph<PuzzleState, Action>.Vertex walk = goalVertex;

        while (!walk.equals(initialVertex))
        {
            Action a = parentAction.get(walk);
            result.addFirst(a);
            walk = parent.get(walk);
        }
        System.out.println("Edges: " + graph.countEdges());
        System.out.println("Vertices: " + graph.countVertices());
        return result;
    }
}
