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

public class Level4Controller extends methods {
	@FXML // defining textFields of exam marks in FXML
	private TextField markTxt0, markTxt1, markTxt2, markTxt3, markTxt4, markTxt5, markTxt6, markTxt7, markTxt8,
			markTxt9, markTxt10, markTxt11, markTxt12, markTxt13;
	// creating a Level4Controller type array
	Level4Controller[] arrayL4 = new Level4Controller[6];
	// average of the level 4
	double avgL4;
	// creating an array to store marks of exams
	double[] marksL4 = new double[14];
	// creating an array to store averages of each module in level4
	double[] avgModL4 = new double[6];

	//validating level 4 input marks	
	public boolean validationL4(){
		boolean status =true;
		if(inputNumbValidation(markTxt0)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt1)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt2)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt3)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt4)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt5)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt6)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt7)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt8)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt9)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt10)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt11)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt12)){
		}else{
			status=false;
		}
		if(inputNumbValidation(markTxt13)){
		}else{
			status=false;
		}
		return status;
	}
	
	// mark getting method
	public void markGetterL4() {
		marksL4[0] = Double.parseDouble(markTxt0.getText());
		marksL4[1] = Double.parseDouble(markTxt1.getText());
		marksL4[2] = Double.parseDouble(markTxt2.getText());
		marksL4[3] = Double.parseDouble(markTxt3.getText());
		marksL4[4] = Double.parseDouble(markTxt4.getText());
		marksL4[5] = Double.parseDouble(markTxt5.getText());
		marksL4[6] = Double.parseDouble(markTxt6.getText());
		marksL4[7] = Double.parseDouble(markTxt7.getText());
		marksL4[8] = Double.parseDouble(markTxt8.getText());
		marksL4[9] = Double.parseDouble(markTxt9.getText());
		marksL4[10] = Double.parseDouble(markTxt10.getText());
		marksL4[11] = Double.parseDouble(markTxt11.getText());
		marksL4[12] = Double.parseDouble(markTxt12.getText());
		marksL4[13] = Double.parseDouble(markTxt13.getText());
		
		avgModL4[0] = (marksL4[0] + marksL4[1] + marksL4[2]) / 3;
		avgModL4[1] = (marksL4[3] + marksL4[4]) / 2;
		avgModL4[2] = (marksL4[5] + marksL4[6]) / 2;
		avgModL4[3] = (marksL4[7] + marksL4[8]) / 2;
		avgModL4[4] = (marksL4[9] + marksL4[10]) / 2;
		avgModL4[5] = (marksL4[11] + marksL4[12] + marksL4[13]) / 3;
	
		avgL4 = (avgModL4[0] + avgModL4[1] + avgModL4[2] + avgModL4[3] + avgModL4[4] + avgModL4[5]) / 6;
		// creating a Level4Controller type object and assigning average to it
		// and storing that object in Level4Controller type array
		for (int a = 0; a < 6; a++) {
			Level4Controller moduleL4 = new Level4Controller();
			moduleL4.setAverage(avgModL4[a]);
			arrayL4[a] = moduleL4;
		}

	}
	// average calculating method
	public void avgSetterL4(int attempt) {
		avgModL4[0] = (marksL4[0] + marksL4[1] + marksL4[2]) / 3;
		avgModL4[1] = (marksL4[3] + marksL4[4]) / 2;
		avgModL4[2] = (marksL4[5] + marksL4[6]) / 2;
		avgModL4[3] = (marksL4[7] + marksL4[8]) / 2;
		avgModL4[4] = (marksL4[9] + marksL4[10]) / 2;
		avgModL4[5] = (marksL4[11] + marksL4[12] + marksL4[13]) / 3;
	
		avgL4 = (avgModL4[0] + avgModL4[1] + avgModL4[2] + avgModL4[3] + avgModL4[4] + avgModL4[5]) / 6;
		//storing new averages(attempt 2,3,4 marks) into Level4Controller type array
		for (int a = 0; a < 6; a++) {
			arrayL4[a].setAverage(avgModL4[a]);
		}
	}

	@FXML  // defining labels of each module status in FXML
	private Label lblL4Mod1Status, lblL4Mod2Status, lblL4Mod3Status, lblL4Mod4Status, lblL4Mod5Status, lblL4Mod6Status;

	@FXML //defining labels of each module condone status in FXML
	private Label lblConSts1, lblConSts2, lblConSts3, lblConSts4, lblConSts5, lblConSts6;

	@FXML//defining labels of each module attempt number in FXML
	private Label lblL4Mod1Atmpt, lblL4Mod2Atmpt, lblL4Mod3Atmpt, lblL4Mod4Atmpt, lblL4Mod5Atmpt, lblL4Mod6Atmpt;

	
	int totalCondonedMods = 0;//total number of already condoned modules
	int condonePendingdMods = 0;//total number of condone pending modules
	int failModsL4 = 0; //total number of failed modules in level 4
	int passModsL4 = 0;//total number of passed modules in level 4
	int creditsL4 = 0;//total number of credits level 4
	int condonedCredits = 0;//total number of condoned credits

	//setting pass or fail a module and whether it eligible to be condoned 
	public void attemptPassFailSetterL4() {
		for (int j = 0; j < 6; j++) {
			if (arrayL4[j].getPass()==false && arrayL4[j].getAverage() >= 40) {
				arrayL4[j].setPass(true);
				passModsL4 += 1;
				creditsL4 += 20;
			}  else if(arrayL4[j].getPass()==false && arrayL4[j].getAverage() < 40){
				arrayL4[j].setPass(false);
				arrayL4[j].setAttempt(true);
			}else{}
		}
	}
