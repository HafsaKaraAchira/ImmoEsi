package tpGUI.Control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
//import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import tpGUI.IU.Main;
import tpGUI.Noyau.Appartement;
import tpGUI.Noyau.Bien;
import tpGUI.Noyau.Echange;
import tpGUI.Noyau.Location;
import tpGUI.Noyau.Maison;
import tpGUI.Noyau.Proprietaire;
import tpGUI.Noyau.Terrain;
import tpGUI.Noyau.Transaction;
import tpGUI.Noyau.TypeAppartement;
import tpGUI.Noyau.Vente;
import tpGUI.Noyau.Wilaya;
//import tpGUI.Noyau.Transaction;
import tpGUI.Noyau.exceptions_personnalisees.SurfaceHabitableInvalid;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AjouterControl {

	ObservableList<String> bienTypeList = FXCollections.observableArrayList("Appartement","Maison","Terrain") ;
	ObservableList<String> transactionTypeList = FXCollections.observableArrayList("Vente","Location","Echange") ;
	ObservableList<String> proprietaireList = FXCollections.observableArrayList() ;
	ObservableList<String> appartementType = FXCollections.observableArrayList("Simplexe","Duplexe") ;

		@FXML
	    private ChoiceBox<String> TypeBien;

	    @FXML
	    private GridPane gridPane;

	    @FXML
	    private Label case01;

	    @FXML
	    private Label case02;

	    @FXML
	    private Label case03;

	    @FXML
	    private Label case04;

	    @FXML
	    private Label case05;

	    @FXML
	    private Label case06;

	    @FXML
	    private Label case07;

	    @FXML
	    private TextField adresse;

	    @FXML
	    private TextField wilaya;

	    @FXML
	    private TextField superficie;

	    @FXML
	    private ChoiceBox<String> type = new ChoiceBox<String>() ;
	    
	    @FXML
	    private ChoiceBox<String> proprietaire;

	    @FXML
	    private ChoiceBox<String> transaction;

	    @FXML
	    private TextField prix;

	    @FXML
	    private CheckBox negociable;


	    @FXML
	    private TextArea descriptif;

	    @FXML
	    private TextField uRLphotos;

	    @FXML
	    private Button AjouterBouton;

	    @FXML
	    private Label warning;
	    
	    TextField nbpieces = new TextField ();
       	CheckBox meuble = new CheckBox ();
       	TextField nbetages = new TextField ();
       	CheckBox garage  = new CheckBox () ;
       	CheckBox jardin  = new CheckBox ();
       	CheckBox piscine  = new CheckBox ();
       	TextField surfh = new TextField () ;
	    
       	//TextField nbpieces = new TextField () ;
	    //CheckBox meuble  = new CheckBox ();
       	//ChoiceBox<String> Type ;
	    TextField etage = new TextField () ;
	    CheckBox ascenceur  = new CheckBox () ;
	    
	    TextField nbfacades = new TextField ();
	    TextField statut = new TextField ();


    @FXML public void initialize() 
    {
    	TypeBien.setValue("Maison");
    	TypeBien.setItems(bienTypeList);
    	
    	transaction.setValue("Vente");
    	transaction.setItems(transactionTypeList);
    	
    	Proprietaire pro = null ;
    	//ObservableList<String> propString = new FXCollections.observableArrayList <String> () ;
    	//HashSet<Proprietaire> prop ;
    	HashSet<Proprietaire> props = Main.getAgence().getListe_props() ;
		Iterator<Proprietaire> it = props.iterator () ;
		while ( it.hasNext() )
		{
			pro = it.next() ;
			proprietaireList.add(pro.getNom()+" "+pro.getPrenom()+" "+pro.getAdresse());
		}
		proprietaireList.add("Inserrer un nouveau proprietaire");
		proprietaire.setValue("Inserrer un nouveau proprietaire");
		proprietaire.setItems(proprietaireList);
		
		type.setValue("Simplexe");
    	type.setItems(appartementType);
		
    }
    
    @FXML
    void digitinput(MouseEvent event)
    {
    	//if(!evt.getCode().isDigitKey()) {evt.consume();}
    	gridPane = new GridPane () ;
    	
    	switch ( TypeBien.getValue() )
       	{
       	case("Maison"):
       	{
           	case01.setText("Le nombre de pièces:");
           	case02.setText("La maison est :");
           	case03.setText("Le nombre d'étages:");
           	case04.setText("Le garage:");
           	case05.setText("Le jardin");
           	case06.setText("La piscine:");
           	case07.setText("La surface habitable:");
           	
           	gridPane.add ( nbpieces,1,9 );
           	
           	gridPane.add( meuble , 1, 10 );
           	meuble.setText("Meublé");
           	
           	gridPane.add( nbetages , 1, 11 );
           	
           	gridPane.add( garage , 1, 12 );
           	garage.setText("garage");
           	
           	gridPane.add( jardin , 1, 13 );
           	jardin.setText("jardin");
           	
           	gridPane.add( piscine , 1, 14 );
           	piscine.setText("piscine");
           	
           	gridPane.add( surfh , 1, 15 );
           	
           	break;
       	}
       	case ("Appartement"):
       	{
           	case01.setText("Le nombre de pièces:");
           	case02.setText("L'appartement est :");
           	case03.setText("L'étages:");
           	case04.setText("Le type:");
           	case05.setText("L'ascenceur:");
           	//case06.setText("");
           	//case07.setText("");
           	
           	gridPane.add( nbpieces , 1, 9);
           	
           	gridPane.add( meuble , 1, 10 );
           	meuble.setText("meublé");
           	
           	gridPane.add( etage , 1, 11 );
           	
           	gridPane.add( type , 1, 12 );
           	
           	gridPane.add( ascenceur , 1, 13 );
           	ascenceur.setText("ascenceur");
          
           	Label v1 = new Label() ; v1.setText("");
           	gridPane.add( v1 , 1, 14 );
           	Label v2 = new Label() ; v2.setText("");
           	gridPane.add( v2 , 1, 15 );
           	
           	break ;
       	}
       	case ("Terrain"):
       	{
           	case01.setText("Le nombre de facade:");
           	gridPane.add( nbfacades , 1, 9);
           	case02.setText("Le statut juredique :");
        	gridPane.add( statut , 1, 10 );
           	case03.setText("");
           	case04.setText("");
           	case05.setText("");
           	case06.setText("");
           	case07.setText("");
           	
           	
           
           
           	Label v3 = new Label() ; v3.setText("");
           	gridPane.add( v3 , 1, 11 );
           	Label v4 = new Label() ; v4.setText("");
           	gridPane.add( v4 , 1, 12 );
           	Label v5 = new Label() ; v5.setText("");
           	gridPane.add( v5 , 1, 13 );
           	Label v6 = new Label() ; v6.setText("");
           	gridPane.add( v6 , 1, 14 );
           	Label v7 = new Label() ; v7.setText("");
           	gridPane.add( v7 , 1, 15 );
           	
           	break ;
       	}
    }
    }
    
    @FXML
    Bien ajouter (ActionEvent event) 
    {
    	Bien bien = null ;
    	String adr = adresse.getText();
       	String wil = wilaya.getText();
       	Wilaya wila = rechercheWilaya(wil) ;
       	if ( wila == null )
		{
			//wilaya.setText ( " Cette wilaya n'existe pas dans la liste , On va créer un nouveau wilaya "  );
		
			//System.out.print("Donner le prix d'un métre carré pour cette wilaya : ");
			wila = new Wilaya ( wil , 0 );
			
		}
       	String sup = superficie.getText();
       	String prop = proprietaire.getValue();
       	Proprietaire pro = null ;
       	boolean trouv = false ;
    	HashSet<Proprietaire> props = Main.getAgence().getListe_props() ;
		Iterator<Proprietaire> it = props.iterator () ;
		while ( it.hasNext() && !trouv )
		{
			pro = it.next() ;
			proprietaireList.add(pro.getNom()+" "+pro.getPrenom()+" "+pro.getAdresse());
			trouv = ( prop.equals(pro));
		}
		Transaction trans = null ;
		switch(transaction.getValue())
		{
		case("Vente"):
		{
			trans = new Vente();
		}
		case("Location"):
		{
			trans = new Location() ;
		}
		case("Echange"):
		{
			trans = new Echange (null) ;
		}
		}
       	String pri = prix.getText() ;
       	boolean nego = negociable.isFocused() ;
       	String des = descriptif.getText();
       	String uRL = uRLphotos.getText();
       	
       	switch ( TypeBien.getValue() )
       	{
       	case("Maison"):
       	{
  
           	String nbp = nbpieces.getText();
           	
           	Boolean meu = meuble.isFocused() ;
           	
           	String nbet = nbetages.getText() ;
           	
           	boolean gar =  garage.isFocused() ;
           	boolean jar = jardin.isFocused();
           	boolean pis = piscine.isFocused();
           	
           	String surh = surfh.getText();
           
        	bien = new Maison (adr, wila , Integer.parseInt(sup), pro , trans , Integer.parseInt(pri) , Integer.parseInt(nbp)) ;
			((Maison)bien).setMeuble(meu);
			((Maison)bien).setNbetages(Integer.parseInt(nbet));
			((Maison)bien).setGarage(gar);
			((Maison)bien).setPiscine(pis);
			((Maison)bien).setJardin(jar);
			try {
				((Maison)bien).setSurfacehabitable(Integer.parseInt(surh));
			} catch (SurfaceHabitableInvalid e) {
				System.out.println("Surface Habitable Invalid !") ;
			}
			
           	break;
       	}
       	case ("Appartement"):
       	{
           	String nbp = nbpieces.getText();
           	
           	boolean meu = meuble.isFocused();
           	
           	TypeAppartement typ = null ;
           	switch(type.getValue())
           	{
           	case("Simplexe"):
           	{
           		typ = TypeAppartement.simplexe ;
           	}
           	case("Duplexe"):
           	{
           		typ = TypeAppartement.duplexe ;
           	}
           	}
           	
           	String eta = etage.getText();
           	
           	boolean asc = ascenceur.isFocused();
           	
           	bien = new Appartement (adr, wila , Integer.parseInt(sup), pro, trans, Integer.parseInt(pri), Integer.parseInt(nbp) , Integer.parseInt(eta)) ;
			
			((Appartement)bien).setMeuble(meu);
			((Appartement)bien).setType(typ);
			((Appartement)bien).setAscenseur(asc);
           	
           	break ;
       	}
       	case ("Terrain"):
       	{
           	String nbf = nbfacades.getText();
           	
           	String sta = statut.getText();
           	
           	bien = new Terrain (adr, wila , Integer.parseInt(sup) , pro, trans, Integer.parseInt(pri), Integer.parseInt(nbf));
			
			((Terrain)bien).setStatut(sta);
           	
           	break ;
       	}
    }
       	
       	ArrayList<Bien> listeBiens =  Main.getAgence().getListe_biens() ;
       	listeBiens.add(bien);
       	Main.getAgence().setListe_biens( listeBiens );
		return bien;
       	
 }
    
    public Wilaya rechercheWilaya ( String wil )
	{
		Wilaya wilaya = new Wilaya ( wil , 0 ) ;
		Wilaya wila = null ;
		HashSet<Wilaya> wilayas = Main.getAgence().getListe_wilayas() ;
		boolean trouv = false ;
		Iterator<Wilaya> it = wilayas.iterator () ;
		while ( it.hasNext() && ! trouv )
		{
			wila = it.next() ;
			trouv = wila.equals(wilaya) ;
		}
		if ( ! trouv ) {	return null ;	}
		return wila ;
	}
	
	public Proprietaire rechercheProp ( Proprietaire prop )
	{
		Proprietaire pro = null ;
		if(prop != null)
		{
		HashSet<Proprietaire> props = Main.getAgence().getListe_props() ;
		boolean trouv = false ;
		Iterator<Proprietaire> it = props.iterator () ;
		while ( it.hasNext() && ! trouv )
		{
			pro = it.next() ;
			trouv = pro.equals(prop) ;
		}
		if ( ! trouv ) {	return null ;	}
		}
		return pro ;
	}

}