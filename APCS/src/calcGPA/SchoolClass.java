package calcGPA;

public class SchoolClass {

	public String name;
	public String grade;
	public String length;
	public double gradeCalc;
	public double lengthCalc;
	
	public SchoolClass(String className, String classGrade, String classLength) {
		
		name = className;
		grade = classGrade;
		length = classLength;
		
		switch(grade) {
		case "A+":
			gradeCalc = 4.0;
			break;
		case "A":
			gradeCalc = 3.5;
			break;
		case "B+":
			gradeCalc = 3.0;
			break;
		case "B":
			gradeCalc = 2.5;
			break;
		case "C+":
			gradeCalc = 2.0;
			break;
		case "C":
			gradeCalc = 1.5;
			break;
		case "D": 
			gradeCalc = 1.0;
			break;
		case "F+":
			gradeCalc = 0.5;
			break;
		case "F":
			gradeCalc = 0.0;
			break;
		}
		
		switch(length) {
		case "Half Year":
			lengthCalc = 2.0;
		case "Full Year":
			lengthCalc = 1.0;
		}
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGradeVerbose() { //returns the letter grade of the class
		return grade;
	}
	
	public double getGradeCalc() {
		return gradeCalc;
	}
	
	public String getLengthVerbose() { //only used to tell people - no calculations
		return length;
	}
	
	public double getLengthCalc() { //only used for calculations
		return lengthCalc;
	}
	
	public double calcGPA() {
		double GPA = gradeCalc/lengthCalc;
		return GPA;
	}
	
}
