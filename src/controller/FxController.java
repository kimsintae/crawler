package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class FxController implements Initializable{
    @FXML
    private CheckBox checkBox1 ;
    @FXML
    private CheckBox checkBox2 ;
    @FXML
    private CheckBox checkBox3 ;


    private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();

    private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		System.out.println(numCheckBoxesSelected);
		
		    configureCheckBox(checkBox1);
	        configureCheckBox(checkBox2);
	        configureCheckBox(checkBox3);

	}
	
	  private void configureCheckBox(CheckBox checkBox) {

	        if (checkBox.isSelected()) {
	            selectedCheckBoxes.add(checkBox);
	        } else {
	            unselectedCheckBoxes.add(checkBox);
	        }

	        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
	            if (isNowSelected) {
	            	System.out.println("chk");
	                unselectedCheckBoxes.remove(checkBox);
	                selectedCheckBoxes.add(checkBox);
	            } else {
	            	System.out.println("unChk");
	                selectedCheckBoxes.remove(checkBox);
	                unselectedCheckBoxes.add(checkBox);
	            }

	        });

	    }
	
	
}
