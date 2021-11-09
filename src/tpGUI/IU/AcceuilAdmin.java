package tpGUI.IU;

import java.io.IOException;

//import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tpGUI.Control.AdminPasseControl;

public class AcceuilAdmin extends Stage 
{
	
	public AcceuilAdmin () throws IOException
	{
		FXMLLoader loader = new FXMLLoader(); 
		loader.setLocation(getClass().getResource("pages/AdminPage/AdminPasse.fxml"));  
		Parent root = loader.load();           
		AdminPasseControl controller = loader.getController();
		controller.setView(this);
		
		this.setTitle("Mot de passe");      
		this.setScene(new Scene(root));
	}

}
