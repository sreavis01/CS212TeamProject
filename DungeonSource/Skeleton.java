/**
 * Concrete Skeleton class that holds represents a skeleton Monster
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Skeleton extends DungeonCharacter {
	
    protected double chanceToHeal;
    protected int minHeal, maxHeal;
    /**
     * Default constructor for a skeleton object, calls superclass to initiate
     * values
     */
    public Skeleton() {
        super("Sargath the Skeleton", 100, 3, .8, 30, 50);
        
        this.chanceToHeal = .3;
        this.minHeal = 30;
        this.maxHeal = 50;
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
    
    /**
     * Subtract hitpoints from the monster, then attempts a heal
     *
     * @param hitPoints the number of hitpoints to subtract
     */
    public void subtractHitPoints(int hitPoints) {
        super.subtractHitPoints(hitPoints);
        super.heal(chanceToHeal, minHeal, maxHeal);
    }
    
    public void battleChoices(DungeonCharacter opponent) {}
}
