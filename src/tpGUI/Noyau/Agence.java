package tpGUI.Noyau;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.Scanner ;

//import java.util.Set;

//import tpGUI.Noyau.exceptions_personnalisees.BienExistantDeja;
//import tpGUI.Noyau.exceptions_personnalisees.BienNonExistant;
//import tpGUI.Noyau.exceptions_personnalisees.CritereInvalid;
//import tpGUI.Noyau.exceptions_personnalisees.CritereVide;
//import tpGUI.Noyau.exceptions_personnalisees.ListeVide;
import tpGUI.Noyau.exceptions_personnalisees.MotDePasseException;
//import tpGUI.Noyau.exceptions_personnalisees.OperationInvalid;
//import tpGUI.Noyau.exceptions_personnalisees.TelephoneInvalid;

import java.util.HashMap;

//import java.util.Iterator ;
//import java.util.Date ;

public class Agence 
{

	private ArrayList<Bien> liste_biens = new ArrayList<Bien>() ;
	private HashSet<Proprietaire> liste_props = new HashSet<Proprietaire>() ;
	private ArrayList<Bien> liste_biens_arch = new ArrayList<Bien>() ;
	private HashSet<Wilaya> liste_wilayas = new  HashSet<Wilaya>() ;
	private HashMap<Admin,String> liste_admins = new HashMap<Admin,String>();
	private ArrayList<String> listeMessage = new ArrayList<String>();
	private ArrayList<Bien> bienAssocieMessage = new ArrayList<Bien>();
	private int messageNonLu = 0 ;
	
	public int getMessageNonLu() {
		return messageNonLu;
	}

	public void setMessageNonLu(int messageNonLu) {
		this.messageNonLu = messageNonLu;
	}

	public Agence(ArrayList<Bien> liste_biens,  HashSet<Proprietaire> liste_props, ArrayList<Bien> liste_biens_arch, HashSet<Wilaya> liste_wilayas)
	{
		this.liste_biens = liste_biens;
		this.liste_props = liste_props;
		this.liste_biens_arch = liste_biens_arch;
		this.liste_wilayas = liste_wilayas;
	}

	public ArrayList<Bien> getListe_biens() {	return liste_biens;}

	public void setListe_biens(ArrayList<Bien> liste_biens) {	this.liste_biens = liste_biens;}

	public HashSet<Proprietaire> getListe_props() {	return liste_props;}

	public void setListe_props(HashSet<Proprietaire> liste_props) {	this.liste_props = liste_props;}

	public ArrayList<Bien> getListe_biens_arch() {	return liste_biens_arch;}

	public void setListe_biens_arch(ArrayList<Bien> liste_biens_arch) {		this.liste_biens_arch = liste_biens_arch;}

	public HashSet<Wilaya> getListe_wilayas() {	return liste_wilayas;}

	public void setListe_wilayas(HashSet<Wilaya> liste_wilayas) {	this.liste_wilayas = liste_wilayas;}

	public HashMap<Admin,String> getAdmins() {	return liste_admins;	}

	public void setAdmins(HashMap<Admin,String> admins) {	this.liste_admins = admins;	}

	public ArrayList<Bien> getBienAssocieMessage() {
		return bienAssocieMessage;
	}

	public void setBienAssocieMessage(ArrayList<Bien> bienAssocieMessage) {
		this.bienAssocieMessage = bienAssocieMessage;
	}

	public ArrayList<String> getListeMessage() {
		return listeMessage;
	}

	public void setListeMessage(ArrayList<String> listeMessage) {
		this.listeMessage = listeMessage;
	}
	
	public static Boolean motDePasse ( String mot ,  HashMap.Entry< Admin, String > admin   ) throws MotDePasseException
	{
		Boolean acces = false ;
		if ( mot.equals(admin.getValue()) )	acces = true ;
		else throw new MotDePasseException () ;
		return acces ;
		
	}

