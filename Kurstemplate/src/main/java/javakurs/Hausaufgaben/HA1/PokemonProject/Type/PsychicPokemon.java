package javakurs.Hausaufgaben.HA1.PokemonProject.Type;
import javakurs.Hausaufgaben.HA1.PokemonProject.Pokemon;

/**
 * Diese Klasse representiert ein {@link PsychicPokemon}.
 * Dieses ist in erster Linie wie ein das normale {@link Pokemon}, es ist vom Typos psychisch und hat dadurch Spezialangriffe
 * und ist auch gegen spezielle andere Typen besser oder schlechter geeignet.
 * @author EGA
 */
public abstract class PsychicPokemon extends Pokemon
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
     * Diese Methode greift den enemy an und verringert sein {@link Pokemon#healthPoints Leben},
     * um den Wert der in {@link Pokemon#damage} steht + 80.
    * Ignoriert die {@link Pokemon#defense} vom enemy.
     * @param enemy {@link Pokemon} das angegriffen werden soll.
     */
    public void psychic(Pokemon enemy)
    {
        enemy.setHealthPoints(enemy.getHealthPoints() - damage + 80);
    }
}
