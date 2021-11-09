package tpGUI.Control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
import tpGUI.IU.Menu;

public class PublierBienControl {
	
	public Menu view ;
	
	
	public void setView(Menu view) {
		this.view = view;
	}


	@FXML
	public BorderPane bp;
	@FXML
	public AnchorPane ap;
	@FXML
	public VBox vb;
	
	
	@FXML    public Label nbResultatLabel;
	

	public PublierBienControl() {}

}