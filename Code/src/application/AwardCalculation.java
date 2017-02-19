package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AwardCalculation extends Level6Controller {
	@FXML
	private Label lbl1stClass,lbl2ndUpClass,lbl2ndLowClass,lbl3rdClass;
	//method for classification of Bsc.Eng honours 
	public void honsAwardStep03(double[] sortArrayL5,double[] sortArrayL6){
		double indScore=0;
			double totalL5=0;
			double totalL6=0;
			for(int i=0;i<6;i++){
				totalL5+=sortArrayL5[i];
			}
			for(int i=0;i<6;i++){
				totalL6+=sortArrayL6[i];
			}
			//sorting the averages of modules in level 5 
			for(int i=0;i<(sortArrayL5.length-1);i++){
				for(int j=0;j<((sortArrayL5.length-1)-i);j++){
					if(sortArrayL5[j]>sortArrayL5[j+1]){
						double temp=sortArrayL5[j];
						sortArrayL5[j]=sortArrayL5[j+1];
						sortArrayL5[j+1]=temp;
					}
				}
			}
			//sorting the averages of modules in level 6
			for(int i=0;i<(sortArrayL6.length-1);i++){
				for(int j=0;j<((sortArrayL6.length-1)-i);j++){
					if(sortArrayL6[j]>sortArrayL6[j+1]){
						double temp=sortArrayL6[j];
						sortArrayL6[j]=sortArrayL6[j+1];
						sortArrayL6[j+1]=temp;
					}
				}
			}
			//searching the worst performing module in level 5 and 6
			double portionL5=0;
			double portionL6=0;
			if(sortArrayL5[0]>sortArrayL6[0]){
				totalL6-=sortArrayL6[0];
				portionL5=totalL5/600.0;
				portionL6=totalL6/500.0;
			}else if(sortArrayL5[0]<sortArrayL6[0]){
				totalL5-=sortArrayL5[0];
				portionL5=totalL5/500.0;
				portionL6=totalL6/600.0;
			}else if(sortArrayL5[0]==sortArrayL6[0]){
				totalL6-=sortArrayL6[0];
				portionL5=totalL5/600.0;
				portionL6=totalL6/500.0;
			}else{}
		//calculating indicator score
		indScore=((portionL5*(1.0/3))+(portionL6*(2.0/3)))*100;
		if(indScore>=70){
			lbl1stClass.setText("ELIGIBLE");
		}else if(indScore>=60){
			lbl2ndUpClass.setText("ELIGIBLE");
		}else if(indScore>=50){
			lbl2ndLowClass.setText("ELIGIBLe");
		}else if(indScore>=40){
			lbl3rdClass.setText("ELIGIBLE");
		}else{}
	}
	//getting arrays of module averages from level 5 and 6 and passing them 
	//to method for classification of Bsc.Eng honours  
	public void showAwards(ActionEvent event) throws Exception {
		honsAwardStep03(honsAwardStep01(),honsAwardStep02());
	}
	public void exitAction(ActionEvent event) throws Exception {
		Platform.exit();
	}
}
