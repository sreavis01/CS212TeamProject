/**
 * Concrete Gremlin class that holds represents a gremlin Monster
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Gremlin extends DungeonCharacter {

    protected double chanceToHeal;
    protected int minHeal, maxHeal;
    /**
     * Default constructor for a gremlin object, calls superclass to initiate
     * values
     */
    public Gremlin() {
        super("Gnarltooth the Gremlin", 70, 5, .8, 15, 30);
        
        this.chanceToHeal = .4;
        this.minHeal = 20;
        this.maxHeal = 40;
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
