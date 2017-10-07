package fil.coo.actions;

public class Foreseeable extends Action{
	
	private int waitingTime;

	public Foreseeable(int waiting) {
		this.waitingTime = waiting;
	}
	
	protected void realStep() {this.waitingTime-- ;}

    public boolean stopCondition() {
        return this.waitingTime == 0;
    }
	
}
