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

public class Level6Controller extends Level5Controller {

	@FXML// defining textFields of exam marks in FXML
	private TextField txtMark0L6, txtMark1L6, txtMark2L6, txtMark3L6, txtMark4L6, txtMark5L6, txtMark6L6, txtMark7L6, txtMark8L6;
	// creating a Level6Controller type array
	public static Level6Controller[] arrayL6 = new Level6Controller[5];
	// average of the level 6
	double avgL6;
	// creating an array to store marks of exams
	double[] marksL6 = new double[9];
	// creating an array to store averages of each module in level5
	double[] avgModL6 = new double[5];
	//validating level 6 input marks
	public boolean validationL6(){
		boolean status =true;
		if(inputNumbValidation(txtMark0L6)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark1L6)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark2L6)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark3L6)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark4L6)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark5L6)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark6L6)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark7L6)){
		}else{
			status=false;
		}
		if(inputNumbValidation(txtMark8L6)){
		}else{
			status=false;
		}
		
		return status;
		
	}

	// initial attempt mark getting method
	public void markGetterL6() {

		marksL6[0] = Double.parseDouble(txtMark0L6.getText());
		marksL6[1] = Double.parseDouble(txtMark1L6.getText());
		marksL6[2] = Double.parseDouble(txtMark2L6.getText());
		marksL6[3] = Double.parseDouble(txtMark3L6.getText());
		marksL6[4] = Double.parseDouble(txtMark4L6.getText());
		marksL6[5] = Double.parseDouble(txtMark5L6.getText());
		marksL6[6] = Double.parseDouble(txtMark6L6.getText());
		marksL6[7] = Double.parseDouble(txtMark7L6.getText());
		marksL6[8] = Double.parseDouble(txtMark8L6.getText());
		
		avgModL6[0] = marksL6[0];
		avgModL6[1] = (marksL6[1] + marksL6[2]) / 2;
		avgModL6[2] = (marksL6[3]+ marksL6[4])/2;
		avgModL6[3] = (marksL6[5] + marksL6[6]) / 2;
		avgModL6[4] = (marksL6[7] + marksL6[8]) / 2;

		
		avgL6=(avgModL6[0]+avgModL6[1]+avgModL6[2]+avgModL6[3]+avgModL6[4])/5;

		// creating a Level6Controller type object and assigning average to it
		// and storing that object in Level6Controller type array
		for (int a = 0; a < 5; a++) {
			Level6Controller moduleL6 = new Level6Controller();
			moduleL6.setAverage(avgModL6[a]);
			arrayL6[a] = moduleL6;
		}
	}
	// average calculating method for 2,3,4 attempts
	public void avgSetterL6(int attempt) {
		avgModL6[0] = marksL6[0];
		avgModL6[1] = (marksL6[1] + marksL6[2]) / 2;
		avgModL6[2] = (marksL6[3]+ marksL6[4])/2;
		avgModL6[3] = (marksL6[5] + marksL6[6]) / 2;
		avgModL6[4] = (marksL6[7] + marksL6[8]) / 2;

		avgL6=(avgModL6[0]+avgModL6[1]+avgModL6[2]+avgModL6[3]+avgModL6[4])/5;

		for (int a = 0; a < 5; a++) {
			arrayL6[a].setAverage(avgModL6[a]);
		}
	}
	@FXML // defining labels of each module status in FXML
	private Label lblL6Mod1Status, lblL6Mod2Status, lblL6Mod3Status, lblL6Mod4Status, lblL6Mod5Status;

	@FXML // defining labels of each module status in FXML
	private Label lblL6Mod1Atmpt, lblL6Mod2Atmpt, lblL6Mod3Atmpt, lblL6Mod4Atmpt, lblL6Mod5Atmpt;
	
	int failModsL6 = 0;// total number of failed modules in level 6
	int passModsL6 = 0;// total number of passed modules in level 6
	int creditsL6 = 0;// total number of credits level 6
	//pass or fail setter for exam marks in all attempts in level6
	public void passFailSetterL6() {
		for (int j = 0; j < 5; j++) {
			if (arrayL6[j].getPass() == false && arrayL6[j].getAverage() >= 40) {
				arrayL6[j].setPass(true);
				passModsL6 += 1;
				creditsL6 += 20;
				if(j==0){//adding another 20 credits to double credit module
					creditsL6 += 20;
				}else{}
			} else if(arrayL6[j].getPass() == false && arrayL6[j].getAverage() < 40){
				failModsL6++;
				arrayL6[j].setPass(false);
				arrayL6[j].setAttempt(true);
			}else{}
		}
	}
	//Level 6 mark getter for attempts 2,3,4
	public void atmptMarkGetterL6(int atmptNum) {
		if (arrayL6[0].getAttempt() == atmptNum) {
			marksL6[0] = Double.parseDouble(txtMark0L6.getText());
		} else {}
		if (arrayL6[1].getAttempt() == atmptNum) {
			marksL6[1] = Double.parseDouble(txtMark1L6.getText());
			marksL6[2] = Double.parseDouble(txtMark2L6.getText());
		} else {}
		if (arrayL6[2].getAttempt() == atmptNum) {
			marksL6[3] = Double.parseDouble(txtMark3L6.getText());
			marksL6[4] = Double.parseDouble(txtMark4L6.getText());
		} else {}
		if (arrayL6[3].getAttempt() == atmptNum) {
			marksL6[5] = Double.parseDouble(txtMark5L6.getText());
			marksL6[6] = Double.parseDouble(txtMark6L6.getText());
		} else {}
		if (arrayL6[4].getAttempt() == atmptNum) {
			marksL6[7] = Double.parseDouble(txtMark7L6.getText());
			marksL6[8] = Double.parseDouble(txtMark8L6.getText());
		} else {}
	}
	@FXML
	private Label lblL6Status,lblL6Credits,lblL6Avg,lblL7Eligible,lblBscNonHonsEligible,lblBscNonHonsClass;

	@FXML
	private Label lblMsgL6, lblExclusionL6;

	boolean exclusionL6 = false;
	boolean eligibleL7 = false;
	boolean nonHons=false;
	//method to display results of level 6
	public void Level6ListPrint() {
		//checking number of failed modules in level6
		lblMsgL6.setText("");
		if (passModsL6 == 4 || passModsL6 == 3 || creditsL6==60) {
			lblMsgL6.setText("Please Enter Exam Mark/s for Failed Module/s");
		} else if (passModsL6 == 0 || passModsL6 == 1 || passModsL6 == 2) {
			exclusionL6 = true;
			lblExclusionL6.setText("Student has been EXCLUDED");
			lblExclusionL6.setStyle("-fx-text-fill:red;");
			btnLevel6Next2.setVisible(false);
		} else {}
		//checking for modules which are failed in all four attempts and setting exclusion status
		for(int i=0;i<5;i++){
			if(arrayL6[i].getAttempt()==5 && exclusionL6==false){
				exclusionL6=true;
				lblExclusionL6.setText("Student has been EXCLUDED");
				lblExclusionL6.setStyle("-fx-text-fill:red;");
				lblMsgL6.setText("");
			}else if(exclusionL6==false){
				lblExclusionL6.setText("NO");
			}
		}
		int classIndicatorL6=0;
		for(int i=0;i<5;i++){
			if(arrayL6[i].getAttempt()==1){
				classIndicatorL6++;
			}else{}
		}
		//checking for non honours eligibility and its class
		if (creditsL6 >= 60 && creditsL6< 120 && avgL6>=70 && classIndicatorL6==5) {
			lblBscNonHonsEligible.setText("Eligible");
			lblBscNonHonsClass.setText("Distinction");
			eligibleL7 = true;
		} else if(creditsL6 >= 60 && creditsL6< 120 && avgL6>=60 && classIndicatorL6==5){
			lblBscNonHonsEligible.setText("Eligible");
			lblBscNonHonsClass.setText("Merit");
			eligibleL7 = false;
		}else if(creditsL6 >= 60 && creditsL6< 120){
			lblBscNonHonsEligible.setText("Eligible");
			lblBscNonHonsClass.setText("-");
		}else{}
		//level 7 eligibility
		if (creditsL6 == 120) {
			lblL7Eligible.setText("Eligible");
			lblL6Status.setText("Pass");
		} else {
			lblL7Eligible.setText("Not Eligible");
			lblL6Status.setText("Fail");
		}

		lblL6Credits.setText(String.valueOf(creditsL6));
		lblL6Avg.setText(String.valueOf(avgL6));
		//displaying attempt number of each module
		if (exclusionL6 == false) {
			lblL6Mod1Atmpt.setText(String.valueOf(arrayL6[0].getAttempt()));
			lblL6Mod2Atmpt.setText(String.valueOf(arrayL6[1].getAttempt()));
			lblL6Mod3Atmpt.setText(String.valueOf(arrayL6[2].getAttempt()));
			lblL6Mod4Atmpt.setText(String.valueOf(arrayL6[3].getAttempt()));
			lblL6Mod5Atmpt.setText(String.valueOf(arrayL6[4].getAttempt()));
		} else {}
		//displaying pass or fail status of modules in level 6
			if (arrayL6[0].getPass() == false) {
			lblL6Mod1Status.setText("Fail");
			lblL6Mod1Status.setStyle("-fx-text-fill:red;");
			
		} else {
			lblL6Mod1Status.setText("Pass");
			lblL6Mod1Status.setStyle("-fx-text-fill:green;");
			txtMark0L6.setEditable(false);
		}
		if (arrayL6[1].getPass() == false) {
			lblL6Mod2Status.setText("Fail");
			lblL6Mod2Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL6Mod2Status.setText("Pass");
			lblL6Mod2Status.setStyle("-fx-text-fill:green;");
			txtMark1L6.setEditable(false);
			txtMark2L6.setEditable(false);
		}
		if (arrayL6[2].getPass() == false) {
			lblL6Mod3Status.setText("Fail");
			lblL6Mod3Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL6Mod3Status.setText("Pass");
			lblL6Mod3Status.setStyle("-fx-text-fill:green;");
			txtMark3L6.setEditable(false);
			txtMark4L6.setEditable(false);
		}
		if (arrayL6[3].getPass() == false) {
			lblL6Mod4Status.setText("Fail");
			lblL6Mod4Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL6Mod4Status.setText("Pass");
			lblL6Mod4Status.setStyle("-fx-text-fill:green;");
			txtMark5L6.setEditable(false);
			txtMark6L6.setEditable(false);
		}
		if (arrayL6[4].getPass() == false) {
			lblL6Mod5Status.setText("Fail");
			lblL6Mod5Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL6Mod5Status.setText("Pass");
			lblL6Mod5Status.setStyle("-fx-text-fill:green;");
			txtMark7L6.setEditable(false);
			txtMark8L6.setEditable(false);
		}
	}
	//method which returns an array with averages of modules in level6 for award classification	
	public static double []sortArrayL6=new double[6];
	public double[] honsAwardStep02(){
		for(int i=0;i<5;i++){
			sortArrayL6[i]=arrayL6[i].getAverage();
		}
		sortArrayL6[5]=arrayL6[0].getAverage();
		return sortArrayL6;
}
	//methods for each next button
	@FXML
	private Button btnLevel6Next1, btnLevel6Next2, btnLevel6Next3, btnLevel6Next4,btnLevel6Next5;
	public void initialMarksInputL6(ActionEvent event) throws Exception {
		if(validationL6()){
		btnLevel6Next1.setVisible(false);
		btnLevel6Next2.setVisible(true);
		markGetterL6();
		avgSetterL6(1);
		passFailSetterL6();
		Level6ListPrint();
		}else{
			alertBox();
		}
	}
	public void secondMarksInputL6(ActionEvent event) throws Exception {
		if (passModsL6 == 5) {
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/AwardsCalculation.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 473, 356);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel6Next2.getScene().getWindow();
		    stage.close();
		} else {
			if(validationL6()){
			atmptMarkGetterL6(2);
			avgSetterL6(2);
			passFailSetterL6();
			Level6ListPrint();
			btnLevel6Next2.setVisible(false);
			btnLevel6Next3.setVisible(true);
			}else{
				alertBox();
			}
		}
	}
	public void thirdMarksInputL6(ActionEvent event) throws Exception {
		if (passModsL6 == 5) {
			Parent root = FXMLLoader.load(getClass().getResource("/application/AwardsCalculation.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 473, 356);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel6Next3.getScene().getWindow();
		    stage.close();
		} else {
			if(validationL6()){
			atmptMarkGetterL6(3);
			avgSetterL6(3);
			passFailSetterL6();
			Level6ListPrint();
			btnLevel6Next3.setVisible(false);
			btnLevel6Next4.setVisible(true);
			}else{
				alertBox();
			}
		}
	}
	public void fourthMarksInputL6(ActionEvent event) throws Exception {
		if (passModsL6 == 5) {
			Parent root = FXMLLoader.load(getClass().getResource("/application/AwardsCalculation.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 473, 356);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel6Next4.getScene().getWindow();
		    stage.close();
		} else {
			if(validationL6()){
			atmptMarkGetterL6(4);
			avgSetterL6(4);
			passFailSetterL6();
			Level6ListPrint();
			if(passModsL6==6){
				btnLevel6Next4.setVisible(false);
				btnLevel6Next5.setVisible(true);
				}else{
					btnLevel6Next4.setVisible(false);
				}
			}else{
				alertBox();
			}
		}
	}
	public void Level7Approve(ActionEvent event) throws Exception {
		
			Parent root = FXMLLoader.load(getClass().getResource("/application/AwardsCalculation.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 473, 356);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel6Next5.getScene().getWindow();
		    stage.close();
	}
	@FXML
	private Button btnLevel6Exit;
	public void exitAction(ActionEvent event)throws Exception{
		Platform.exit();
	}
}
