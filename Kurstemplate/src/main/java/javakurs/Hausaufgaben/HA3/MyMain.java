package javakurs.Hausaufgaben.HA3;

import java.util.List;

public final class MyMain {
    public static void main(String[] args) {
        // Dieser Startzustand sollte eine Lösung mit 12 Schritten finden
        final PuzzleState start = new ThreeByThreePuzzleStateArrayImplementation(new byte[]{1, 2, 3, 4, 5, 8, 6, 7, 0});

        // Wenn der obere klappt, probiert mal den hier aus ... was ist das Ergebnis?
        // final PuzzleState start = new ThreeByThreePuzzleStateArrayImplementation(new byte[]{1, 2, 3, 4, 5, 6, 8, 7, 0});

        final PuzzleSolver solver = new MyPuzzleSolver();
        solve(solver, start);
    }

    private static void solve(final PuzzleSolver solver, final PuzzleState start) {
        // Überraschung! Hier müsst ihr mal nicht das Prädikat aufrufen ... dafür müsst ihr es in eurer "solve"-Methode auswerten :-)
        final List<Action> solutionList = solver.solve(start, ThreeByThreePuzzleStateArrayImplementation.DEFAULT_GOAL_STATE::equals);
        // "null" bedeutet "keine Lösung"
        if (solutionList != null) {
            PuzzleState currentState = start;
            for (Action action : solutionList) {
                currentState.show();
                System.out.println();
                System.out.println(action);
                currentState = currentState.step(action);
            }
            currentState.show();
            System.out.println("Solution found with " + solutionList.size() + " steps.");
        } else {
            System.out.println("No solution found.");
        }
    }
}
