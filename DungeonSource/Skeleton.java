
/**
 * Concrete Skeleton class that holds represents a skeleton Monster
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Skeleton extends Monster {

    /**
     * Default constructor for a skeleton object, calls superclass to initiate
     * values
     */
    public Skeleton() {
        super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
    }

    /**
     * Attack method for a skeleton character.
     *
     * @param opponent the opponent the skeleton is attacking
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " slices his rusty blade at "
                + opponent.getName() + ":");
        super.attack(opponent);
    }
}
