
public class Health {
	private int life;
	
	Health() {
		this.life = 1;
	}
	
	Health(int totalHealth) {
		this.life = totalHealth;
	}
	
	@Override
	public String toString() {
		return "Health is at " + this.life + "\n";
	}
}
