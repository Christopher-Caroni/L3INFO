package fil.coo;

public class Forseable extends Action{

	int timeToFinish;
	
	public Forseable(int remainingTime){
		this.timeToFinish = remainingTime;
	}

	@Override
	boolean stopCondition() {
		return time == timeToFinish;	
	}
	
}
