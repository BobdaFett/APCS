package objects;

public class Assignment {

	private String name;
	private String letterGrade;
	private int grade;
	
	public Assignment() {
		// this is just a basic constructor
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
	
	// The next couple parts lay down a foundation for the types of assignments
	
	class Test extends Assignment {
		
		private String type = "Test";
		private int weight; //this should be in a percentage
		
	}

	class Homework extends Assignment {
		
		private String type = "Homework";
		private int weight; //this should be in a percentage
		
	}
}

