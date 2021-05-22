
/**
 * Concrete Gremlin class that holds represents a gremlin Monster
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Gremlin extends Monster {

    /**
     * Default constructor for a gremlin object, calls superclass to initiate
     * values
     */
    public Gremlin() {
        super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

    }

    /**
     * Attack method for a gremlin character.
     *
     * @param opponent the opponent the gremlin is attacking
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " jabs his kris at "
                + opponent.getName() + ":");
        super.attack(opponent);

    }
}
