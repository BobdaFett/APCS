package objects;

class justForTesting {
	public void testy(String str) {
		System.out.println(str);
	}
}

public class Assignment extends justForTesting {

	protected String name;
	protected String letterGrade;
	protected int grade;

	public Assignment() {
		// blank constructor
	}

	public Assignment(String name) {
		this.name = name;
	}

	public Assignment(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public String getLetterGrade() {
		return letterGrade;
	}

	public int getGrade() {
		return grade;
	}

	public void setName(String name) {
		this.name = name;
	}

}