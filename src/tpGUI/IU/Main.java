package tpGUI.IU;
	
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;

import tpGUI.Noyau.* ;
import tpGUI.Noyau.exceptions_personnalisees.TelephoneInvalid;
import tpGUI.Control.*;

public class Main extends Application 
{
	private static Agence agence ;
	
	public static Agence getAgence() {		return agence;	}

	public static void setAgence(Agence agence) {		Main.agence = agence;	}

	
	@Override
	public void start(Stage primaryStage) 
	{
		 // initialisation du modèle en créant une instance de la classe scolarité.
		Proprietaire prop1 = null;
		Proprietaire prop2 = null;
		Proprietaire prop3 = null;
		Proprietaire prop4 = null;
	
		HashSet<Proprietaire> p = new HashSet<Proprietaire>() ;
		
		Wilaya w1 = new Wilaya ("wilaya1",100000);
		Wilaya w2 = new Wilaya ("wilaya2",30000);
		Wilaya w3 = new Wilaya ("wilaya3",60000);
		
		 HashSet<Wilaya> w = new  HashSet<Wilaya>() ;
		 
		 w.add(w1) ;
		 w.add(w2) ;
		 w.add(w3) ;
		 
		 
		try {
		
			prop1 = new Proprietaire ("nom1","prenom1","nom1@gmail.com",(long) 1234567890,"ouedsmar",null);
			prop2 = new Proprietaire ("nom2","prenom2","nom2@gmail.com",(long) 1234561119,"algeria",null) ;
			prop3 = new Proprietaire ("nom3","prenom3","nom3@gmail.com",(long) 1234567758,"oued smar",null) ;
			prop4 = new Proprietaire ("nom4","prenom4","nom4@gmail.com",(long) 1234567886,"algeria",null) ;
			
			p.add(prop1) ;
			p.add(prop2) ;
			p.add(prop3) ;
			p.add(prop4) ;
			
		} 
		catch (TelephoneInvalid e1) {		e1.printStackTrace();	}
	
	
		// creer des biens
		
		Bien b1 = new Appartement ("adr1",w2,120,prop2,new Vente (), 4000000, 4,1) ;
		prop2.ajoutBien(b1);
		
		Bien b2 = new Maison ("adr2",w3,200,prop1,new Vente (),10000000, 4 ) ;
		((Maison)b2).setJardin(true);
		prop1.ajoutBien(b2);
		
		Bien b3 = new Terrain ("adr3",w1, 500,prop1,new Vente (),20000000, 3 ) ;
		prop1.ajoutBien(b3);
		
		Bien b4 = new Appartement ("adr4",w3,100,prop2,new Location (), 40000,3,1) ;
		prop2.ajoutBien(b4);
		
		Bien b5 = new Maison ("adr5",w2,160,prop3,new Location (),150000,/*pas important*/ 0 ) ;
		
		((Maison)b5).setPiscine(true);
		prop3.ajoutBien(b5);
		
		Bien b6 = new Appartement ("adr6",w3,50,prop2,new Location (), 600000,0,6) ;
		((Appartement) b6).setAscenseur(false);
		((Appartement) b6).setType(TypeAppartement.simplexe);
		prop2.ajoutBien(b6);
		
		
		Bien b7 = new Terrain ("adr7",w1,650,prop1,new Echange (w3), 18000000,1 ) ;
		prop1.ajoutBien(b7);
		
		Bien b8 = new Maison ("adr8",w2,200,prop1,new Echange (w2),14000000, /*pas important*/ 0 ) ;
		((Maison)b8).setGarage(true);
		prop1.ajoutBien(b8);
		
		
		ArrayList<Bien> biens = new ArrayList<Bien>() ;
		
		biens.add(b1);
		biens.add(b2);
		biens.add(b3);
		biens.add(b4);
		biens.add(b5);
		biens.add(b6);
		biens.add(b7);
		biens.add(b8);
		
		ArrayList<Bien> archives = new ArrayList<Bien>() ;
		
		agence = new Agence (biens,p,archives,w);
	
		Admin admin1 = new Admin ( "khaoula" , agence ) ;
		Admin admin2 = new Admin ( "hafsa" , agence ) ;
		Admin admin3 = new Admin ( "admin" , agence ) ;
		Admin admin = new Admin ("admin" , agence) ;
	
		//Admin admin = new Admin ("incorrect", ag);
		
		HashMap<Admin,String> admins = new HashMap<Admin,String>();
		admins.put(admin1, "mot de passe");
		admins.put(admin2, "incorrect") ;
		admins.put(admin3, "secret");
		
		agence.setAdmins(admins);
		
		ArrayList<String> c = new ArrayList <String>() ;
		c.add("Type de Transcation") ;
		c.add("Wilaya souhaitee") ;
		c.add("prix minimum") ;
		c.add("prix maximum") ;
		c.add("type du bien") ;
		c.add("superficie minimale") ;
		c.add("nombre mimimale de pieces") ;
		
		admin.setCriteres(c);
		
		for (Admin key : admins.keySet()) 
		{
			key.setCriteres(c);
		}
   
		try 
		{         
			// lire le fichier fxml.     
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(getClass().getResource("pages/ImmoEsi.fxml"));  
			Parent root = loader.load();      
			// récupérer la classe contrôleur à partir du fichier fxml      
			ImmoEsiControl controller = loader.getController();
			
		     // initiliser la vue et le modèle du contrôleur    
			 //controller.setView(this);     
			 primaryStage.setTitle("Immo Esi");      
			 primaryStage.setScene(new Scene(root));   
			 primaryStage.show();                
		 }
	     catch(Exception e) { 	 e.printStackTrace();       }  
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
