package javakurs.Hausaufgaben.HA1.PokemonProject;

/**
 * Diese Klasse beschreibt ein Wesen,
 * das in der Wildnis auftauchen kann oder von {@link javakurs.Hausaufgaben.HA1.PokemonProject.Trainer.Trainer Trainern} gefangen wird.
 * <br>
 * Diese Klasse stellt ein stark vereinfachtes Modell eines Pokémon dar,
 * wie es in Spielen oder Simulationen verwendet werden könnte.
 * <br>
 * Die Pokemon können in Kämpfen gegeneinander antreten.
 * @author EGA
 */
public abstract class Pokemon
{
    protected String strength;
    protected String weakness;
    protected int healthPoints;
    protected int defense;
    protected int damage;

    /**
     * Diese Methode soll genutzt werden um ein {@link Pokemon} anzugreifen.
     *
     * @param enemy {@link Pokemon} das angegriffen werden soll
     */
    public abstract void attack(Pokemon enemy);

    /**
     * Diese Methode erhöht die {@link Pokemon#healthPoints Leben} um 50.
     */
    public void useItem()
    {
//        Nutze ein Item
        healthPoints = healthPoints + 50;
    }

    /**
     * Diese Methode setzt die {@link Pokemon#healthPoints Leben} auf 0.
     *
     * @return {@code true} Flucht war erfolgreich.
     */
    public boolean escape()
    {
//        Flüchte aus dem Kampf
        healthPoints = 0;
        return true;
    }

    public String getStrength()
    {
        return strength;
    }

    public Pokemon setStrength(String strength)
    {
        this.strength = strength;
        return this;
    }

    public String getWeakness()
    {
        return weakness;
    }

    public Pokemon setWeakness(String weakness)
    {
        this.weakness = weakness;
        return this;
    }

    public int getHealthPoints()
    {
        return healthPoints;
    }

    public Pokemon setHealthPoints(int healthPoints)
    {
        this.healthPoints = healthPoints;
        return this;
    }

    public int getDefense()
    {
        return defense;
    }

    public Pokemon setDefense(int defense)
    {
        this.defense = defense;
        return this;
    }

    public int getDamage()
    {
        return damage;
    }

    public Pokemon setDamage(int damage)
    {
        this.damage = damage;
        return this;
    }
}
