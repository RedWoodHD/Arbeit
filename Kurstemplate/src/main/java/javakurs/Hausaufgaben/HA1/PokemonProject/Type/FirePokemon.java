package javakurs.Hausaufgaben.HA1.PokemonProject.Type;
import javakurs.Hausaufgaben.HA1.PokemonProject.Pokemon;

/**
 * Diese Klasse representiert ein {@link Pokemon} vom Typ Feuer.
 * Dieser Typ hat spezifische aber auch eine Standardattacke.
 * @author EGA
 */
public abstract class FirePokemon extends Pokemon
{
    /**
     * Diese Methode greift den enemy an und verringert sein {@link Pokemon#healthPoints Leben},
     * um den Wert der in {@link Pokemon#damage} steht.
     * Die {@link Pokemon#defense Verteidigung} wird berücksichtigt.
     * @param enemy {@link Pokemon} das angegriffen werden soll.
     */
    @Override
    public void attack(Pokemon enemy)
    {
        enemy.setHealthPoints((enemy.getHealthPoints() + enemy.getDefense())-damage);
    }

    /**
     * Diese Methode greift den enemy an und verringert sein {@link Pokemon#healthPoints Leben}.
     * Der {@link Pokemon#damage Schaden} wird vor dem Angriff erhört.
     * Ignoriert die {@link Pokemon#defense} vom enemy.
     * @param enemy {@link Pokemon} das angegriffen werden soll.
     */
    public void burn(Pokemon enemy)
    {
        for (int i = 0; i < 3; i++)
        {
            damage = (int) ((double) damage * 0.5);
        }
        enemy.setHealthPoints(enemy.getHealthPoints() - damage);
    }
}