//pass or fail setter and condone setter for initial attempt marks
	public void condoneSetterL4(){
		for (int j = 0; j < 6; j++) {
			if (arrayL4[j].getPass()==false && arrayL4[j].getAverage() >= 40 ) {
				arrayL4[j].setPass(true);
				arrayL4[j].setCondonedPassed(false);
				arrayL4[j].setCondonePendingStatus(false);
				passModsL4 += 1;
				creditsL4 += 20;
			} else if(arrayL4[j].getPass()==false && arrayL4[j].getAverage() >= 30){
				condonePendingdMods += 1;
				arrayL4[j].setPass(false);
				arrayL4[j].setCondonedPassed(false);
				arrayL4[j].setCondonePendingStatus(true);
			} else if(arrayL4[j].getCondonedPassed()== false){
				failModsL4++;
				arrayL4[j].setPass(false);
				arrayL4[j].setCondonedPassed(false);
				arrayL4[j].setCondonePendingStatus(false);
			}else{}
		}
		if (totalCondonedMods < 2 && condonePendingdMods == 1) {
			for (int i = 0; i < 6; i++) {
				if (arrayL4[i].getCondonePendingStatus() == true) {
					creditsL4 += 20;
					condonedCredits += 20;
					totalCondonedMods += 1;
					passModsL4 += 1;
					arrayL4[i].setPass(true);
					if(arrayL4[i].getAverage()>=40){
						arrayL4[i].setAverage(40);
					}else{}
					arrayL4[i].setCondonePendingStatus(false);
					arrayL4[i].setCondonedPassed(true);
					condonePendingdMods = 0;
				} else {}
			}
		}
		if (totalCondonedMods < 2 && condonePendingdMods >= 2) {
			creditsL4 += 40;
			condonedCredits += 40;
			totalCondonedMods += 2;
			passModsL4 += 2;
			condonePendingdMods = 0;
			//finding the largest averages among condone pending modules
			double large1 = 0, large2 = 0;
			int indicator1 = 0, indicator2 = 0;
			for (int c = 0; c < 6; c++) {
				if (arrayL4[c].getCondonePendingStatus() == true && arrayL4[c].getAverage() > large1) {
					large1 = arrayL4[c].getAverage();
					indicator1 = c;
				} else {}
			}
			for (int m = 0; m < 6; m++) {
				if (arrayL4[m].getCondonePendingStatus() == true && arrayL4[m].getAverage() > large2 && m != indicator1) {
					large2 = arrayL4[m].getAverage();
					indicator2 = m;
				} else {}
			}
			if(arrayL4[indicator1].getAverage()>40){
				arrayL4[indicator1].setAverage(40);
			}else{}
			arrayL4[indicator1].setCondonedPassed(true);
			arrayL4[indicator1].setCondonePendingStatus(false);
			arrayL4[indicator1].setPass(true);
			if(arrayL4[indicator2].getAverage()>=40){
				arrayL4[indicator2].setAverage(40);
			}else{}
			arrayL4[indicator2].setCondonedPassed(true);
			arrayL4[indicator2].setCondonePendingStatus(false);
			arrayL4[indicator2].setPass(true);
		} else {}
		for (int d = 0; d < 6; d++) {
			if (arrayL4[d].getPass() == false) {
				arrayL4[d].setCondonePendingStatus(false);
				arrayL4[d].setCondonedPassed(false);
				arrayL4[d].setAttempt(true);
			} else {}
		}
	}
	//Level 4 mark getter for attempts 2,3,4
	public void atmptMarkGetterL4(int atmptNum){
		if(arrayL4[0].getAttempt()==atmptNum){
			marksL4[0] = Double.parseDouble(markTxt0.getText());
			marksL4[1] = Double.parseDouble(markTxt1.getText());
			marksL4[2] = Double.parseDouble(markTxt2.getText());
		}else{}
		if(arrayL4[1].getAttempt()==atmptNum){
			marksL4[3] = Double.parseDouble(markTxt3.getText());
			marksL4[4] = Double.parseDouble(markTxt4.getText());
		}else{}
		if(arrayL4[2].getAttempt()==atmptNum){
			marksL4[5] = Double.parseDouble(markTxt5.getText());
			marksL4[6] = Double.parseDouble(markTxt6.getText());
		}else{}
		if(arrayL4[3].getAttempt()==atmptNum){
			marksL4[7] = Double.parseDouble(markTxt7.getText());
			marksL4[8] = Double.parseDouble(markTxt8.getText());
		}else{}
		if(arrayL4[4].getAttempt()==atmptNum){
			marksL4[9] = Double.parseDouble(markTxt9.getText());
			marksL4[10] = Double.parseDouble(markTxt10.getText());
		}else{}
		if(arrayL4[5].getAttempt()==atmptNum){
			marksL4[11] = Double.parseDouble(markTxt11.getText());
			marksL4[12] = Double.parseDouble(markTxt12.getText());
			marksL4[13] = Double.parseDouble(markTxt13.getText());
		}else{}
	}
	
	@FXML
	private Label lblL4Status,lblL4Credits,lblCondCredits,lblL4Avg,lblL5Eligible,lblCertHEEligible,lblCertHEClass;
	@FXML
	private Label lblMsgL4,lblExclusionL4;
	boolean exclusionL4 =false;
	boolean certHEEligible=false;
	boolean eligibleL5=false;
	
	//method to display results of level 4
	public void level4ListPrint() {
		//checking number of failed modules in level4
		lblMsgL4.setText("");
		if(passModsL4==3 || passModsL4==4 || passModsL4==5){
			lblMsgL4.setText("Please Enter Exam Mark/s for Failed Module/s");
		}else if(passModsL4==0 || passModsL4==1 || passModsL4==2 ){
			exclusionL4=true;
			lblExclusionL4.setText("Student has been EXCLUDED");
			lblExclusionL4.setStyle("-fx-text-fill:red;");
			btnLevel4Next2.setVisible(false);
		}else{}
		//checking for modules which are failed in all four attempts and setting exclusion status
		for(int i=0;i<6;i++){
			if(arrayL4[i].getAttempt()==5 && exclusionL4==false){
				exclusionL4=true;
				lblExclusionL4.setText("Student has been EXCLUDED");
				lblExclusionL4.setStyle("-fx-text-fill:red;");
				lblMsgL4.setText("");
			}else if(exclusionL4==false){
				lblExclusionL4.setText("NO");
			}else{}
		}
		//level 5 eligibility
		if(creditsL4>=100){
			lblL5Eligible.setText("Eligible");
			eligibleL5=true;
		}else{
			lblL5Eligible.setText("Not Eligible");
			eligibleL5=false;
		}
		//CertHE eligibility
		if(creditsL4==120){
			lblCertHEEligible.setText("Eligible");
			certHEEligible=true;
			lblL4Status.setText("Pass");
		}else{
			lblCertHEEligible.setText("Not Eligible");
			certHEEligible=false;
			lblL4Status.setText("Fail");
		}
		int classIndicatorL4=0;
		for(int i=0;i<6;i++){
			if(arrayL4[i].getAttempt()==1){
				classIndicatorL4++;
			}else{}
		}
		//checking eligibility for classes in CertHE
		if(avgL4>=70 && certHEEligible==true && classIndicatorL4==6){
			lblCertHEClass.setText("Distinction");
		}else if(avgL4>=60 && certHEEligible==true && classIndicatorL4==6){
			lblCertHEClass.setText("Merit");
		}else{
			lblCertHEClass.setText("No");
		}
		
		lblL4Credits.setText(String.valueOf(creditsL4));
		lblCondCredits.setText(String.valueOf(condonedCredits));
		lblL4Avg.setText(String.valueOf(avgL4));
		//displaying attempt number of each module
		if(exclusionL4==false){
		lblL4Mod1Atmpt.setText(String.valueOf(arrayL4[0].getAttempt()));
		lblL4Mod2Atmpt.setText(String.valueOf(arrayL4[1].getAttempt()));
		lblL4Mod3Atmpt.setText(String.valueOf(arrayL4[2].getAttempt()));
		lblL4Mod4Atmpt.setText(String.valueOf(arrayL4[3].getAttempt()));
		lblL4Mod5Atmpt.setText(String.valueOf(arrayL4[4].getAttempt()));
		lblL4Mod6Atmpt.setText(String.valueOf(arrayL4[5].getAttempt()));
		}else{}
		//displaying pass or fail status of modules in level 4 
		if (arrayL4[0].getPass() == false) {
			lblL4Mod1Status.setText("Fail");
			lblL4Mod1Status.setStyle("-fx-text-fill:red;");	
		} else {
			lblL4Mod1Status.setText("Pass");
			lblL4Mod1Status.setStyle("-fx-text-fill:green;");
			markTxt0.setEditable(false);
			markTxt1.setEditable(false);
			markTxt2.setEditable(false);
		}
		if (arrayL4[1].getPass() == false) {
			lblL4Mod2Status.setText("Fail");
			lblL4Mod2Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL4Mod2Status.setText("Pass");
			lblL4Mod2Status.setStyle("-fx-text-fill:green;");
			markTxt3.setEditable(false);
			markTxt4.setEditable(false);
		}
		if (arrayL4[2].getPass() == false) {
			lblL4Mod3Status.setText("Fail");
			lblL4Mod3Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL4Mod3Status.setText("Pass");
			lblL4Mod3Status.setStyle("-fx-text-fill:green;");
			markTxt5.setEditable(false);
			markTxt6.setEditable(false);
		}
		if (arrayL4[3].getPass() == false) {
			lblL4Mod4Status.setText("Fail");
			lblL4Mod4Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL4Mod4Status.setText("Pass");
			lblL4Mod4Status.setStyle("-fx-text-fill:green;");
			markTxt7.setEditable(false);
			markTxt8.setEditable(false);
		}
		if (arrayL4[4].getPass() == false) {
			lblL4Mod5Status.setText("Fail");
			lblL4Mod5Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL4Mod5Status.setText("Pass");
			lblL4Mod5Status.setStyle("-fx-text-fill:green;");
			markTxt9.setEditable(false);
			markTxt10.setEditable(false);
		}
		if (arrayL4[5].getPass() == false) {
			lblL4Mod6Status.setText("Fail");
			lblL4Mod6Status.setStyle("-fx-text-fill:red;");
		} else {
			lblL4Mod6Status.setText("Pass");
			lblL4Mod6Status.setStyle("-fx-text-fill:green;");
			markTxt11.setEditable(false);
			markTxt12.setEditable(false);
			markTxt13.setEditable(false);
		}
		//displaying condone status of modules
		if (arrayL4[0].getCondonedPassed() == false) {
			lblConSts1.setText("No");
		} else {
			lblConSts1.setText("Yes");
		}
		if (arrayL4[1].getCondonedPassed() == false) {
			lblConSts2.setText("No");
		} else {
			lblConSts2.setText("Yes");
		}
		if (arrayL4[2].getCondonedPassed() == false) {
			lblConSts3.setText("No");
		} else {
			lblConSts3.setText("Yes");
		}
		if (arrayL4[3].getCondonedPassed() == false) {
			lblConSts4.setText("No");
		} else {
			lblConSts4.setText("Yes");
		}
		if (arrayL4[4].getCondonedPassed() == false) {
			lblConSts5.setText("No");
		} else {
			lblConSts5.setText("Yes");
		}
		if (arrayL4[5].getCondonedPassed() == false) {
			lblConSts6.setText("No");
		} else {
			lblConSts6.setText("Yes");
		}
	}
	//methods for each next button 
	@FXML
	private Button btnLevel4Next1,btnLevel4Next2,btnLevel4Next3,btnLevel4Next4,btnLevel4Next5;
	public void initialMarksInputL4(ActionEvent event) throws Exception {
		if(validationL4()){
		btnLevel4Next1.setVisible(false);
		btnLevel4Next2.setVisible(true);
		markGetterL4();
		avgSetterL4(1);
		condoneSetterL4();
		level4ListPrint();
		}else{
			alertBox();
		}
	}
	public void secondMarksInputL4(ActionEvent event)throws Exception{
		if(passModsL4==6){ 
			Parent root = FXMLLoader.load(getClass().getResource("/application/Level5.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 763,611);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel4Next2.getScene().getWindow();
		    stage.close();
		}else{
			if(validationL4()){
			atmptMarkGetterL4(2);
			avgSetterL4(2);
			attemptPassFailSetterL4();
			level4ListPrint();
			btnLevel4Next2.setVisible(false);
			btnLevel4Next3.setVisible(true);
			}else{
				alertBox();
			}
		}
	}
	public void thirdMarksInputL4(ActionEvent event)throws Exception{
		if(passModsL4==6){
			Parent root = FXMLLoader.load(getClass().getResource("/application/Level5.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 763,611);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel4Next3.getScene().getWindow();
		    stage.close();
		}else{
			if(validationL4()){
			atmptMarkGetterL4(3);
			avgSetterL4(3);
			attemptPassFailSetterL4();
			level4ListPrint();
			btnLevel4Next3.setVisible(false);
			btnLevel4Next4.setVisible(true);
			}else{
				alertBox();
			}
		}
	}
	public void fourthMarksInputL4(ActionEvent event)throws Exception{
		if(passModsL4==6){
			Parent root = FXMLLoader.load(getClass().getResource("/application/Level5.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 763,611);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel4Next4.getScene().getWindow();
		    stage.close();
		}else{
			if(validationL4()){
			atmptMarkGetterL4(4);
			avgSetterL4(4);
			attemptPassFailSetterL4();
			level4ListPrint();
			if(passModsL4==6){
			btnLevel4Next4.setVisible(false);
			btnLevel4Next5.setVisible(true);
			}else{
				btnLevel4Next4.setVisible(false);
			}
			}else{
				alertBox();
			}
		}
	}
	public void Level5Approve(ActionEvent event)throws Exception{
		
			Parent root = FXMLLoader.load(getClass().getResource("/application/Level5.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root, 763,611);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Stage stage = (Stage) btnLevel4Next5.getScene().getWindow();
		    stage.close();
	}

@FXML
private Button btnLevel4Exit;
	public void exitAction(ActionEvent event)throws Exception{
		Platform.exit();
	}
}
