package tpGUI.Control;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
//import javafx.scene.SubScene;
//import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
//import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
//import tpGUI.IU.Main;
import tpGUI.Noyau.Admin;
import tpGUI.Noyau.Bien;
import tpGUI.Noyau.exceptions_personnalisees.CritereVide;

//import tpGUI.Noyau.*;

public class RechercherControl {
	
	
	
	ObservableList<String> transactionTypeList = FXCollections.observableArrayList("Vente","Location","Echange","") ;
	ObservableList<String> bienTypeList = FXCollections.observableArrayList("Appartement","Maison","Terrain","") ; 
	
	 @FXML
	    private StackPane stP;

	    @FXML
	    private BorderPane bp2;

	    @FXML
	    private Label nbResultatLabel;

	    @FXML
	    private VBox vb1;

	    @FXML
	    private BorderPane bp1;
	
	@FXML    private ScrollPane sp;
	
	
	
	@FXML    private ChoiceBox<String> transactionTypeMenu;

    @FXML    private TextField wilayaTextField;
    
    @FXML    private TextField prixMinNumField;

    @FXML    private TextField prixMaxNumField;
    
    @FXML    private ChoiceBox<String> bienTypeMenu;
    
    @FXML    private TextField surfaceMinNumfield;

    @FXML    private TextField nbpiecesNumField;

    @FXML    private Button rechercherBouton;
    
    @FXML    private Label warning;
    
    @FXML
    void activerNbPieces(InputMethodEvent event) 
    {
    	if( !bienTypeMenu.getValue().equals("Terrain") ) nbpiecesNumField.setDisable(false);
    }

    @FXML   void digitinput(KeyEvent evt) 
    		{
    			if(!evt.getCode().isDigitKey()) {evt.consume();}
    		}
    
    @FXML public void initialize() 
    {
    	transactionTypeMenu.setValue("");
    	transactionTypeMenu.setItems(transactionTypeList);
    	
    	bienTypeMenu.setValue("");
    	bienTypeMenu.setItems(bienTypeList);
    }

    @FXML
    void rechercher(ActionEvent event) 
    {
    	ArrayList<String> critere = new ArrayList<String>();
    	critere.add( transactionTypeMenu.getValue() ) ;
    	critere.add(wilayaTextField.getText() ) ;
    	critere.add(prixMinNumField.getText()) ;
    	critere.add(prixMaxNumField.getText()) ;
    	critere.add(bienTypeMenu.getValue()) ;
    	critere.add(surfaceMinNumfield.getText()) ;
    	critere.add(nbpiecesNumField.getText()) ;
    	
    	try 
    	{
			ArrayList<Bien> condidats = Admin.rechercher(critere);
			if(condidats.isEmpty()) warning.setText("Aucun bien correspondant a cette recherche ! ") ;
			else	  
			{
				//ObservableList<Node> children = vb.getChildren();
				//children.remove(gd) ;
				bp1.setDisable(true);
				bp1.setVisible(false);
				
				bp2.setDisable(false);
				bp2.setVisible(true);
				
				Collections.sort(condidats) ;
		    	//int length = l.size() ;
		    	
		    	for(int i = 0 ; i<condidats.size() ; i ++)
		    	{
		    		//l.get(i).affich_info();
		    		
					Label t = new Label () ;
					t.setPrefSize(780, 160);
					t.setText(condidats.get(i).affich_bien()+"\n-------------------------------------------------------------------------------"+"\n-------------------------------------------------------------------------------");
					//t.ma
					t.setId("bien"+i);
					vb1.getChildren().add(t) ;
					
					/*t.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>()
					{
						@Override
						public void handle(MouseEvent arg0) {
							selected = vb1.getChildrenUnmodifiable().indexOf(t) ;
							System.out.print(selected+"\t") ;
							clientBoutonGroup.setDisable(false);
							
						}*
						
						
					});*/	
		    	}
		    	nbResultatLabel.setText(condidats.size()+" resultats trouves"); ;
				
				
			}
		} catch (CritereVide e) {
			// TODO Auto-generated catch block
			warning.setText("Valeures des Criteres vides , inserer au moins une ! ");
			e.printStackTrace();
		}
    }

}
