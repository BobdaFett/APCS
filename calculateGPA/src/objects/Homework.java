package objects;

public class Homework extends Assignment {
	public Homework() {
		// blank constructor
	}

	public Homework(String name) {
		this.name = name;
	}

	public Homework(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	private String type = "Homework";
	private double weight;
}