	public static int menuAdmin ( Scanner input )
	{
		System.out.println ("          **** MENU Administrateur *****   ");

		System.out.println ("01. Afficher le menu.");
		
		
		System.out.println ("02. Ajouter un nouveau bien dans la liste des biens.");
		System.out.println ("03. Archiver un bien.");
		System.out.println ("04. Supprimer un bien de liste des biens.");
		System.out.println ("05. Modifier un bien.");

		
		System.out.println ("06. Publier tous les biens.");
		System.out.println ("07. Afficher tous les biens d'un propriétaire.");
		System.out.println ("08. Afficher les informations d'un bien.");
	
		System.out.println ("09. Rechercher les biens par un critére ou plusieurs.");
		
		System.out.println ("10. Afficher le prix final  d'un bien."); 
		// les prix finaux pour chaque bien
		
		System.out.println ("11. Reçevoir un message.");

		System.out.println ("12. Affiche tous les biens archives : .");
		
		System.out.println ("13. Desarchiver : .");
		
		System.out.println ("14. Afficher la liste des Proprietaire : .");
		
		System.out.println ("00. Quitter.");
		
		System.out.print (".Choisir un numéro :");

		int choix = input.nextInt() ;

		return choix ;
		
	}
	
	public static int menuClient ( Scanner input )
	{
		System.out.println ("          **** MENU *****   ");

		System.out.println ("01. Afficher le menu.");
	
		System.out.println ("02. Publier tous les biens.");
		
		System.out.println ("03. Afficher les informations d'un bien.");
	
		System.out.println ("04. Rechercher les biens par un critére ou plusieurs.");
		
		System.out.println ("05. Afficher le prix final  d'un bien."); // les prix finaux pour chaque bien
		
		System.out.println ("06. Envoyer un message.");

		System.out.println ("00. Quitter.");
		
		System.out.print (".Choisir un numéro :");

		int choix = input.nextInt() ;

		return choix ;
		
	}
	
	
	/*
	public static void main( String[] args )// throws TelephoneInvalid 
	{

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
		
		Bien b5 = new Maison ("adr5",w2,160,prop3,new Location (),150000,//pas important*//* 0 ) ;
		/*
		((Maison)b5).setPiscine(true);
		prop3.ajoutBien(b5);
		
		Bien b6 = new Appartement ("adr6",w3,50,prop2,new Location (), 600000,0,6) ;
		((Appartement) b6).setAscenseur(false);
		((Appartement) b6).setType(TypeAppartement.simplexe);
		prop2.ajoutBien(b6);
		
		
		Bien b7 = new Terrain ("adr7",w1,650,prop1,new Echange (w3), 18000000,1 ) ;
		prop1.ajoutBien(b7);
		
		Bien b8 = new Maison ("adr8",w2,200,prop1,new Echange (w2),14000000, /*pas important*/ /*0 ) ;
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
		
		Agence ag = new Agence (biens,p,archives,w);

		Admin admin1 = new Admin ( "khaoula" , ag ) ;
		Admin admin2 = new Admin ( "hafsa" , ag ) ;
		Admin admin3 = new Admin ( "admin" , ag ) ;
		Admin admin = new Admin ("admin" , ag) ;

		//Admin admin = new Admin ("incorrect", ag);
		
		HashMap<Admin,String> admins = new HashMap<Admin,String>();
		admins.put(admin1, "mot de passe");
		admins.put(admin2, "incorrect") ;
		admins.put(admin3, "secret");
		
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

		
		int choix = 1 ;
		
		String ch = "" ;
		Scanner input = new Scanner (System.in) ;
		boolean retry = false ;
		
		
		System.out.print   (" Comment vous allez connecter : ");
		System.out.println ( " 1-> En tant qu'administrateur ?");
		System.out.println ("                                 2-> En tant que client ?");
		
		do
		{
		
			System.out.print   (" . Choisir 1 ou 2 ou 0 pour sortir : ");
		
		//do {
			
		ch = input.nextLine() ;	
		
		//input.nextLine () ;
		
		switch ( ch )
		{
		
		case "1" :
		{
			Boolean acces = false ;
			Boolean trouv = false ;
			Boolean sortir = false ;
			String passe ;
			
			Set< HashMap.Entry< Admin, String > > entryAdmin =  admins.entrySet() ;
			
			 HashMap.Entry< Admin, String > ad = null;
			
			do
			{
				System.out.println("Donner votre nom :");
				
				passe = input.nextLine();
				 Iterator < HashMap.Entry< Admin, String > >it = entryAdmin.iterator();
				 while (! trouv && it.hasNext())
				 {
					 //System.out.println ( it.next() ) ;
					 ad = it.next();
					 admin = ad.getKey() ;
					 if ( passe.equals(admin.getNom()) )	{ trouv = true ; }
				 } 
				if ( ! trouv ) 
				{
					System.out.println ("Ce nom n'exist pas ! Ressayer ?" );
					System.out.println (" ecrire 1 si vous voulez reéssayer, un autre nombre sinon.") ;
					sortir = ( ! input.nextLine().equals("1") ) ;
					//input.nextLine() ;
				}
				
			} while ( ! trouv && ! sortir ) ;
			
			if ( trouv )
			{
			sortir = false ;
			while ( ! acces && ! sortir)
			{
				System.out.println("Donner le mot de passe :");
				//input.nextLine();
				passe = input.nextLine();
				try {
					acces = motDePasse (passe, ad) ;
					} 
				catch (MotDePasseException e) 
				{
					e.printStackTrace() ;
					System.out.println (" ecrire 1 si vous voulez ressayer, un autre nombre sinon.") ;
					sortir =  ! input.nextLine().equals("1") ;
					//input.nextLine();
				}
				
			}
			}
			if (acces)
			{
			choix = menuAdmin ( input ) ;
			while ( choix != 0 )
			{
				switch ( choix )
				{
				case 1 :
				{
					choix = menuAdmin (input) ;
					break ;
				}
				case 2 :
				{
					System.out.println(" 			*Inserer un bien:	");
					System.out.println(".Donner les informations de bien que vous voulez inserer: ");
					try {
						admin.inserer(admin.lectBien(input));
						}
						catch(BienExistantDeja e) {e.printStackTrace();} 
						catch (OperationInvalid e) {	e.printStackTrace();}
					break ;
				}
				case 3 :
				{
					System.out.println(" 			*Archiver un bien:	");
					
					System.out.println(".Donner l'indice de bien que vous voulez archiver: ");
					try {
						admin.archiver(biens.get(input.nextInt()-1));
					} catch (BienNonExistant e) {	e.printStackTrace();	}
					catch(IndexOutOfBoundsException e) {System.out.println(" Indice non valide !"); }
					
					break ;
				}
				case 4 :
				{
					System.out.println(" 			*Supprimer un bien:	");
					System.out.println(".Donner l'indice de bien que vous voulez supprimer: ");
					try {
						admin.supprimer(biens.get(input.nextInt()-1));
					} catch (BienNonExistant e) {	e.printStackTrace(); }
					catch(IndexOutOfBoundsException e) {System.out.println(" Indice non valide !"); }
					break ;
				}
				case 5 :
				{	
					System.out.println(" 			*Modifier un bien:	");
					System.out.println(".Donner l'indice de bien que vous voulez modifier: ");
					try {
						admin.modifier(input,input.nextInt()-1);
					} catch (BienNonExistant e) {	e.printStackTrace();	}
					  catch (BienExistantDeja e) {	e.printStackTrace(); 	}
					  catch(IndexOutOfBoundsException e) {System.out.println(" Indice non valide !"); }
					
					break ;
				}
					
				case 6 :
				{
					System.out.println(" 			*Publier tous les biens:	");
					admin.publier();
					break ;
				}
				case 7 :
				{
					System.out.println(" 			*Afficher tous les biens d'un propriétaire :	");
					System.out.println(".Donner les informations de propriétaire que vous voulez afficher ses biens: ");
					try {
						admin.afficher( admin.lectProp(input) );
					} catch (TelephoneInvalid e) {	e.printStackTrace();	} 
					catch (ListeVide e) {	e.printStackTrace();} 
					break ;
				}
				case 8 :
				{
					System.out.println(" 			*Afficher tous les informations d'un bien :	");
					System.out.println(".Donner l'indice de bien que vous voulez afficher ses informations: ");
					try
					{admin.afficher(biens.get(input.nextInt()-1));
					}catch(IndexOutOfBoundsException e) {System.out.println(" Indice non valide !"); }
					break ;
				}
				case 9 :
				{
					System.out.println(" 			*Rechercher les biens vérifier un ou plusieurs critères données :	");
					System.out.println("  Rechercher :");
					ArrayList<String> l=new ArrayList<String>();
					try {
						l = admin.lectCrit(input);
						admin.rechercher(l);
					}
					catch (CritereInvalid e1) {	e1.printStackTrace();}
					catch (NumberFormatException e2 ) { System.out.println("ce n\'est pas un nombre !") ; }
					catch (CritereVide e) {		e.printStackTrace();	}
					
					
					break ;
				}
				case 10 :
				{
					System.out.println(" 			*Calculer le prix final d'un bien :	");
					System.out.println(".Donner l'indice de bien que vous voulez calculer son prix: ");
					int indice=input.nextInt()-1 ;
					System.out.print(" Le prix final pour cette bien est:");
					try {
					System.out.println((biens.get(indice).getTrans()).calcul_prix());
					}catch(IndexOutOfBoundsException e) {System.out.println(" Indice non valide !"); }
					break ;
				}
				case 11 :
				{
					System.out.println(" 			*Recevoir un message :	");
					// ?
					admin.recoiMessage();
					// ?
					break ;
				}
				case 12 :
				{
					System.out.println(" 			*Publier tous les biens archives :	");
					admin.afficherbienArch() ;
					break ;
				}
				case 13 :
				{
					System.out.println(" 			*Desarchiver un bien:	");
					//System.out.println(".Qu'elle est le bien que vous voulez archiver: ");
					//admin.archiver(admin.lectBien(input));
					System.out.println(".Donner l'indice de bien que vous voulez archiver: ");
					try {
						admin.desarchiver(admin.getAgence().getListe_biens_arch().get(input.nextInt()-1));
					} catch (BienNonExistant e) {	e.printStackTrace();	}
					catch(IndexOutOfBoundsException e) {System.out.println(" Indice non valide !"); } 
					catch (ListeVide e) {	e.printStackTrace();}
					
					break ;
				}
				case 14 :
				{
					System.out.println(" * Afficher la liste des proprietaires :	");
					admin.affich_list_Prop() ;
				}
				default :
				{
					
				}
				
				}
				System.out.println();
				System.out.println();
				if ( ! retry && choix != 1 )
				{
					System.out.print (".Choisir un numéro :");
					choix = input.nextInt() ;
				}
			}
			}
			break ;
		}
		case "2" :
		{
			choix = menuClient ( input ) ;
			while ( choix != 0 )
			{
				switch ( choix )
				{
				case 1 :
				{
					choix = menuClient (input) ;
					break ;
				}
				case 2 :
				{
					System.out.println(" 			*Publier tous les biens:	");
					admin.publier();
					break ;
				}
				case 3 :
				{
					System.out.println(" 			*Afficher tous les informations d'un bien :	");
					System.out.println(".Donner l'indice de bien que vous voulez afficher ses informations: ");
					try {
					admin.afficher(biens.get(input.nextInt()-1));
					}catch(IndexOutOfBoundsException e) {System.out.println(" Indice non valide !"); }
					break ;
				}
				case 4 :
				{
					System.out.println(" 			*Rechercher les biens vérifier un ou plusieurs critères données :	");
					System.out.println("  Rechercher :");
					ArrayList<String> l=new ArrayList<String>() ;
					try {
						l = admin.lectCrit(input);
					} catch (CritereInvalid e1) {	e1.printStackTrace();}
					try {	admin.rechercher(l);
					} catch (CritereVide e) {	e.printStackTrace();}
					break ;
				}
				case 5 :
				{
					System.out.println(" 			*Calculer le prix final d'un bien :	");
					System.out.println(".Donner l'indice de bien que vous voulez calculer son prix: ");
					try {
					(biens.get(input.nextInt()-1).getTrans()).calcul_prix();
					}catch(IndexOutOfBoundsException e) {System.out.println(" Indice non valide !"); }
					break ;
				}
				case 6 :
				{
					System.out.println(" 			*Envoyer un message :	");
					
					System.out.println("Donner l'indice de bien sur laquelle vous voulez envoyer le message :");
					int ind = input.nextInt() ;
					
					System.out.println ("Donner le message que vous voulez envoyer :");
					//admin.recoiMessage(input.next());
					input.nextLine();
					try {
					admin.envoiMessage(input.nextLine() , biens.get(ind-1));
					}catch(IndexOutOfBoundsException e) {System.out.println(" Indice non valide !"); }
					break ;
				}
				default:
				{
					System.out.println ( " Erreur ,choisir a nouveau ! ");
				}
				}
				System.out.println();
				System.out.println();
				if ( ! retry && choix != 1 )
				{
					System.out.print (".Choisir un numéro :");
					choix = input.nextInt() ;
				}
			}
			break ;
		}
		case "0" : break ;
		
		default:	{	System.out.println ( " Erreur , il faut choisir 1 ou 2 ou 0 ! ");}
			
		}
		
		} while( !ch.equals("0") ) ;  //&& !ch.equals("1")  && !ch.equals("2")   ) ;
		
		System.out.println ( " Fin  ");
		
		input.close();
		
	}
*/
	
}
