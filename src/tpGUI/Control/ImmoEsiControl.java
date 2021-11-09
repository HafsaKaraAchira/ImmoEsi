package tpGUI.Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.stage.Stage;
//import tpGUI.IU.Main;
import tpGUI.IU.Menu;
import tpGUI.IU.AcceuilAdmin;
import javafx.application.*;
//import tpGUI.Noyau.*;

//import tpGUI.IU.* ;

public class ImmoEsiControl 
{

	//private Admin admin ;
	//private Main view ;
	
	//public Admin getAdmin() {		return admin;	}
	//public void setAdmin(Admin admin) {		this.admin = admin;	}
	//public Main getView() {		return view;	}
    //public void setView(Main main)     {		view = main ;	}
	
    @FXML
    private Button Admin;

    @FXML
    private Button Client;

    @FXML
    private Button Sortir;
    
    
    @FXML
    public void AdminPasse(ActionEvent event) ////le bouton vers le login de l'admin
    { 
    	
    	try 
		{         
    		AcceuilAdmin menuStage = new AcceuilAdmin() ;
			 menuStage.show();  	                
		 }
	     catch(Exception e) {	 e.printStackTrace();    } 
    	 
    }

    @FXML
    public void ClientMenu(ActionEvent event)  ////le bouton de client
    {
    	try 
		{         
    		 Menu menuStage = new Menu ();
    		 menuStage.ClientMenu(event) ;
			 menuStage.show();  	                
		}
	     catch(Exception e) 
	     { 	 e.printStackTrace();   }  
    	
    }

    @FXML
    void Sortir(ActionEvent event) 
    {
    	Platform.exit();
    }

}
