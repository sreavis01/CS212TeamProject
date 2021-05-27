
/**
 * Concrete Thief class that holds represents a thief Hero
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Thief extends Hero {

    /**
     * Default constructor for a thief object, calls superclass to initiate
     * values
     */
    public Thief(String name) {
        super(name, 75, 6, .8, 20, 40, .5);
    }

    /**
     * A surprise attack for the thief.
     *
     * @param opponent the opponent the thief is attacking
     */
    public void surpriseAttack(DungeonCharacter opponent) {
        double surprise = Math.random();
        if (surprise <= .4) {
            System.out.println("Surprise attack was successful!\n"
                    + name + " gets an additional turn.");
            numTurns++;
            attack(opponent);
        } else if (surprise >= .9) {
            System.out.println("Uh oh! " + opponent.getName() + " saw you and blocked your attack!");
        } else {
            attack(opponent);
        }
    }

    /**
     * Choices presented to the player when they have selected the thief class
     * to let them choose their action.
     *
     * @param opponent the opponent the thief is attacking
     */
    public void battleChoices(DungeonCharacter opponent) {
        super.battleChoices(opponent);
        int choice;

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Surprise Attack");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();

            switch (choice) {
                case 1:
                    attack(opponent);
                    break;
                case 2:
                    surpriseAttack(opponent);
                    break;
                default:
                    System.out.println("invalid choice!");
            }

            numTurns--;
            if (numTurns > 0) {
                System.out.println("Number of turns remaining is: " + numTurns);
            }
        } while (numTurns > 0);
    }
}
