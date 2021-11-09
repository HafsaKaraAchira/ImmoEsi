package tpGUI.Control;

//import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;

import tpGUI.IU.Main;
//import tpGUI.IU.Menu;
import tpGUI.Noyau.Bien;

public class PublierBienClientControl extends PublierBienControl{


	@FXML
	public Button publierBoutton;
	@FXML
	public Button rechBout;
	
    @FXML    private ButtonBar clientBoutonGroup;

    @FXML    private Button envoyerBouton;

    @FXML    private Button detailBouton;
    
    @FXML    public Button deconnecterBouton;
    
    int selected = -1 ;

    
    @FXML
    void publier(ActionEvent event)
    {	
    	bp.setCenter(ap);
    	
    	ArrayList<Bien> l = Main.getAgence().getListe_biens() ;
    	Collections.sort(l) ;
    	//int length = l.size() ;
    	vb.getChildren().clear();
    	
    	for(int i = 0 ; i<l.size() ; i ++)
    	{
    		//l.get(i).affich_info();
    		
			Label t = new Label () ;
			t.setPrefSize(780, 160);
			t.setText(l.get(i).affich_bien()+"\n-------------------------------------------------------------------------------"+"\n-------------------------------------------------------------------------------");
			
			//t.ma
			t.setId("bien"+i);
			vb.getChildren().add(t) ;
			
			t.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent arg0) {
					selected = vb.getChildrenUnmodifiable().indexOf(t) ;
					System.out.print(selected+"\t") ;
					clientBoutonGroup.setDisable(false);
					
				}
				
				
			});	
    	}
    	nbResultatLabel.setText(l.size()+" resultats trouves"); ;
    	
   	}
    

    @FXML
    void rechercher(ActionEvent event) 
    {	
    	loadPage ("../IU/pages/rechercher" );	
   	}
    
    @FXML
    void detail(ActionEvent event) {
    	
    }

    @FXML
    void envoyer(ActionEvent event) {
    	loadPage("../IU/pages/envoieMessage") ;
    	
    	//envoyerBouton.setOnAction( new EnvoieMessageControl( Main.getAgence().getListe_biens().get(selected) ) );
    	//Parent root = loader.load();           
    	//EnvoieMessageControl controller = new EnvoieMessageControl( Main.getAgence().getListe_biens().get(selected) ) ;
    	//controller.setSelectedBien(selectedBien) ;
    }
    
    @FXML
    void deconnecter(ActionEvent event) {
    
    	System.out.println("closed") ;
			view.close();
		
    }
   
    private Parent loadPage (String page)
    {
    	Parent root = null ;
    	try {
			root = FXMLLoader.load(getClass().getResource(page+".fxml"));
		}
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	bp.setCenter(root);
		return root;
    }


	//public void setView(Menu menu) {
		// TODO Auto-generated method stub
		
	//}

}
