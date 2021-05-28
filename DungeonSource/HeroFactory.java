
public class HeroFactory extends AbstractFactory {
	
	//Singleton
	private volatile static HeroFactory uniqueInstance;
	
	private HeroFactory() {}
	
	public static synchronized HeroFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new HeroFactory();
		}
		
		return uniqueInstance;
	}
	
	protected DungeonCharacter createCharacter(String type, String name) {
		
		switch (type.toLowerCase()) {
			case "sorceress": return new Sorceress(name);
			case "warrior": return new Warrior(name);
			case "thief": return new Thief(name);
		}
		
		return null;
	}
}
