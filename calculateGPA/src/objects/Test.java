package objects;

public class Test extends Assignment {
	public Test() {
		// blank constructor
	}

	public Test(String name) {
		this.name = name;
	}

	public Test(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	private String type = "Test";
	private double weight;
}
