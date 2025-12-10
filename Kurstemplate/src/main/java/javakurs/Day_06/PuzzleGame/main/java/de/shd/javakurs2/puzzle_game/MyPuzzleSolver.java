package javakurs.Day_06.PuzzleGame.main.java.de.shd.javakurs2.puzzle_game;

import java.util.*;
import java.util.function.Predicate;

/**
 * Implementiert diese Klasse aus, anhand der im Unterricht definierten Designentscheidungen, die ihr hoffentlich alle mitgeschrieben habt :-)
 */
public final class MyPuzzleSolver implements PuzzleSolver
{
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Action> solve(PuzzleState initialState, Predicate<PuzzleState> isGoal)
    {
        final Map<PuzzleState, PuzzleState> parent = new HashMap<>();
        final Map<PuzzleState, Action> actionFromParent = new HashMap<>();
        final Queue<PuzzleState> workQueue = new LinkedList<>();
        final Set<PuzzleState> visited = new HashSet<>();
        PuzzleState goalState = null;
        visited.add(initialState);
        workQueue.add(initialState);

        if (isGoal.test(initialState))
        {
            return List.of();
        }

        while (!workQueue.isEmpty())
        {
            for (Action currentAction : initialState.possibleActions())
            {
                workQueue.add(initialState.step(currentAction));
                visited.add(initialState.step(currentAction));
            }
        }
        return null;
    }
}
