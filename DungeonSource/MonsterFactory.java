
public class MonsterFactory extends AbstractFactory {
	
	//Singleton
	private volatile static MonsterFactory uniqueInstance;
	
	private MonsterFactory() {}
	
	public static synchronized MonsterFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new MonsterFactory();
		}
		
		return uniqueInstance;
	}
	
	
	protected DungeonCharacter createCharacter(String type, String name) {
		
		switch (type.toLowerCase()) {
			case "skeleton": return new Skeleton();
			case "gremlin": return new Gremlin();
			case "ogre": return new Ogre();
		}
		
		return null;
	}
}
