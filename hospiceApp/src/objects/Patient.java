package objects;

public class Patient {

	protected String name = "";
	protected int age;

	public Patient() {
		// empty constructor
	}

	public Patient(String name) {
		this.name = name;
	}

	public Patient(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
