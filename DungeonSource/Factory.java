
public class Factory {
	public AbstractFactory createFactory(String type) {
		
		if (type.equalsIgnoreCase("hero")) {
			return HeroFactory.getInstance();
		}
		else {
			return MonsterFactory.getInstance();
		}
	}
}
