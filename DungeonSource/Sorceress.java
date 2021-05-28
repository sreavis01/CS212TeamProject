/**
 * Concrete Sorceress class that holds represents a sorceress Hero
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Sorceress extends DungeonCharacter {

    public final int MIN_ADD = 25;
    public final int MAX_ADD = 50;
    public final double chanceToHeal = 1;
    
    protected double chanceToBlock;
    protected int numTurns;

    /**
     * Default constructor for a sorceress object, calls superclass to initiate
     * values
     */
    public Sorceress(String name) {
        super(name, 75, 5, .7, 25, 50);
        
        this.chanceToBlock = .3;
    }

    /**
     * Adds hit points to the sorceress
     *
     */
    public void increaseHitPoints() {
        super.heal(chanceToHeal, MIN_ADD, MAX_ADD);
    }

    /**
     * Attack method for a sorceress character.
     *
     * @param opponent the opponent the sorceress is attacking
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " casts a spell of fireball at "
                + opponent.getName() + ":");
        super.attack(opponent);
    }

    /**
     * Choices presented to the player when they have selected the sorceress
     * class to let them choose their action.
     *
     * @param opponent the opponent the sorceress is attacking
     */
    public void battleChoices(DungeonCharacter opponent) {
    	
        int choice;
        int numTurns = attackSpeed / opponent.getAttackSpeed();

        if (numTurns == 0) {
            numTurns++;
        }

        System.out.println("Number of turns this round is: " + numTurns);

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Increase Hit Points");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();

            switch (choice) {
                case 1:
                    attack(opponent);
                    break;
                case 2:
                    increaseHitPoints();
                    break;
                default:
                    System.out.println("invalid choice!");
            }

            numTurns--;
            if (numTurns > 0) {
                System.out.println("Number of turns remaining is: " + numTurns);
            }
        } while (numTurns > 0 && hitPoints > 0 && opponent.getHitPoints() > 0);
    }
}
