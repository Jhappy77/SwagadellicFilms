package Boundary;

import javafx.stage.Stage;

public interface View {
	abstract void begin(Stage s);
	abstract void perform();
}
