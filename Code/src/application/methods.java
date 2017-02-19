package application;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class methods extends Login {
//Module name setter and getter 
	private String name;
	public void setModName(String name) {
		this.name = name;
	}
	public String getModName() {
		return name;
	}
//module average setter and getter
	private double average;
	public void setAverage(double average) {
		this.average = average;
	}
	public double getAverage() {
		return average;
	}
//module pass/fail status getter and setter
	private boolean pass;
	public void setPass(boolean value) {
		this.pass = value;
	}
	public boolean getPass() {
		return pass;
	}
//module condone pending status setter and getter
	private boolean condonePendingStatus = false;
	public void setCondonePendingStatus(boolean value) {
		this.condonePendingStatus = value;
	}
	public boolean getCondonePendingStatus() {
		return condonePendingStatus;
	}
//module condone pass/fail status setter and getter 
	private boolean condonedPassed = false;
	public void setCondonedPassed(boolean value) {
		this.condonedPassed = value;
	}
	public boolean getCondonedPassed() {
		return condonedPassed;
	}
//module 
//	private boolean trailModuleStatus;
//	public void setTrailModuleStatus(boolean value) {
//		this.trailModuleStatus = value;
//	}
//	public boolean getTrailModuleStatus() {
//		return trailModuleStatus;
//	}
//module attempt setter and getter
	private int attempt = 1;
	public void setAttempt(boolean status) {
		this.attempt = attempt + 1;
	}
	public int getAttempt() {
		return attempt;
	}
//input validation method	
	public boolean inputNumbValidation(TextField text){
		boolean status=false;
		    if (!(text.getText() == null )) {
		        try {
		            if ( Double.parseDouble(text.getText())>=0 && Double.parseDouble(text.getText())<=100){
		            	status=true;
		            	}else{}
		        } catch (NumberFormatException e) {}
		    }else{}
		    return status;
	}
//alert box 	
	public void alertBox(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText("Please enter valid mark/s");
		alert.showAndWait();
	}
}
