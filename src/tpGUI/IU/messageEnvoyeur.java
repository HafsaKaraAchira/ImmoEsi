package tpGUI.IU;

import java.io.IOException;

//import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tpGUI.Control.AdminPasseControl;
import tpGUI.Control.EnvoieMessageControl;

public class messageEnvoyeur extends Stage 
{
	
	public messageEnvoyeur () throws IOException
	{
		FXMLLoader loader = new FXMLLoader(); 
		loader.setLocation(getClass().getResource("pages/envoieMessage.fxml"));  
		Parent root = loader.load();           
		//EnvoieMessageControl controller = loader.getController();
		//controller.setSelectedBien(selectedBien);;
		
		this.setTitle("Envoyer Message");      
		this.setScene(new Scene(root));
	}

}
