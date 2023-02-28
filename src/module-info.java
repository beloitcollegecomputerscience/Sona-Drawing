<<<<<<< HEAD
module JavaFX {
	requires javafx.controls;
	requires javafx.graphics;
=======
module sona_Drawing {
	requires javafx.controls;
	requires org.junit.jupiter.api;
>>>>>>> 465aa560bbe89282d197c6c1f5b077edfe24b50b
	
	opens application to javafx.graphics, javafx.fxml;
}
