import java.util.Observable;

public class HealthObservable extends Observable{
	
	
	
	public void healthStat(Health gg) {
		setChanged();
		notifyObservers(gg);
		clearChanged();
	}
}
