package tpGUI.Control;

import java.util.Iterator;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import tpGUI.IU.Main;
//import tpGUI.Noyau.Bien;
import tpGUI.Noyau.*;

public class EnvoieMessageControl 
{
	
	Set<Admin> l = Main.getAgence().getAdmins().keySet() ;
	
	ObservableList<Admin> AdminsList = FXCollections.observableArrayList(l) ;
	
	Bien selectedBien ;
	
	public Bien getSelectedBien() {
		return selectedBien;
	}

	public void setSelectedBien(Bien selectedBien) {
		this.selectedBien = selectedBien;
	}

	//public EnvoieMessageControl(Bien selectedBien) {
		//this.selectedBien = selectedBien;
	//}
	
	@FXML
    private Button envoyerValidation;
	
	@FXML
    private TextArea messageArea;
    
    @FXML
    private ChoiceBox<Admin> AdminsMenu;

    @FXML public void initialize() 
    {
    	Iterator<Admin> it = AdminsList.iterator() ;
    	AdminsMenu.setValue(it.next());
    	AdminsMenu.setItems(AdminsList);
    	;
    }
    
    @FXML
    void envoyervalid(ActionEvent event) {
    	AdminsMenu.getValue().envoiMessage(messageArea.getText() , selectedBien ) ;
    }

	
		// TODO Auto-generated method stub
		
	
		
}
