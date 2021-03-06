/**
 * Concrete Warrior class that holds represents a warrior Hero
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Warrior extends DungeonCharacter {

    protected double chanceToBlock;
    protected int numTurns;
    /**
     * Default constructor for a warrior object, calls superclass to initiate
     * values
     */
    public Warrior(String name) {
        super(name, 125, 4, .8, 35, 60);
        
        this.chanceToBlock = .2;
    }

    public void crushingBlow(DungeonCharacter opponent) {
        if (Math.random() <= .4) {
            int blowPoints = (int) (Math.random() * 76) + 100;
            System.out.println(name + " lands a CRUSHING BLOW for " + blowPoints
                    + " damage!");
            opponent.subtractHitPoints(blowPoints);
        } else {
            System.out.println(name + " failed to land a crushing blow");
            System.out.println();
        }
    }

    /**
     * Attack method for a warrior character.
     *
     * @param opponent the opponent the warrior is attacking
     */
    @Override
    public void attack(DungeonCharacter opponent) {
        System.out.println(name + " swings a mighty sword at "
                + opponent.getName() + ":");
        super.attack(opponent);
    }

    /**
     * Choices presented to the player when they have selected the warrior class
     * to let them choose their action.
     *
     * @param opponent the opponent the warrior is attacking
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
            System.out.println("2. Crushing Blow on Opponent");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();

            switch (choice) {
                case 1:
                    attack(opponent);
                    break;
                case 2:
                    crushingBlow(opponent);
                    break;
                default:
                    System.out.println("invalid choice!");
            }

            numTurns--;
            if (numTurns > 0) {
                System.out.println("Number of turns remaining is: " + numTurns);
            }
        } while (numTurns > 0 && opponent.isAlive() && this.isAlive());
    }
}
