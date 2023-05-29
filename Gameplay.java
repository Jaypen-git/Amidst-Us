public class Gameplay {
	public static void main(String[] args) {
		BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
		BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
		BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
		BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);
		RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
		RedAstronaut sussy = new RedAstronaut("Suspicious Person", 100, "expert");
		liam.sabotage(bob);
		// Bob should have susLevel = 30, frozen = false
		System.out.println("Sus level: " + bob.getSusLevel() + ", Frozen: " + bob.isFrozen());
		liam.freeze(sussy);
		// Nothing should happen
		System.out.println(sussy.isFrozen());
		liam.freeze(albert);
		// Liam should have susLevel = 19, albert = frozen
		System.out.println(liam.toString());
		System.out.println("Albert is frozen? " + albert.isFrozen());
		// Nothing should happen
		albert.emergencyMeeting();
		// Nothing should happen x2
		sussy.emergencyMeeting();
		// Suspicious person should be frozen
		bob.emergencyMeeting();
		System.out.println("Is sussy frozen? " + sussy.isFrozen());
		// Heath should have 1 task left after running function
		heath.completeTask();
		System.out.println(heath.getNumTasks());
		// Heath should finish all his tasks
		heath.completeTask();
		// Nothing should happen
		heath.completeTask();
		System.out.println(heath.getNumTasks());
		liam.freeze(angel);
		// Liam should have susLevel = 38, and Angel should have frozen = false
		System.out.println("Liam sus level: " + liam.getSusLevel() + ", Angel is frozen? " + angel.isFrozen());
		liam.sabotage(bob);
		System.out.println("Bob sus level: " + bob.getSusLevel());
		liam.sabotage(bob);
		System.out.println("Bob sus level: " + bob.getSusLevel());
		liam.freeze(bob);
		System.out.println("Bob is frozen? " + bob.isFrozen());
		angel.emergencyMeeting();
		System.out.println("Liam is frozen? " + liam.isFrozen());
	}
}