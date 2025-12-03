package javakurs.Day_06.PuzzleGame.main.java.de.shd.javakurs2.puzzle_game;

import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;

/**
 * Einfaches Schiebepuzzle für "Babys". Es ist ein 3x3 Feld. Die Felder werden mit Zahlen befüllt. Es gibt die Ziffern
 * 0 bis 9. Die 0 steht hierbei für ein leeres Feld. Der definierte Zielzustand ist
 * <p>
 * 1 2 3<br/>
 * 4 5 6<br/>
 * 7 8 0<br/>
 */
@EqualsAndHashCode
@SuppressWarnings("java:S106")
public final class ThreeByThreePuzzleStateArrayImplementation implements PuzzleState {

    public static final ThreeByThreePuzzleStateArrayImplementation DEFAULT_GOAL_STATE =
            new ThreeByThreePuzzleStateArrayImplementation(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
    private static final int SIZE = 3;
    private static final int INNER_SIZE = SIZE * SIZE;
    private static final int SUM = (8 * 8 + 8) / 2;

    /**
     * Speichert den inneren Zustand in einem Byte-Array.
     */
    @EqualsAndHashCode.Include
    private final byte[] innerState = new byte[INNER_SIZE];

    /**
     * Hält die nächsten Aktionen vor. Wird beim Anlegen des Objekts ermittelt.
     */
    @EqualsAndHashCode.Exclude
    private final Set<Action> possibleActions = new HashSet<>(4);

    /**
     * Erzeugt einen neuen Zustand aus einem gegebenen Array. Dabei werden alle gültigen Aktionen berechnet vorgehalten.
     */
    public ThreeByThreePuzzleStateArrayImplementation(final byte[] innerState) {
        if (isValid(innerState)) {
            System.arraycopy(innerState, 0, this.innerState, 0, innerState.length);
        } else {
            throw new IllegalArgumentException("Invalid inner state.");
        }
        cachePossibleActions();
    }

    /**
     * Ermittelt die möglichen Zustandsübergänge basierend auf der Position der Null.
     */
    private void cachePossibleActions() {
        possibleActions.clear();
        final int internalIndexOfZero = getInternalIndexOfZero();
        final int xOfZero = getX(internalIndexOfZero);
        if (xOfZero > 0) {
            possibleActions.add(Action.LEFT);
        }
        if (xOfZero < SIZE - 1) {
            possibleActions.add(Action.RIGHT);
        }
        final int yOfZero = getY(internalIndexOfZero);
        if (yOfZero > 0) {
            possibleActions.add(Action.UP);
        }
        if (yOfZero < SIZE - 1) {
            possibleActions.add(Action.DOWN);
        }
    }

    private byte internalGet(final int y, final int x) {
        return innerState[internalIndex(y, x)];
    }

    private static int internalIndex(int y, int x) {
        return y * SIZE + x;
    }

    /**
     * Prüft, ob das übergebene Array einen validen Zustand enthält. Valide bedeutet, dass die Ziffern von 0 bis 9 genau
     * einmal enthalten sein müssen und die Länge muss exakt {@link #INNER_SIZE} sein.
     *
     * @param toCheck das Array, welches geprüft werden soll
     * @return true, wenn das Array valide ist.
     */
    private boolean isValid(final byte[] toCheck) {
        if (toCheck == null) {
            return false;
        }
        if (toCheck.length != INNER_SIZE) {
            return false;
        }
        final BitSet checkSet = new BitSet();
        int sum = 0;
        boolean allPositive = true;
        for (final byte b : toCheck) {
            sum += b;
            allPositive &= b >= 0;
            checkSet.set(b);
        }
        return sum == SUM && allPositive && checkSet.cardinality() == INNER_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                System.out.print(internalGet(y, x));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PuzzleState step(final Action action) {
        if (!possibleActions.contains(action)) {
            return null;
        }
        final ThreeByThreePuzzleStateArrayImplementation nextState = new ThreeByThreePuzzleStateArrayImplementation(innerState);
        final int oldZeroIndex = nextState.getInternalIndexOfZero();
        final int zeroX = nextState.getX(oldZeroIndex);
        final int zeroY = nextState.getY(oldZeroIndex);
        final int newZeroIndex = switch (action) {
            case LEFT -> internalIndex(zeroY, zeroX - 1);
            case UP -> internalIndex(zeroY - 1, zeroX);
            case DOWN -> internalIndex(zeroY + 1, zeroX);
            case RIGHT -> internalIndex(zeroY, zeroX + 1);
        };
        nextState.innerState[oldZeroIndex] = nextState.innerState[newZeroIndex];
        nextState.innerState[newZeroIndex] = 0;
        nextState.cachePossibleActions();
        return nextState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<Action> possibleActions() {
        return Collections.unmodifiableSet(possibleActions);
    }

    /**
     * Berechnet die logische X-Komponente eines internen Index.
     */
    private int getX(final int internalIndex) {
        return internalIndex % SIZE;
    }

    /**
     * Berechnet die logische Y-Komponente eines internen Index.
     */
    private int getY(final int internalIndex) {
        return internalIndex / SIZE;
    }

    /**
     * Sucht die (hoffentlich einzige) null und gibt den internen Index zurück.
     */
    private int getInternalIndexOfZero() {
        for (int i = 0; i < INNER_SIZE; i++) {
            if (innerState[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
