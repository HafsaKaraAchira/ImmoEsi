package tpGUI.Control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import tpGUI.IU.Main;
import tpGUI.Noyau.Agence;
import tpGUI.Noyau.Appartement;
import tpGUI.Noyau.Bien;
import tpGUI.Noyau.Echange;
import tpGUI.Noyau.Location;
import tpGUI.Noyau.Maison;
import tpGUI.Noyau.Proprietaire;
import tpGUI.Noyau.Terrain;
import tpGUI.Noyau.Transaction;
import tpGUI.Noyau.Vente;
import tpGUI.Noyau.Wilaya;
import tpGUI.Noyau.exceptions_personnalisees.* ;

public class ModifBienControl 
{
	private Main model ; 
	  public Main getModel() {			return model;		}
	  public void setModel(Main model) {			this.model = model;		}
	
	
    @FXML
    private GridPane appartement;

    @FXML
    private TextField adresse;

    @FXML
    private TextField wilaya;

    @FXML
    private TextField superficie;

    @FXML
    private TextField proprietaire;

    @FXML
    private TextField transaction;

    @FXML
    private TextField prix;

    @FXML
    private TextField prixNegociable;

    @FXML
    private TextField descriptif;

    @FXML
    private TextField date;

    @FXML
    private TextField uRLphotos;

    @FXML
    private TextField nbpieces;

    @FXML
    private TextField meuble;

    @FXML
    private TextField type;

    @FXML
    private TextField etage;

    @FXML
    private TextField ascenceur;

    @FXML
    private GridPane maison;

    @FXML
    private Label uRLphotos13;

    @FXML
    private Label uRLphotos12;

    @FXML
    private Label uRLphotos14;

    @FXML
    private Label uRLphotos16;

    @FXML
    private Label uRLphotos19;

    @FXML
    private Label uRLphotos112;

    @FXML
    private Label uRLphotos1121;

    @FXML
    private TextField garage;

    @FXML
    private TextField nbetage;

    @FXML
    private TextField piscine;

    @FXML
    private TextField jardin;

    @FXML
    private TextField surfaceHabitable;

    @FXML
    private GridPane terrain;

    @FXML
    private TextField statut;

    @FXML
    private TextField nbfacade;

    @FXML
    private Button enregistrerBoutton;

    @FXML
    private Button annulerBoutton;
    
    
    public void TypeBien(Bien bien) 
    {
    	maison.setVisible(true) ;
    	terrain.setVisible(false);
    	appartement.setVisible(false);	
	}
    public void TypeBien( Maison bien )
    {
    	maison.setVisible(true) ;
    	terrain.setVisible(false);
    	appartement.setVisible(false);
    }
    public void TypeBien( Appartement bien )
    {
    	maison.setVisible(false) ;
    	terrain.setVisible(false);
    	appartement.setVisible(true);
    }
    public void TypeBien( Terrain bien )
    {
    	maison.setVisible(false) ;
    	terrain.setVisible(true);
    	appartement.setVisible(false);
    }

    @FXML
    void annuler(ActionEvent event) 
    {

    }

    @FXML
    void enregistrer(ActionEvent event) 
    {

    }
    
