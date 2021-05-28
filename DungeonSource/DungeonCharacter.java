/**
 * Abstract Base class for inheritance hierarchy for a role playing game
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public abstract class DungeonCharacter {

    protected String name;
    protected int hitPoints;
    protected int attackSpeed;
    protected double chanceToHit;
    protected int damageMin, damageMax;

    /**
     * Full constructor to initialize a dungeon character
     *
     * @param name the character name
     * @param hitPoints the number of hit points the character has
     * @param attackSpeed the character's attack speed
     * @param chanceToHit the character's chance to land a hit
     * @param damageMin the character's minimum damage
     * @param damageMax the character's maximum damage
     */
    public DungeonCharacter(String name, int hitPoints, int attackSpeed,
            double chanceToHit, int damageMin, int damageMax) {

        this.name = name;
        this.hitPoints = hitPoints;
        this.attackSpeed = attackSpeed;
        this.chanceToHit = chanceToHit;
        this.damageMin = damageMin;
        this.damageMax = damageMax;

    }

    /**
     * Get the name of a DungeonCharacter object
     *
     * @return String the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the hit points of a Dungeon character object
     *
     * @return int the character's hit points
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Get the attack speed of a DungeonCharacter object
     *
     * @return int the character's attack speed
     */
    public int getAttackSpeed() {
        return attackSpeed;
    }

    /**
     * addHitPoints is used to increment the hitpoints a dungeon character has
     *
     * @param hitPoints the number of hit points to add
     */
    public void addHitPoints(int hitPoints) {
        if (hitPoints <= 0) {
            System.out.println("Hitpoint amount must be positive.");
        } else {
            this.hitPoints += hitPoints;
            //System.out.println("Remaining Hit Points: " + hitPoints);

        }
    }
    /**
     * This method checks conditions for if the monster heals. If successful,
     * heath is added.
     *
     */
    public void heal(double chanceToHeal, int minHeal, int maxHeal) {
        boolean canHeal;
        int healPoints;

        canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);

        if (canHeal) {
            healPoints = (int) (Math.random() * (maxHeal - minHeal + 1)) + minHeal;
            addHitPoints(healPoints);
            System.out.println(name + " healed for " + healPoints + " points.\n"
                    + "Total hit points remaining are: " + hitPoints);
            System.out.println();
        }
    }

    /**
     * subtractHitPoints is used to decrement the hitpoints a dungeon character
     * has. It also reports the damage and remaining hit points
     *
     * @param hitPoints the number of hit points to subtract
     */
    public void subtractHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            System.out.println("Hitpoint amount must be positive.");
        } else if (hitPoints > 0) {
            this.hitPoints -= hitPoints;
            if (this.hitPoints < 0) {
                this.hitPoints = 0;
            }
            System.out.println(getName() + " hit "
                    + " for <" + hitPoints + "> points damage.");
            System.out.println(getName() + " now has "
                    + getHitPoints() + " hit points remaining.");
            System.out.println();
        }

        if (this.hitPoints == 0) {
            System.out.println(name + " has been killed :-(");
        }

    }

    /**
     * isAlive is used to see if a character is still alive by checking hit
     * points
     *
     * @return boolean True if the DungeonCharacter is alive, False if not
     */
    public boolean isAlive() {
        return (hitPoints > 0);
    }

    /**
     * attack allows character to attempt attack on opponent. First, chance to
     * hit is considered. If a hit can occur, then the damage is calculated
     * based on character's damage range. This damage is then applied to the
     * opponenet.
     *
     * @param opponent the DungeonCharacter object that is being attacked
     */
    public void attack(DungeonCharacter opponent) {
        boolean canAttack;
        int damage;

        canAttack = Math.random() <= chanceToHit;
        //If the stat 'chanceToHit' was greater than a randomly generated number the hit damages the opponent
        if (canAttack) {
            damage = (int) (Math.random() * (damageMax - damageMin + 1)) + damageMin;
            opponent.subtractHitPoints(damage);

            System.out.println();
        } else {

            System.out.println(getName() + "'s attack on " + opponent.getName() + " failed!");
            System.out.println();
        }
    }
    
    abstract void battleChoices(DungeonCharacter opponent);
}
