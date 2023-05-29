import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
	// instance variables
	private String skill;
	
	// constructors
	public RedAstronaut(String name, int susLevel, String skill) {
		super(name, susLevel);
		this.skill = skill;
	}
	
	public RedAstronaut(String name) {
		super(name, 15);
		this.skill = "experience";
	}
	
	// methods
	public String getSkill() {
		return this.skill;
	}
	
	public void setSkill(String newSkill) {
		this.skill = newSkill;
	}
	
	public void emergencyMeeting() {
		if (this.isFrozen() == false) {
			Arrays.sort(this.getPlayers());
			if (this.getPlayers()[0].getName() != this.getName() && this.getPlayers()[0].getSusLevel() != this.getPlayers()[1].getSusLevel()) {
				this.getPlayers()[0].setFrozen(true);
				this.gameOver();
			}
		}
	}
	
	public void freeze(Player p) {
		if (p instanceof Impostor == false && p.isFrozen() == false) {
			if (this.getSusLevel() < p.getSusLevel()) {
				p.setFrozen(true);
			} else {
				this.setSusLevel(this.getSusLevel() * 2);
			}
			this.gameOver();
		}
		
	}
	
	public void sabotage(Player p) {
		if (this.isFrozen() == false && p instanceof Impostor == false && p.isFrozen() == false) {
			if (this.getSusLevel() < 20) {
				p.setSusLevel((int)(p.getSusLevel() * 1.5));
			} else {
				p.setSusLevel((int)(p.getSusLevel() * 1.25));
			}
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof RedAstronaut) {
			RedAstronaut redAst = (RedAstronaut) o;
			return this.getName() == redAst.getName() && 
			this.isFrozen() == redAst.isFrozen() &&
			this.getSusLevel() == redAst.getSusLevel() &&
			this.getSkill() == redAst.getSkill();
		}
		return false;
	}
	
	public String toString() {
		String frozenString = this.isFrozen() ? "frozen" : "not frozen";
        return "My name is " + this.getName() + ", and I have a susLevel of "
                + this.getSusLevel() + ". I am currently " + frozenString + ". I am an " 
				+ this.getSkill() + " player!";
	}
}