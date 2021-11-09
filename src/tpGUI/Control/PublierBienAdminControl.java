package tpGUI.Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import tpGUI.IU.Main;
import tpGUI.Noyau.Admin;
//import tpGUI.IU.Menu;
import tpGUI.Noyau.Appartement;
import tpGUI.Noyau.Bien;
import tpGUI.Noyau.Echange;
import tpGUI.Noyau.Location;
import tpGUI.Noyau.Maison;
//import tpGUI.Control.RecoiMessageControl ;
import tpGUI.Noyau.exceptions_personnalisees.BienNonExistant;

public class PublierBienAdminControl extends PublierBienControl{
	
	Admin ad ;

	public Admin getAd() {
		return ad;
	}

	public void setAd(Admin ad) {
		this.ad = ad;
	}

	ObservableList<String> listTypeMenu = FXCollections.observableArrayList("Archive","Liste") ;
	
	
	@FXML    private ButtonBar AdminBoutonGroup;
	
	@FXML
    private ChoiceBox<String> listType;
	
  @FXML
    private Button ajouterBouton;

	@FXML
    private Button propBout;

    @FXML
    private Button mesBout;

    @FXML
    private Button desarchiverButton;

    @FXML
    private Button archiverButton;

    @FXML
    private Button modifierButton;

    @FXML
    private Button supprimerButton;

    @FXML
    private Button detailButton;
    
    @FXML    public Button deconnecterBouton;
    
    @FXML public void initialize() 
    {
    	listType.setValue("Liste");
    	listType.setItems(listTypeMenu);
    	
    }
    
int selected = -1 ;

	@FXML
	void detail(ActionEvent event) 
	{
		
		
	}
	
	@FXML
    void desarchiver(ActionEvent event) {

    }
	
	@FXML
    void archiver(ActionEvent event) {
		System.out.print(selected+"archived \t") ;
		try {
			if(ad != null)
			ad.archiver( Main.getAgence().getListe_biens().get(selected) );
			else
			System.out.print(selected+"null no archived \t") ;
		} catch (BienNonExistant e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@FXML
	void modifier(ActionEvent event) {
		
	}

	@FXML
	void supprimer(ActionEvent event) {
		
	}

    @FXML
    void publier(ActionEvent event)
    {	
    	bp.setCenter(ap);
    	ArrayList<Bien> l  ;
    	if(listType.getValue().equals("Liste"))
    	l = Main.getAgence().getListe_biens() ;
    	else 	l = Main.getAgence().getListe_biens_arch() ;
    	vb.getChildren().clear();
    	Collections.sort(l) ;
    	//int length = l.size() ;
    	
    	for(int i = 0 ; i<l.size() ; i ++)
    	{
    		//l.get(i).affich_info();
    		
			Label t = new Label () ;
			t.setPrefSize(780, 160);
			t.setText(l.get(i).affich_bien()+"\n-------------------------------------------------------------------------------"+"\n-------------------------------------------------------------------------------");
			//t.ma
			t.setId("bien"+i);
			vb.setPrefSize(vb.USE_COMPUTED_SIZE,vb.USE_COMPUTED_SIZE);
			vb.getChildren().add(t) ;
			
			t.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent arg0) {
					selected = vb.getChildrenUnmodifiable().indexOf(t) ;
					System.out.print(selected+"\t") ;
					AdminBoutonGroup.setDisable(false);
					
				}
				
				
			});	
    	}
    	nbResultatLabel.setText(l.size()+" resultats trouves"); ;
    	
    	/*archiverButton.setOnAction( (EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
    	{

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.print(selected+"archived \t") ;
				try {
					ad.archiver( Main.getAgence().getListe_biens().get(selected) );
				} catch (BienNonExistant e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});*/
    	
   	}

    
    @FXML
    void ajouter(ActionEvent event) 
    {
    	//loadPage ("pages/rechercher" );
    }

    @FXML
    void messageBouttom(ActionEvent event) 
    {
    	ArrayList<String> list = new ArrayList<String> () ;
    	list.add("here you are the message !");
    	list.add("It is a perfect prodect .");
    	ArrayList<Bien> lis = new ArrayList<Bien> () ;
    	lis.add(new Appartement ("adr6",null,50,null,new Location (), 600000,0,6));
    	lis.add(new Maison ("adr8",null,200,null,new Echange (null),14000000, /*pas important*/ 0 ));
    	
    	FXMLLoader loader = new FXMLLoader () ;
    	Parent root = null ;
    	try 
    	{
			loader.setLocation( getClass().getResource("../IU/pages/AdminPage/RecoiMessage.fxml") ) ;
    		root = loader.load();
		}
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	bp.setCenter(root);
    	
    	//RecoiMessageControl controlleur = loader.getController() ;
   
    }

    @FXML
    void proprietairePage(ActionEvent event) 
    {
    	loadPage ("../IU/pages/AffichProp" );
    }
    
    
    @FXML
    void deconnecter(ActionEvent event) {
    
    	System.out.println("closed") ;
			view.close();
		
    }
    
    
    @FXML
    void rechercher(ActionEvent event) 
    {
    	loadPage ("../IU/pages/rechercher" );
    }
    
    private void loadPage (String page)
    {
    	Parent root = null ;
    FXMLLoader loader = new FXMLLoader ();
    	try {
    		root = FXMLLoader.load(getClass().getResource(page+".fxml"));
		}
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	bp.setCenter(root);
    }

	//public void setView(Menu menu) {
		// TODO Auto-generated method stub
		
	//}

}
