
/**
 * Concrete Ogre class that holds represents a ogre Monster
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Ogre extends Monster {

    /**
     * Default constructor for a ogre object, calls superclass to initiate
     * values
     */
    public Ogre() {
        super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
    }

    /**
     * Attack method for a ogre character.
     *
     * @param opponent the opponent the ogre is attacking
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " slowly swings a club toward's "
                + opponent.getName() + ":");
        super.attack(opponent);
    }
}
