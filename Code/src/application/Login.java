package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class Login extends Main {
	@FXML
	private TextField txtUserName;
	@FXML
	private TextField txtPassword;
	@FXML
	private Label lblStatus;
	@FXML
	private Button loginBtn;
	//
	public void  LoginApprove(ActionEvent event) throws Exception {
		if(txtUserName.getText().equalsIgnoreCase("user")&& txtPassword.getText().equals("hellboy")){
			Parent root=FXMLLoader.load(getClass().getResource("/application/Level4.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root,763,667);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) loginBtn.getScene().getWindow();
		    stage.close(); 
		}else{
			lblStatus.setText("Login Failed");
		}
	}
	

}
