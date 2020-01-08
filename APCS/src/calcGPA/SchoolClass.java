package calcGPA;

public class SchoolClass {

	public String name;
	public String grade;
	public String length;
	public double gradeCalc;
	public double lengthCalc;

	/**
	 * Creates class with only a name. Will require use of other methods later.
	 * 
	 * @param name
	 */
	public SchoolClass(String name) {

		this.name = name;
		this.grade = "N/A";

		this.length = "N/A";

	}

	/**
	 * Sets name of the class.
	 * 
	 * @param newName
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Returns the name of the class.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets both letter grade and number of credits, respectively.
	 * 
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
		switch (grade) {
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

	/**
	 * Returns the letter grade. Not useful in calculations.
	 * 
	 * @return
	 */
	public String getGradeVerbose() {
		return grade;
	}

	/**
	 * Returns grade as a number of credits. Intended for calculations.
	 * 
	 * @return
	 */
	public double getGradeCalc() {
		return gradeCalc;
	}

	/**
	 * Sets length and lengthCalc as a string value and a number.
	 * 
	 * @param length
	 */
	public void setLength(String length) {
		this.length = length;
		switch (length) {
		case "Half Year":
			lengthCalc = 2.0;
		case "Full Year":
			lengthCalc = 1.0;
		}
	}

	/**
	 * Returns the length as a string value. Not useful for calculations. Seems to
	 * be a duplicate method.
	 * 
	 * @return
	 */
	public String getLength() {
		return length;
	}

	/**
	 * Returns length as a string value. Not useful for calculations.
	 * 
	 * @return
	 */
	public String getLengthVerbose() {
		return length;
	}

	/**
	 * Returns length as a number for calculations.
	 * 
	 * @return
	 */
	public double getLengthCalc() {
		return lengthCalc;
	}

	/**
	 * Calculates the GPA and returns the value as a double.
	 * 
	 * @return
	 */
	public double getGPA() {
		double GPA = gradeCalc / lengthCalc;
		return GPA;
	}

	/**
	 * WIP - Updates the TableView with any new information.
	 * 
	 * @param index
	 */
	public static void update(int index) {
	}

}
