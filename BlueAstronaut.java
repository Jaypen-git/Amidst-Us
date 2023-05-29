import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
	// instance variables
	private int numTasks;
	private int taskSpeed;
	
	// constructors
	public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
		super(name, susLevel);
		this.numTasks = numTasks;
		this.taskSpeed = taskSpeed;
	}
	
	public BlueAstronaut(String name) {
		super(name, 15);
		this.numTasks = 6;
		this.taskSpeed = 10;
	}
	
	// methods
	public int getNumTasks() {
		return this.numTasks;
	}
	
	public void setNumTasks(int x) {
		if (x >= 0) {
			this.numTasks = x;	
		}
	}
	
	public int getTaskSpeed() {
		return this.taskSpeed;
	}
	
	public void setTaskSpeed(int x) {
		if (x > 0) {
			this.taskSpeed = x;
		}
	}
	
	public void emergencyMeeting() {
		if (this.isFrozen() == false) {
			Arrays.sort(this.getPlayers());
			if (this.getPlayers()[0].getName() != this.getName() && this.getPlayers()[0].getSusLevel() != this.getPlayers()[1].getSusLevel()) {
				this.getPlayers()[0].setFrozen(true);
				System.out.println(this.getPlayers()[0].getName() + " is frozen"); // this should be deleted
				this.gameOver();
			} else { // this should be deleted
				System.out.println("No one was frozen");
			}
		}
	}
	
	public void completeTask() {
		if (this.isFrozen() == false && this.getNumTasks() > 0) {
			if (this.getTaskSpeed() > 20) {
				if (this.getNumTasks() - 2 < 0) {
					this.setNumTasks(0);
				} else {
					this.setNumTasks(this.getNumTasks() - 2);
				}
			} else {
				this.setNumTasks(this.getNumTasks() - 1);
			}
		} else {
			System.out.println("I have completed all my tasks");
			this.setSusLevel((int)(this.getSusLevel() * 0.5));
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof BlueAstronaut) {
			BlueAstronaut blueAst = (BlueAstronaut) o;
			return this.getName() == blueAst.getName() && 
			this.isFrozen() == blueAst.isFrozen() && 
			this.getNumTasks() == blueAst.getNumTasks() &&
			this.getTaskSpeed() == blueAst.getTaskSpeed();
		}
		return false;
	}
	
	public String toString() {
		String frozenString = this.isFrozen() ? "frozen" : "not frozen";
		return "My name is " + this.getName() + ", and I have a susLevel of "
		+ this.getSusLevel() + ". I am currently " + frozenString + ". I have " 
		+ this.getNumTasks() + " left over";
	}
	
	// test
	public static void main(String[] args) {
		BlueAstronaut notSussy = new BlueAstronaut("Not Sussy", 6, 10, 8);
		RedAstronaut sussy = new RedAstronaut("Sussy Baka");
		System.out.println(notSussy.equals(sussy));
	}
}