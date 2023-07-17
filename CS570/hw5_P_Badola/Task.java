//Paarth Badola
//20012789

public class Task {
	int multiplier;
	int multiplicity;

	public Task(int operation, int condition) {
		multiplier = operation;
		multiplicity = condition;
	}

	public void execute(int[] L, int time) {

		if (time % multiplicity == 0)
			L[time] *= multiplier;

	}

	public String toString() {
		return "Operation: multiply by = " + multiplier + ", " + "condition: time is multiple of " + multiplicity
				+ "\n";
	}

}
