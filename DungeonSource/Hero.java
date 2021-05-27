
import java.util.Scanner;

/**
 * Abstract base class for a hierarchy of heroes. It is derived from
 * DungeonCharacter. A Hero has battle choices: regular attack and a special
 * skill which is defined by the classes derived from Hero.
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public abstract class Hero extends DungeonCharacter {

    protected double chanceToBlock;
    protected int numTurns;

    /**
     * Full constructor for a Hero object
     *
     *
     * @param name the hero name
     * @param hitPoints the number of hit points the hero has
     * @param attackSpeed the hero's attack speed
     * @param chanceToHit the hero's chance to land a hit
     * @param damageMin the hero's minimum damage
     * @param damageMax the hero's maximum damage
     * @param chanceToBlock the hero's chance to block an attack
     */
    public Hero(String name, int hitPoints, int attackSpeed,
            double chanceToHit, int damageMin, int damageMax,
            double chanceToBlock) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        this.chanceToBlock = chanceToBlock;
    }

    /**
     * defend determines if hero blocks attack
     *
     * @return boolean True if they defended, False if not
     */
    public boolean defend() {
        //The character defends if their chance to block is higher than a random number
        return Math.random() <= chanceToBlock;
    }

    /**
     * subtractHitPoints checks to see if hero blocked attack, if so a message
     * is displayed, otherwise base version of this method is invoked to perform
     * the subtraction operation.
     *
     * @param hitPoints the number of hit points to subtract
     */
    @Override
    public void subtractHitPoints(int hitPoints) {
        if (defend()) {
            System.out.println(name + " BLOCKED the attack!");
        } else {
            super.subtractHitPoints(hitPoints);
        }
    }

    /**
     * Computes the number of turns a hero will get per round based on the
     * opponent that is being fought. The number of turns is reported to the
     * user.
     *
     * @param opponent the opponent the hero is fighting
     */
    public void battleChoices(DungeonCharacter opponent) {
        numTurns = attackSpeed / opponent.getAttackSpeed();

        if (numTurns == 0) {
            numTurns++;
        }

        System.out.println("Number of turns this round is: " + numTurns);
    }

}
