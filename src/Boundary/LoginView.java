package Boundary;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView{
	
	private Stage window;
	private Scene scene1, scene2;
	private void signIn(String username, String password)
	{
		
	}
	
	private void signOut()
	{
		
	}
	
	public void setWindow(Stage win)
	{
		window = win;
	}
	
	public void setScene1(Scene s)
	{
		scene1 = s;
	}
	
	public void setScene2(Scene s)
	{
		scene2 = s;
	}
	
	public void perform(VBox layout1, StackPane layout2, Button b)
	{
		
//		window.setScene(scene1);
//		Button button2 = new Button("Go back ");
		b.setOnAction(e->{
			window.setScene(scene1);
		});
		Button button2 = new Button("Sign in");
		button2.setOnAction(e->{
			window.setScene(scene2);
		});
		layout2.getChildren().addAll(button2);
//		StackPane layout2 = new StackPane();
//		layout2.getChildren().addAll(button2);
//		scene2 = new Scene(layout2, 200, 200);
////		window.setScene(scene1);
//		window.show();
	}
	
//	@Override
//	public void perform() {
//		//prompt user to enter username and password here
//		//pass username and password to private functions
//	}

}
