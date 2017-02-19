package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Level5Controller extends Level4Controller {

	@FXML // defining textFields of exam marks in FXML
	private TextField txtMark0L5, txtMark1L5, txtMark2L5, txtMark3L5, txtMark4L5, txtMark5L5, txtMark6L5, txtMark7L5,
			txtMark8L5, txtMark9L5, txtMark10L5;
	// creating a Level5Controller type array
	public static Level5Controller[] arrayL5 = new Level5Controller[6];
	// average of the level 5
	double avgL5;
	// creating an array to store marks of exams
	double[] marksL5 = new double[11];
	// creating an array to store averages of each module in level5
	double[] avgModL5 = new double[6];
	//validating level 5 input marks
	public boolean validationL5(){
		boolean status =true;
		if(inputNumbValidation(txtMark0L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark1L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark2L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark3L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark4L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark5L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark6L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark7L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark8L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark9L5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark10L5)){
		}else{
			status=false;
		}
		
		return status;
		
	}
	// initial attempt mark getting method
	public void markGetterL5() {

		marksL5[0] = Double.parseDouble(txtMark0L5.getText());
		marksL5[1] = Double.parseDouble(txtMark1L5.getText());
		marksL5[2] = Double.parseDouble(txtMark2L5.getText());
		marksL5[3] = Double.parseDouble(txtMark3L5.getText());
		marksL5[4] = Double.parseDouble(txtMark4L5.getText());
		marksL5[5] = Double.parseDouble(txtMark5L5.getText());
		marksL5[6] = Double.parseDouble(txtMark6L5.getText());
		marksL5[7] = Double.parseDouble(txtMark7L5.getText());
		marksL5[8] = Double.parseDouble(txtMark8L5.getText());
		marksL5[9] = Double.parseDouble(txtMark9L5.getText());
		marksL5[10] = Double.parseDouble(txtMark10L5.getText());

		avgModL5[0] = (marksL5[0] + marksL5[1]) / 2;
		avgModL5[1] = (marksL5[2] + marksL5[3]) / 2;
		avgModL5[2] = marksL5[4];
		avgModL5[3] = (marksL5[5] + marksL5[6]) / 2;
		avgModL5[4] = (marksL5[7] + marksL5[8]) / 2;
		avgModL5[5] = (marksL5[9] + marksL5[10]) / 2;

		avgL5 = (avgModL5[0] + avgModL5[1] + avgModL5[2] + avgModL5[3] + avgModL5[4] + avgModL5[5]) / 6;

		// creating a Level5Controller type object and assigning average to it
		// and storing that object in Level5Controller type array
		for (int a = 0; a < 6; a++) {
			Level5Controller moduleL5 = new Level5Controller();
			moduleL5.setAverage(avgModL5[a]);
			arrayL5[a] = moduleL5;
		}
	}

	// average calculating method for 2,3,4 attempts
	public void avgSetterL5(int attempt) {
		avgModL5[0] = (marksL5[0] + marksL5[1]) / 2;
		avgModL5[1] = (marksL5[2] + marksL5[3]) / 2;
		avgModL5[2] = marksL5[4];
		avgModL5[3] = (marksL5[5] + marksL5[6]) / 2;
		avgModL5[4] = (marksL5[7] + marksL5[8]) / 2;
		avgModL5[5] = (marksL5[9] + marksL5[10]) / 2;

		avgL5 = (avgModL5[0] + avgModL5[1] + avgModL5[2] + avgModL5[3] + avgModL5[4] + avgModL5[5]) / 6;

		for (int a = 0; a < 6; a++) {
			arrayL5[a].setAverage(avgModL5[a]);
		}
	}

	@FXML // defining labels of each module status in FXML
	private Label lblL5Mod1Status, lblL5Mod2Status, lblL5Mod3Status, lblL5Mod4Status, lblL5Mod5Status, lblL5Mod6Status;

	@FXML // defining labels of each module status in FXML
	private Label lblL5Mod1Atmpt, lblL5Mod2Atmpt, lblL5Mod3Atmpt, lblL5Mod4Atmpt, lblL5Mod5Atmpt, lblL5Mod6Atmpt;

	int failModsL5 = 0;// total number of failed modules in level 5
	int passModsL5 = 0;// total number of passed modules in level 5
	int creditsL5 = 0;// total number of credits level 5
	
	//pass or fail setter for exam marks in all attempts in level5
	public void passFailSetterL5() {
		for (int j = 0; j < 6; j++) {
			if ( arrayL5[j].getPass()==false && arrayL5[j].getAverage() >= 40) {
				arrayL5[j].setPass(true);
				passModsL5 += 1;
				creditsL5 += 20;
			} else if (arrayL5[j].getPass()==false && arrayL5[j].getAverage() < 40) {  
				failModsL5++;
				arrayL5[j].setPass(false);
				arrayL5[j].setAttempt(true);
			} else {}
		}
	}
	//Level 5 mark getter for attempts 2,3,4
	public void atmptMarkGetterL5(int atmptNum) {
		if (arrayL5[0].getAttempt() == atmptNum) {
			marksL5[0] = Double.parseDouble(txtMark0L5.getText());
			marksL5[1] = Double.parseDouble(txtMark1L5.getText());
		} else {}
		if (arrayL5[1].getAttempt() == atmptNum) {
			marksL5[2] = Double.parseDouble(txtMark2L5.getText());
			marksL5[3] = Double.parseDouble(txtMark3L5.getText());
		} else {}
		if (arrayL5[2].getAttempt() == atmptNum) {
			marksL5[4] = Double.parseDouble(txtMark4L5.getText());
		} else {}
		if (arrayL5[3].getAttempt() == atmptNum) {
			marksL5[5] = Double.parseDouble(txtMark5L5.getText());
			marksL5[6] = Double.parseDouble(txtMark6L5.getText());
		} else {}
		if (arrayL5[4].getAttempt() == atmptNum) {
			marksL5[7] = Double.parseDouble(txtMark7L5.getText());
			marksL5[8] = Double.parseDouble(txtMark8L5.getText());
		} else {}
		if (arrayL5[5].getAttempt() == atmptNum) {
			marksL5[9] = Double.parseDouble(txtMark9L5.getText());
			marksL5[10] = Double.parseDouble(txtMark10L5.getText());
		} else {}
	}
	@FXML
	private Label lblL5Status, lblL5Credits, lblL5Avg, lblL6Eligible, lblDipHEEligible, lblDipHEClass;

	@FXML
	private Label lblMsgL5, lblExclusionL5;

	boolean exclusionL5 = false;
	boolean dipHEEligible=false;
	boolean eligibleL6 = false;
	//method to display results of level 5
	public void Level5ListPrint() {
		//checking number of failed modules in level5
		lblMsgL5.setText("");
		if (passModsL5 == 5 ||passModsL5 == 4 || passModsL5 == 3) {
			lblMsgL5.setText("Please Enter Exam Mark/s for Failed Module/s");
		} else if (passModsL5 == 0 || passModsL5 == 1 || passModsL5 == 2) {
			exclusionL5 = true;
			lblExclusionL5.setText("Student has been EXCLUDED");
			lblExclusionL5.setStyle("-fx-text-fill:red;");
			btnLevel5Next2.setVisible(false);
		} else {}
		//checking for modules which are failed in all four attempts and setting exclusion status		
		for(int i=0;i<6;i++){
			if(arrayL5[i].getAttempt()==5 && exclusionL5==false){
				exclusionL5=true;
				lblExclusionL5.setText("Student has been EXCLUDED");
				lblExclusionL5.setStyle("-fx-text-fill:red;");
				lblMsgL5.setText("");
			}else if(exclusionL5==false){
				lblExclusionL5.setText("NO");
			}else{}
		}
		//level 6 eligibility
		if (creditsL5 >= 100) {
			lblL6Eligible.setText("Eligible");
			eligibleL6 = true;
		} else {
			lblL6Eligible.setText("Not Eligible");
			eligibleL6 = false;
		}
		//DipHE eligibility
		if (creditsL5 == 120) {
			lblDipHEEligible.setText("Eligible");
			dipHEEligible=true;
			lblL5Status.setText("Pass");
		} else {
			lblDipHEEligible.setText("Not Eligible");
			lblL5Status.setText("Fail");
		}		
		int classIndicatorL5=0;
		for(int i=0;i<6;i++){
			if(arrayL5[i].getAttempt()==1){
				classIndicatorL5++;
			}else{}
		}
		//checking eligibility for classes in DipHE
		if (avgL5 >= 70 && dipHEEligible==true && classIndicatorL5==6) {
			lblDipHEClass.setText("Distinction");
		} else if (avgL5 >= 60 && dipHEEligible==true && classIndicatorL5==6) {
			lblDipHEClass.setText("Merit");
		} else {
			lblDipHEClass.setText("No");
		}

		lblL5Credits.setText(String.valueOf(creditsL5));
		lblL5Avg.setText(String.valueOf(avgL5));
		//displaying attempt number of each module
		if (exclusionL5 == false) {
			lblL5Mod1Atmpt.setText(String.valueOf(arrayL5[0].getAttempt()));
			lblL5Mod2Atmpt.setText(String.valueOf(arrayL5[1].getAttempt()));
			lblL5Mod3Atmpt.setText(String.valueOf(arrayL5[2].getAttempt()));
			lblL5Mod4Atmpt.setText(String.valueOf(arrayL5[3].getAttempt()));
			lblL5Mod5Atmpt.setText(String.valueOf(arrayL5[4].getAttempt()));
			lblL5Mod6Atmpt.setText(String.valueOf(arrayL5[5].getAttempt()));
		} else {}
		//displaying pass or fail status of modules in level 5
		if (arrayL5[0].getPass() == false) {
			lblL5Mod1Status.setText("Fail");
			lblL5Mod1Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL5Mod1Status.setText("Pass");
			lblL5Mod1Status.setStyle("-fx-text-fill:green;");
			txtMark0L5.setEditable(false);
			txtMark1L5.setEditable(false);
		}
		if (arrayL5[1].getPass() == false) {
			lblL5Mod2Status.setText("Fail");
			lblL5Mod2Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL5Mod2Status.setText("Pass");
			lblL5Mod2Status.setStyle("-fx-text-fill:green;");
			txtMark2L5.setEditable(false);
			txtMark3L5.setEditable(false);
		}
		if (arrayL5[2].getPass() == false) {
			lblL5Mod3Status.setText("Fail");
			lblL5Mod3Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL5Mod3Status.setText("Pass");
			lblL5Mod3Status.setStyle("-fx-text-fill:green;");
			txtMark4L5.setEditable(false);
		}
		if (arrayL5[3].getPass() == false) {
			lblL5Mod4Status.setText("Fail");
			lblL5Mod4Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL5Mod4Status.setText("Pass");
			lblL5Mod4Status.setStyle("-fx-text-fill:green;");
			txtMark5L5.setEditable(false);
			txtMark6L5.setEditable(false);
		}
		if (arrayL5[4].getPass() == false) {
			lblL5Mod5Status.setText("Fail");
			lblL5Mod5Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL5Mod5Status.setText("Pass");
			lblL5Mod5Status.setStyle("-fx-text-fill:green;");
			txtMark7L5.setEditable(false);
			txtMark8L5.setEditable(false);
		}
		if (arrayL5[5].getPass() == false) {
			lblL5Mod6Status.setText("Fail");
			lblL5Mod6Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL5Mod6Status.setText("Pass");
			lblL5Mod6Status.setStyle("-fx-text-fill:green;");
			txtMark9L5.setEditable(false);
			txtMark10L5.setEditable(false);
		}
	}
//method which returns an array with averages of modules in level5 for award classification	
	public static double []sortArrayL5=new double[6];
	public double[] honsAwardStep01(){
			for(int i=0;i<6;i++){
				sortArrayL5[i]=arrayL5[i].getAverage();
			}
			return sortArrayL5;
	}
	//methods for each next button 
	@FXML
	private Button btnLevel5Next1, btnLevel5Next2, btnLevel5Next3, btnLevel5Next4, btnLevel5Next5;
	public void initialMarksInputL5(ActionEvent event) throws Exception {
		if(validationL5()){
		btnLevel5Next1.setVisible(false);
		btnLevel5Next2.setVisible(true);
		markGetterL5();
		avgSetterL5(1);
		passFailSetterL5();
		Level5ListPrint();
		}else{
			alertBox();
		}
	}
	public void secondMarksInputL5(ActionEvent event) throws Exception {
		if (passModsL5 == 6) {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Level6.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 763, 611);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel5Next2.getScene().getWindow();
		    stage.close();
		} else {
			if(validationL5()){
			atmptMarkGetterL5(2);
			avgSetterL5(2);
			passFailSetterL5();
			Level5ListPrint();
			btnLevel5Next2.setVisible(false);
			btnLevel5Next3.setVisible(true);
			}else{
				alertBox();
			}
		}
	}
	public void thirdMarksInputL5(ActionEvent event) throws Exception {
		if ( passModsL5 == 6) {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Level6.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 763, 611);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel5Next3.getScene().getWindow();
		    stage.close();
		} else {
			if(validationL5()){
			atmptMarkGetterL5(3);
			avgSetterL5(3);
			passFailSetterL5();
			Level5ListPrint();
			btnLevel5Next3.setVisible(false);
			btnLevel5Next4.setVisible(true);
			}else{
				alertBox();
			}
		}
	}
	public void fourthMarksInputL5(ActionEvent event) throws Exception {
		if ( passModsL5 == 6) {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Level6.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 763, 611);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel5Next4.getScene().getWindow();
		    stage.close();
		} else {
			if(validationL5()){
			atmptMarkGetterL5(4);
			avgSetterL5(4);
			passFailSetterL5();
			Level5ListPrint();
			if (passModsL5 == 6) {// check
				btnLevel5Next4.setVisible(false);
				btnLevel5Next5.setVisible(true);
			} else {
				btnLevel5Next4.setVisible(false);
			}
			}else{
				alertBox();
			}
		}
	}
	public void Level6Approve(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/application/Level6.fxml"));
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root, 763, 611);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) btnLevel5Next5.getScene().getWindow();
	    stage.close();
	}
	@FXML
	private Button btnLevel5Exit;
	public void exitAction(ActionEvent event) throws Exception {
		Platform.exit();
	}
}