    public void modifier (  Main model , int indice ) 	throws BienNonExistant , BienExistantDeja , IndexOutOfBoundsException
	{
		this.setModel(model);
    	Agence agence = model.getAgence() ;
		Bien bien = agence.getListe_biens().get(indice) ;
		Bien b = null  ;
		switch(bien.getClass().getSimpleName())
		{
			case "Appartement" : b= new Appartement() ;
			case "Maison" : b= new Maison() ;
			case "Terrain" : b= new Terrain() ;
		}
		//int indice=agence.getListe_biens().indexOf(b) ;
		//if( ! agence.getListe_biens().contains(bien) ) throw new BienNonExistant() ;
		
		if ( ! (adresse.getText()).equals("") )
		{
			b.setAdresse(adresse.getText());
		}
		else b.setAdresse(bien.getAdresse());
		
		if ( ! (wilaya.getText()).equals("")  )
		{
			String wil = wilaya.getText() ;
			Wilaya wilaya = rechercheWilaya (wil)  ;
			if ( wilaya == null )
			{
				/*
				 * System.out.println ( " Cette wilaya n'existe pas dans la liste, " + 
							"On va créer un nouveau wilaya "  );
				//if ( (input.next()).equals("oui") )	{	}
				System.out.print("Donner le prix d'un mètre carré pour cette wilaya : ");
				 */
				wilaya = new Wilaya ( wil , 0 );
				(agence.getListe_wilayas()).add(wilaya);  // ajouter la wilaya
			}
			b.setWilaya(wilaya);
		}
		else b.setWilaya(bien.getWilaya());
		
		if ( ! (superficie.getText()).equalsIgnoreCase("") )
		{
			superficie.getText();
			b.setSuperficie( (superficie.getText()).hashCode() ); // RECHERCHER 
		}
		else b.setSuperficie(bien.getSuperficie());
		
		System.out.println (".Proprietaire : ");
		if ( ! (proprietaire.getText()).isBlank() )
		{
			Proprietaire pro = null ;
			
			/*
			 * try {	pro = lectProp(input) ;	} 
			catch (TelephoneInvalid e) 	{	e.printStackTrace();	}
	
			if ( rechercheProp (pro) == null )
			{
				System.out.println ( " Cette proprietaire n'existe pas dans la liste, " + "On va créer un nouveau propriétaire ."  );
				(agence.getListe_props()).add(pro) ; 	// ajouter le bien
			}
			else
			{
				pro = rechercheProp ( pro ) ;
				
			}
			 */
			//pro.ajoutBien(b);
			b.setProp(pro);
		}
		else b.setProp(bien.getProp());
		
		System.out.println (".Transaction :" );
		System.out.println   (".Choisir un type:");
		System.out.println ( "1. Vente " );
		System.out.println ( "2. Location " );
		System.out.println ( "3. Echange " );
		
		int ch ;
		
		if ( false )
		{
			do {
			
			Transaction trans = null ;
			//int ch = input.nextInt() ;
			switch ( ch )
			{
			case 1 :	
			{	trans = new Vente ( b );
				break ;
			}
			case 2 :	
			{	trans = new Location ( b ) ; 	  
				break;
			}
			case 3 : 	
			{	System.out.println ( "   .Donner la wilaya souhaité pour l'échange :" );  
				String wil = null ; //input.next () ;
				Wilaya wila = rechercheWilaya(wil) ;
				if ( wila == null )
				{
					System.out.println ( " Cette wilaya n'existe pas dans la liste, " + 
							"On va créer un nouveau wilaya "  );
					System.out.print("Donner le prix d'un métre carré pour cette wilaya : ");
					//wila = new Wilaya ( wil , input.nextDouble() );
				}
				trans = new Echange ( b , wila ) ;
				break;
			}	
			default : {	System.out.println ( " Erreur , il faut choisir 1 ou 2 ou 3  ! ");}
			}
			b.setTrans(trans);
			}while(ch>3 || ch<0  ) ;
		}
		else b.setTrans(bien.getTrans());
		
		
		System.out.println (".Le prix :" );
		if ( false )
		{
			b.setPrix(ch);
		}
		else b.setPrix(bien.getPrix());
		
		System.out.println (".Est ce que le prix est négociable : ( écrire oui ou non ) ");
		if ( false )
		{
			boolean prixNegociable = false ;
			if ( false )
			{
				prixNegociable = true ;
			}
			b.setPrixNegociable(prixNegociable);
		}
		else b.setPrixNegociable(bien.isPrixNegociable());
		
		System.out.println (".Descriptif : "  );
		if ( false )
		{
			//b.setDescriptif(input.next());
		}
		else b.setDescriptif(bien.getDescriptif());
		
		System.out.println ( ".URLphotos :" );
		if ( false )
		{
			//b.setURLphotos(input.next());
		}
		else b.setURLphotos(bien.getURLphotos());
		
		//b.modifier( input , b );
		
		ArrayList<Bien> l =  agence.getListe_biens();
		//.subList(0, indice);
		
		//System.out.println (agence.getListe_biens().size());
		
		b.setDate(bien.getDate());
		
		//l.addAll( agence.getListe_biens().subList( indice+1, agence.getListe_biens().size() ) ) ;
		//System.out.println (l.size());
		
		if(! agence.getListe_biens().contains(b) ) 
		{
			(bien.getProp()).suppBien(bien);
			b.getProp().ajoutBien(b);
			l.set(indice,b) ;
			//System.out.println (l.size());
			agence.setListe_biens( l ) ;
			
		}else throw new BienExistantDeja() ;
		
	}
    
    public Wilaya rechercheWilaya ( String wil )
	{
		Wilaya wilaya = new Wilaya ( wil , 0 ) ;
		Wilaya wila = null ;
		HashSet<Wilaya> wilayas = model.getAgence().getListe_wilayas() ;
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
		HashSet<Proprietaire> props = model.getAgence().getListe_props() ;
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
