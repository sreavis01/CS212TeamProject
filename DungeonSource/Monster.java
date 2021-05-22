
/**
 * Abstract Monster class that is used to create different monster types.
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public abstract class Monster extends DungeonCharacter {

    protected double chanceToHeal;
    protected int minHeal,
            maxHeal;

    /**
     * Full constructor for a Monster object
     *
     * @param name the monster name
     * @param hitPoints the number of hit points the monster has
     * @param attackSpeed the monster's attack speed
     * @param chanceToHit the monster's chance to land a hit
     * @param damageMin the monster's minimum damage
     * @param damageMax the monster's maximum damage
     * @param chanceToHeal the monster's chance to heal
     * @param minHeal the monster's minimum heal amount
     * @param maxHeal the monster's maximum heal amount
     */
    public Monster(String name, int hitPoints, int attackSpeed,
            double chanceToHit, double chanceToHeal,
            int damageMin, int damageMax,
            int minHeal, int maxHeal) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        this.chanceToHeal = chanceToHeal;
        this.maxHeal = maxHeal;
        this.minHeal = minHeal;

    }

    /**
     * This method checks conditions for if the monster heals. If successful,
     * heath is added.
     *
     */
    public void heal() {
        boolean canHeal;
        int healPoints;

        canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);

        if (canHeal) {
            healPoints = (int) (Math.random() * (maxHeal - minHeal + 1)) + minHeal;
            addHitPoints(healPoints);
            System.out.println(name + " healed itself for " + healPoints + " points.\n"
                    + "Total hit points remaining are: " + hitPoints);
            System.out.println();
        }
    }

    /**
     * Subtract hitpoints from the monster, then attempts a heal
     *
     * @param hitPoints the number of hitpoints to subtract
     */
    public void subtractHitPoints(int hitPoints) {
        super.subtractHitPoints(hitPoints);
        heal();
    }
}
