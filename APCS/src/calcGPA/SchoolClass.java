package calcGPA;

public class SchoolClass {

	public String name;
	public String grade;
	public String length;
	public double gradeCalc;
	public double lengthCalc;
	
	public SchoolClass(String className) {
		
		name = className;
		grade = "N/A";
		length = "N/A";
		
	}
	
	public SchoolClass(String n, String g, String l) {
		
		name = n;
		grade = g;
		setGrade(grade);
		length = l;
		setLength(length);
		
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGrade(String newGrade) {
		grade = newGrade;
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
	}
	
	public String getGradeVerbose() { //returns the letter grade of the class
		return grade;
	}
	
	public double getGradeCalc() {
		return gradeCalc;
	}
	
	public void setLength(String newLength) {
		length = newLength;
		switch(length) {
		case "Half Year":
			lengthCalc = 2.0;
		case "Full Year":
			lengthCalc = 1.0;
		}
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
