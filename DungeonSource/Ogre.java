/**
 * Concrete Ogre class that holds represents a ogre Monster
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Ogre extends DungeonCharacter {

    protected double chanceToHeal;
    protected int minHeal, maxHeal;
    /**
     * Default constructor for a ogre object, calls superclass to initiate
     * values
     */
    public Ogre() {
        super("Oscar the Ogre", 200, 2, .6, 30, 50);
        
        this.chanceToHeal = .1;
        this.minHeal = 30;
        this.maxHeal = 50;
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
