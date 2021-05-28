/**
 * This class is the driver file for the Heroes and Monsters project. It will
 * do the following:
 *
 * 1.  Allow the user to choose a hero
 * 2.  Randomly select a monster
 * 3.  Allow the hero to battle the monster
 *
 * Once a battle concludes, the user has the option of repeating the above
 *
 * @author Original Authors
 * @author Tyler Rose
 */
public class Dungeon {

    /**
     * Main function, houses game loop for choosing character, generating
     * monster, and battling
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        DungeonCharacter theHero;
        DungeonCharacter theMonster;
        
        
        Factory factory = new Factory();
        AbstractFactory heroFactory = factory.createFactory("Hero");
        AbstractFactory monsterFactory = factory.createFactory("");

        do {
            theHero = chooseHero(heroFactory);
            theMonster = generateMonster(monsterFactory);
            battle(theHero, theMonster);

        } while (playAgain());

    }

    /**
     * chooseHero allows the user to select a hero, creates that hero, and
     * returns it. It utilizes a polymorphic reference (Hero) to accomplish this
     * task
     *
     * @return Hero the Hero object of the chosen class
     */
    public static DungeonCharacter chooseHero(AbstractFactory heroFactory) {
        int choice;
        System.out.println("Enter your Character's name:");
        String name = Keyboard.readString();

        System.out.println("Choose a hero:\n"
                + "1. Warrior\n"
                + "2. Sorceress\n"
                + "3. Thief");
        choice = Keyboard.readInt();

        switch (choice) {
            case 1:
                return heroFactory.createCharacter("warrior", name);

            case 2:
                return heroFactory.createCharacter("sorceress", name);

            case 3:
                return heroFactory.createCharacter("thief", name);

            default:
                System.out.println("invalid choice, returning Thief");
                return heroFactory.createCharacter("thief", name);
        }//end switch
    }//end chooseHero method

    /**
     *
     * generateMonster randomly selects a Monster and returns it. It utilizes a
     * polymorphic reference (Monster) to accomplish this task.
     *
     * @return Monster the Monster object that was generated
     */
    public static DungeonCharacter generateMonster(AbstractFactory monsterFactory) {
        int choice;

        choice = (int) (Math.random() * 3) + 1;

        switch (choice) {
            case 1:
                return monsterFactory.createCharacter("ogre", null);

            case 2:
                return monsterFactory.createCharacter("Gremlin", null);

            case 3:
                return monsterFactory.createCharacter("skeleton", null);

            default:
                System.out.println("Invalid choice, returning Skeleton");
                return new Skeleton();
        }
    }

    /**
     * playAgain allows gets choice from user to play another game. It returns
     * true if the user chooses to continue, false otherwise.
     *
     * @return boolean True if they chose to play again, false if not.
     */
    public static boolean playAgain() {
        char again;

        System.out.println("Play again (y/n)?");
        again = Keyboard.readChar();

        return (again == 'Y' || again == 'y');
    }

    /**
     * battle is the actual combat portion of the game. It requires a Hero and a
     * Monster to be passed in. Battle occurs in rounds. The Hero goes first,
     * then the Monster. At the conclusion of each round, the user has the
     * option of quitting.
     *
     * @param theHero the hero that is being used in the battle
     * @param theMonster the monster that is being used in the battle
     */
    public static void battle(DungeonCharacter theHero, DungeonCharacter theMonster) {
        char pause = 'p';
        System.out.println(theHero.getName() + " battles "
                + theMonster.getName());
        System.out.println("---------------------------------------------");

        //Battle loop, continues if the game is unpaused with both the hero and monster alive
        while (theHero.isAlive() && theMonster.isAlive() && pause != 'q') {
            //hero goes first
            theHero.battleChoices(theMonster);

            //monster's turn if it is alive
            if (theMonster.isAlive()) {
                theMonster.attack(theHero);
            }

            //let the player quit if desired
            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = Keyboard.readChar();

        }

        //Check and display victory conditions based on who is alive
        if (!theMonster.isAlive()) {
            System.out.println(theHero.getName() + " was victorious!");
        } else if (!theHero.isAlive()) {
            System.out.println(theHero.getName() + " was defeated :-(");
        } else//both are alive so user quit the game
        {
            System.out.println("Quitters never win ;-)");
        }

    }

}
