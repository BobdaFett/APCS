package objects;

public class Patient {

	protected String name = "";
	protected int age;

	public Patient() {
		this("");
	}

	public Patient(String name) {
		this(name, 0);
	}

	public Patient(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
