module calculateGPA {
	exports application;
	exports calcGPA;
	exports objects;

	opens objects to javafx.base;

	requires javafx.base;
	requires transitive javafx.graphics;
	requires transitive javafx.controls;
}