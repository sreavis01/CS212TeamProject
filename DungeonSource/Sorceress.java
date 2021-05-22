
/**
 * Concrete Sorceress class that holds represents a sorceress Hero
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Sorceress extends Hero {

    public final int MIN_ADD = 25;
    public final int MAX_ADD = 50;

    /**
     * Default constructor for a sorceress object, calls superclass to initiate
     * values
     */
    public Sorceress() {
        super("Sorceress", 75, 5, .7, 25, 50, .3);

    }

    /**
     * Adds hit points to the sorceress
     *
     */
    public void increaseHitPoints() {
        int hPoints;

        hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
        addHitPoints(hPoints);
        System.out.println(name + " added [" + hPoints + "] points.\n"
                + "Total hit points remaining are: "
                + hitPoints);
        System.out.println();

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
        super.battleChoices(opponent);
        int choice;

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
