package tpGUI.IU;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import tpGUI.Control.AdminMenuControl;
//import tpGUI.Control.ClientMenuControl;

//import tpGUI.Control.AdminPasseControl;
import tpGUI.Control.PublierBienClientControl;
import tpGUI.Control.PublierBienAdminControl;
import tpGUI.Noyau.Admin;

public class Menu extends Stage 
{		
	Admin ad ;
	
	public Admin getAd() {
		return ad;
	}

	public void setAd(Admin ad) {
		this.ad = ad;
	}

	public void ClientMenu (ActionEvent event) throws IOException
	{     
		FXMLLoader loader = new FXMLLoader(); 
		loader.setLocation(getClass().getResource("pages\\ClientPage\\publierBienClient.fxml"));  
		Parent root = loader.load();           
		PublierBienClientControl controller = loader.getController();
		
		
		this.setTitle("Menu Client");      
		this.setScene(new Scene(root));
		controller.setView(this);
	}

	public void AdminMenu (ActionEvent event ) throws IOException
	{     
		FXMLLoader loader = new FXMLLoader(); 
		loader.setLocation(getClass().getResource("pages\\AdminPage\\publierBienAdmin.fxml"));  
		Parent root = loader.load();           
		PublierBienAdminControl controller = loader.getController();
		controller.setAd(ad);
		
		this.setTitle("Menu Administrateur");      
		this.setScene(new Scene(root));
		controller.setView(this);
	}
	
	
}
