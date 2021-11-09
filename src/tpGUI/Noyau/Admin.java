package tpGUI.Noyau;

//import java.util.HashSet;
//import java.util.Set ;
//import java.util.Iterator;
//import java.util.List;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import tpGUI.Noyau.exceptions_personnalisees.BienExistantDeja;
import tpGUI.Noyau.exceptions_personnalisees.BienNonExistant;
import tpGUI.Noyau.exceptions_personnalisees.CritereInvalid;
import tpGUI.Noyau.exceptions_personnalisees.CritereVide;
import tpGUI.Noyau.exceptions_personnalisees.ListeVide;
//import tpGUI.Noyau.exceptions_personnalisees.MotDePasseException;
import tpGUI.Noyau.exceptions_personnalisees.OperationInvalid;
import tpGUI.Noyau.exceptions_personnalisees.SurfaceHabitableInvalid;
import tpGUI.Noyau.exceptions_personnalisees.TelephoneInvalid;



public class Admin 
{
	private String nom ;
	//private String motdepasse ;
	private static Agence agence ;
	
	private ArrayList<String> criteres = new ArrayList<String> () ;


	
	public Admin(String nom , Agence agence) {	this.nom = nom ; Admin.agence = agence;}

	public Agence getAgence() {		return agence;	}

	public void setAgence(Agence agence) {	Admin.agence = agence;	}

	public String getNom() {	return nom;		}

	public void setNom(String nom) {	this.nom = nom;		}

	public ArrayList<String> getCriteres() {	return criteres;	}

	public void setCriteres(ArrayList<String> criteres)  {  this.criteres = criteres;	}
	
	public int hashCode() {	return nom.hashCode() ;}

	public boolean equals(Object obj){	return ( ( nom == ((Admin)obj).getNom() ) ) ;}
	
	
	public void publier ()
	{
		ArrayList<Bien> biens = agence.getListe_biens() ;
		Collections.sort(biens) ;
		
		for ( int i = 0 ; i < biens.size() ; i++)	
			{
				System.out.println();
				System.out.print  ((i+1)+".");
				biens.get(i).affich_bien();
			}
	}
	
	public void inserer ( Bien bien )	throws BienExistantDeja
	{
		ArrayList<Bien> biens = agence.getListe_biens() ;
		if(  biens.indexOf(bien) == -1 )
		{
			if ( ! agence.getListe_wilayas().contains(bien.getWilaya()) )
			{
				(agence.getListe_wilayas()).add(bien.getWilaya());
			}
			if ( ! agence.getListe_props().contains(bien.getProp()) )
			{
				(agence.getListe_props()).add(bien.getProp()) ; 	// ajouter le bien
			}
			(bien.getProp()).ajoutBien(bien);	
			
			biens.add(bien) ;
			
			agence.setListe_biens(biens) ;
		
		}else throw new BienExistantDeja() ;
		
	}

	/*public void modifier ( Bien bien , Bien newbien )	throws BienNonExistant , BienExistantDeja
	{
		ArrayList<Bien> biens = agence.getListe_biens() ;
		int indice = biens.indexOf(bien) ;
		if (  indice != -1  )
		{
			if(biens.contains(newbien)) throw new BienExistantDeja() ;
			
			biens.set(indice,newbien) ;
			agence.setListe_biens(biens);
			
		}
		else	throw new BienNonExistant() ;
	}*/
	
	public void supprimer ( Bien bien )	throws BienNonExistant
	{
		ArrayList<Bien> biens = agence.getListe_biens() ;
		if( !biens.remove(bien) ) 	throw new BienNonExistant() ;
		else 
		{
			bien.getProp().suppBien(bien);
			
			if (bien.getProp().getListeBiens().length == 0)
			{
				HashSet<Proprietaire> p = agence.getListe_props();
				p.remove(bien.getProp()) ;
				agence.setListe_props(p);
			}
		}
		agence.setListe_biens(biens) ;
		
	}
	
	public void archiver ( Bien bien )	throws BienNonExistant
	{
		ArrayList<Bien> biens = agence.getListe_biens() ;
		int i = biens.indexOf(bien) ;
		if( i != -1 ) 
		{
			//bien.setArchive( true ) ;
			ArrayList<Bien> archi = agence.getListe_biens_arch() ;
		
			archi.add(bien) ;
			agence.setListe_biens_arch(archi);
			biens.remove(i) ;
	
			agence.setListe_biens(biens);
		}
		else	throw new  BienNonExistant() ;
	}
	
	public void desarchiver ( Bien bien )	throws BienNonExistant , ListeVide
	{
		ArrayList<Bien> biens = agence.getListe_biens() ;
		ArrayList<Bien> archi = agence.getListe_biens_arch() ;
		if(archi.isEmpty()) throw new ListeVide() ;
		int i = archi.indexOf(bien) ;
		if( i != -1 ) 
		{
			archi.remove(i) ;
			agence.setListe_biens_arch(archi);
			biens.add(bien) ;
			agence.setListe_biens(biens);
		}
		else	throw new BienNonExistant() ;
	}
	
	public void afficher ( Proprietaire prop ) throws ListeVide 
	{
		if(! agence.getListe_props().contains(prop) ) System.out.println( "proprietaire non trouve ! ");
		else 
		{
			Bien[] biens = prop.getListeBiens() ;
			Arrays.sort(biens);
			if(biens.length == 0 )	throw new ListeVide() ; 
			else System.out.println( "/***** le nombre des biens : "+ biens.length+" *****/" );
			for ( int i = 0 ; i < biens.length ; i++){	biens[i].affich_info();}
		}
		
	}
	
	public void afficher ( Bien bien ){	bien.affich_info();}
	
	public static ArrayList<Bien> rechercher ( ArrayList<String> crit ) throws CritereVide
	{
		//if( crit.isEmpty() ) 
		ArrayList<Bien> condidats = new ArrayList<Bien>() ;
		condidats.addAll(agence.getListe_biens()) ;
		int i=0 ;
		while( i<condidats.size() )
		{
			Bien b = condidats.get(i) ;
			if( !crit.get(0).isBlank())
			{
				if( ! ( b.getTrans().getClass().getSimpleName().equalsIgnoreCase( crit.get(0) ) ) )
				{
					condidats.remove(i) ;
					continue ;
				}
			}
			if( !crit.get(1).isBlank())
			{
				if(  b.getWilaya().getNom().equalsIgnoreCase( crit.get(1) ) == false )
				{
					condidats.remove(i) ;
					continue ;
				}
			}
			if( !crit.get(2).isBlank())
			{
				int min = Integer.parseInt(crit.get(2)) ;
				if( ! ( b.getTrans().calcul_prix() >= min ) )
				{
					condidats.remove(i) ;
					continue ;
				}
			}
			if( !crit.get(3).isBlank())
			{
				int max = Integer.parseInt(crit.get(3)) ;
				if( ! ( b.getTrans().calcul_prix() <= max ) )
				{
					condidats.remove(i) ;
					continue ;
				}
			}
			if( !crit.get(4).isBlank())
			{
				if( ! ( b.getClass().getSimpleName().equalsIgnoreCase( crit.get(4) )  ) )
				{
					condidats.remove(i) ;
					continue ;
				}
			}
			if( !crit.get(5).isBlank())
			{
				int sup_min = Integer.parseInt(crit.get(5)) ;
				if( ! ( b.getSuperficie() >= sup_min ) )
				{
					condidats.remove(i) ;
					continue ;
				}
			}
			if( !crit.get(6).isBlank())
			{
				if( b instanceof Habitable )
				{
					int nb_min = Integer.parseInt(crit.get(6)) ;
					if( ! ( ((Habitable) b).getNbpieces() >= nb_min ) )
					{
						condidats.remove(i) ;
						continue ;
					}
				}
			}
			
			i++ ;
		}
		
		if( condidats.size() == agence.getListe_biens().size() ) throw new CritereVide() ;
		
		return condidats ;
		
		
	
	}
	
	public void affich_list_Prop ( ) 
	{
		Proprietaire pro = null ;
		
		HashSet<Proprietaire> props = agence.getListe_props() ;
		Iterator<Proprietaire> it = props.iterator () ;
		while ( it.hasNext())
		{
			pro = it.next() ;
			pro.affich_prop();
			try {
				afficher(pro) ;
			} catch (ListeVide e) {
				e.printStackTrace();
			}
		}
	}
	
	public void envoiMessage (String message , Bien bien )
	{
		ArrayList <String> listeMessage = agence.getListeMessage();
		ArrayList <Bien> bienAssocieMessage = agence.getBienAssocieMessage();
		listeMessage.add(message) ;
		bienAssocieMessage.add(bien);
		agence.setMessageNonLu(agence.getMessageNonLu()+1);
		agence.setListeMessage(listeMessage);
		agence.setBienAssocieMessage(bienAssocieMessage);
	}
	
	public void recoiMessage ()
	{
		int messageNonLu=agence.getMessageNonLu()  ;
		ArrayList <String> listeMessage = agence.getListeMessage();
		ArrayList <Bien> bienAssocieMessage = agence.getBienAssocieMessage();
		int ind = listeMessage.size()-1 ;
		System.out.println(" Il y a "+messageNonLu+" messages non lue :");
		for ( int i = ind ; i > ind-messageNonLu ; i-- )
		{
			System.out.println(".Le bien consernée est:");
			(bienAssocieMessage.get(i)).affich_bien () ;
			System.out.println("Le message : '' "+ listeMessage.get(i)+" '' ");
			System.out.println();
		}
		messageNonLu = 0 ;
	}
	
	public Wilaya rechercheWilaya ( String wil )
	{
		Wilaya wilaya = new Wilaya ( wil , 0 ) ;
		Wilaya wila = null ;
		HashSet<Wilaya> wilayas = agence.getListe_wilayas() ;
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
		HashSet<Proprietaire> props = agence.getListe_props() ;
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
	
	public Proprietaire lectProp (Scanner inter) throws TelephoneInvalid
	{
		//Scanner inter = new Scanner(System.in) ;
		inter.nextLine();
		System.out.println(".Le nom:");
		String nom = inter.nextLine();
		System.out.println(".Le prenom:");
		String prenom = inter.nextLine();
		System.out.println(".L'email:");
		String email = inter.nextLine();
		System.out.println(".Le numéro de téléphone:");
		Long telephone  = inter.nextLong();
		System.out.println(".L'adresse:");
		inter.nextLine();
		String adresse = inter.nextLine();
		
		Bien[] biens = new Bien[0] ;
		
		Proprietaire prop = new Proprietaire ( nom , prenom , email , telephone , adresse , biens ) ;
		
		if ( rechercheProp ( prop ) == null )
		{
			return prop ;
		}
		return ( rechercheProp (prop) ) ;
	}
	
	public Bien lectBien (Scanner input)	throws OperationInvalid
	{
		Bien bien = null ;
		
		input.nextLine() ;
		System.out.println (".Adresse : " );
		String adresse = input.nextLine() ;
		
		System.out.println ( ".Wilaya : " );
		String wil = input.nextLine() ;
		
		Wilaya wilaya = rechercheWilaya(wil) ;

		if ( wilaya == null )
		{
			System.out.println ( " Cette wilaya n'existe pas dans la liste , On va créer un nouveau wilaya "  );
		
			System.out.print("Donner le prix d'un métre carré pour cette wilaya : ");
			wilaya = new Wilaya ( wil , input.nextDouble() );
			
		}
		
		System.out.println (".Superficie : ");
		int superficie = input.nextInt() ;
		
		System.out.println (".Proprietaire : ");
		Proprietaire pro = null ;
		
		try {	pro = lectProp(input);		} 
		catch (TelephoneInvalid e) 	{	System.out.println ("Telephone Invalid !");	}
		
		if ( rechercheProp(pro) == null )
		{
			System.out.println ( " Cette proprietaire n'existe pas dans la liste, " + 
						"On va créer un nouveau propriétaire ."  );
		}
		else
		{
			pro = rechercheProp ( pro ) ;
		}
		
		System.out.println (".Transaction :" );
		System.out.println  (".Choisir un type:");
		System.out.println ( "1. Vente " );
		System.out.println ( "2. Location " );
		System.out.println ( "3. Echange " );
		
		Transaction trans = null ;
		int ch ;
		do {
			ch = input.nextInt() ;
			switch ( ch )
			{
			case 1 :	
			{	
				trans = new Vente ( bien );		
				break;	  
			}
			case 2 :	
			{	
				trans = new Location ( bien ) ; 	  
				break;
			}
			case 3 : 	
			{	
				System.out.println ( "   .Donner la wilaya souhaité pour l'échange :" );  
			
				input.nextLine() ;
				wil = input.nextLine() ;
				Wilaya wila =  rechercheWilaya (wil) ;
				if ( wila == null )
				{
					System.out.println ( " Cette wilaya n'existe pas dans la liste, " + 
								"On va créer un nouveau wilaya "  );
					
					System.out.print("Donner le prix d'un métre carré pour cette wilaya : ");
					wila = new Wilaya ( wil , input.nextDouble() );
				}
				trans = new Echange ( bien , wila ) ;
				
				break;	
			}
			default:{	System.out.println ( " Erreur , il faut choisir 1 ou 2 ou 3 ! ");}
			}
		}while( ch !=1 && ch!= 2 && ch!=3 ) ;
		
		System.out.println (".Le prix :" );
		int prix = input.nextInt();
		
		System.out.println (".Est ce que le prix est négociable : ( écrire oui ou non ) ");
		boolean prixNegociable = false ;
		if ( (input.next()).equals("oui") ){	prixNegociable = true ;}
		
		System.out.println (".Descriptif : "  );
		input.nextLine() ;
		String descriptif = input.nextLine() ;
		
		System.out.println ( ".URLphotos :" );
		
		String uRLphotos = input.nextLine() ;
		
		System.out.println("Qu'elle type de bien vous voulez créer :");
		System.out.println ( "1. Maison " );
		System.out.println ( "2. Appartement " );
		System.out.println ( "3. Terrain " );
		System.out.print   (".Choisir un type:");
		
		int choix = input.nextInt() ;

		do {
		input.nextLine() ;
		switch (choix)
		{
		case 1 :
		{
			
			System.out.println (".Le nombre de pièces : ");
			int nbpieces = input.nextInt() ;
			
			System.out.println (".Est ce que cette maison est meublé : ( écrire oui ou non ) ");
			boolean meuble = false ;
			if ( (input.next()).equals("oui") )
			{
				meuble = true ;
			}
			
			System.out.println (".Le nombre d'étage :");
			int nbetage = input.nextInt() ;
			
			System.out.println(".Est ce que il y a un garage : ( écrire oui ou non ) ");
			boolean garage  = false ;
			if ((input.next()).equals("oui") )
			{
				garage = true ;
			}
			
			System.out.println(".Est ce que il y a un jardin: ( écrire oui ou non ) ");
			boolean jardin = false ;
			if ((input.next()).equals("oui") )	{	jardin = true ;		}
			
			System.out.println(".Est ce que il y a un piscine: ( écrire oui ou non ) ");
			boolean piscine = false ;
			if ((input.next()).equals("oui") )	{	piscine = true ;	}
			
			System.out.println(".La surface habitable: ");
			int surfacehabitable = input.nextInt() ;
			
			bien = new Maison (adresse, wilaya, superficie, pro, trans, prix, nbpieces) ;
			((Maison)bien).setMeuble(meuble);
			((Maison)bien).setNbetages(nbetage);
			((Maison)bien).setGarage(garage);
			((Maison)bien).setPiscine(piscine);
			((Maison)bien).setJardin(jardin);
			try {
				((Maison)bien).setSurfacehabitable(surfacehabitable);
			} catch (SurfaceHabitableInvalid e) {
				System.out.println("Surface Habitable Invalid !") ;
			}
			break ;
		}
		case 2 :
		{
			System.out.println (".Le nombre de pièces : ");
			int nbpieces = input.nextInt() ;
			
			System.out.println (".Est ce que cette maison est meublé : ( écrire oui ou non ) ");
			boolean meuble = false ;
			if ( (input.next()).equals("oui") )		{	meuble = true ;		}
			
			System.out.println(".L'étage : ");
			int etage = input.nextInt() ;
			
			System.out.println(".Est ce que c'est un 1)simplexe ou 2)duplexe: ");
			ch = input.nextInt() ;
			TypeAppartement type = ( ch==1? TypeAppartement.simplexe : TypeAppartement.duplexe ) ;
			
			System.out.println(".Est ce que il y a un acsenseur: ( écrire oui ou non ) ");
			boolean ascenseur = false ;
			if ((input.next()).equals("oui") )	{	ascenseur = true ;		}
		    
			bien = new Appartement (adresse, wilaya, superficie, pro, trans, prix, nbpieces, etage) ;
			
			((Appartement)bien).setMeuble(meuble);
			((Appartement)bien).setType(type);
			((Appartement)bien).setAscenseur(ascenseur);
			break ;
		}
		case 3 :
		{
			System.out.println (".Le statut juridique: ");
			input.nextLine() ;
			String statut = input.nextLine() ;
			
			System.out.println(".Le nombre de façade: ");
			int nbfacade = input.nextInt();
			
			bien = new Terrain (adresse, wilaya, superficie, pro, trans, prix, nbfacade);
			
			((Terrain)bien).setStatut(statut);
			break ;
		}
		default:{	System.out.println ( " Erreur , il faut choisir 1 ou 2 ou 3  ! ");}
		}
		}while( ch !=1 && ch!= 2 && ch!=3 ) ;
		
		
		bien.setDescriptif(descriptif);
		bien.setURLphotos(uRLphotos);
		bien.setPrixNegociable(prixNegociable);
		
		
		return bien ;
		
		
	}
	
	public ArrayList<String> lectCrit(Scanner input) throws CritereInvalid , NumberFormatException
	{
		ArrayList<String> list = new ArrayList<String>() ;
		
		input.nextLine() ;
		//double num = 0 ;
		
		for(int i=0 ; i<criteres.size() ; i++)
		{
			System.out.print(criteres.get(i) +" : ") ;
			
			String s=""  ;
			
			if( i==2 || i== 3 || i== 5 || i== 6 ) 
			{
				s=input.nextLine() ;
				if( ! s.isBlank() )		 Double.parseDouble(s) ;
			}	 
			else 
			{
				//if(i==4) input.nextLine() ;
				s=input.nextLine() ;
				if(!s.isBlank())
				{
				if(i==0 && !s.equalsIgnoreCase("vente") && !s.equalsIgnoreCase("location") && !s.equalsIgnoreCase("echange") ) throw new CritereInvalid() ;
				if(i==4 && !s.equalsIgnoreCase("appartement") && !s.equalsIgnoreCase("maison") && !s.equalsIgnoreCase("terrain") ) throw new CritereInvalid() ;
				}
			}
			list.add(s) ;
			if(( i == 3 ) && !list.get(2).isBlank() && !list.get(3).isBlank() )
			{
				if(  ( Double.parseDouble( list.get(2) ) > Double.parseDouble( list.get(3) ) )  ) throw new CritereInvalid(); 
			}
		}
		
		
		return list ;
	}
	
	public void modifier ( Scanner input , int indice ) 	throws BienNonExistant , BienExistantDeja , IndexOutOfBoundsException
	{
		Bien bien = agence.getListe_biens().get(indice) ;
		Bien b = null  ;
		switch(bien.getClass().getSimpleName())
		{
			case "Appartement" : b= new Appartement() ;
			case "Maison" : b= new Maison() ;
			case "Terrain" : b= new Terrain() ;
		}
		//int indice=agence.getListe_biens().indexOf(b) ;
		if( ! agence.getListe_biens().contains(bien) ) throw new BienNonExistant() ;
		
		System.out.println ( " Si vous ne voulez changer cette attribut tapez 0 " 
				+ "sinon tapez un autre nombre.") ;
		
		System.out.println (".Adresse : " );
		if ( input.nextInt() != 0 )
		{
			b.setAdresse(input.next());
		}
		else b.setAdresse(bien.getAdresse());
		
		System.out.println ( ".Wilaya : " );
		if ( input.nextInt() != 0 )
		{
			String wil = input.next () ;
			Wilaya wilaya = rechercheWilaya (wil)  ;
			if ( wilaya == null )
			{
				System.out.println ( " Cette wilaya n'existe pas dans la liste, " + 
							"On va créer un nouveau wilaya "  );
				//if ( (input.next()).equals("oui") )	{	}
				System.out.print("Donner le prix d'un mètre carré pour cette wilaya : ");
				wilaya = new Wilaya ( wil , input.nextDouble() );
				(agence.getListe_wilayas()).add(wilaya);  // ajouter la wilaya
			}
			b.setWilaya(wilaya);
		}
		else b.setWilaya(bien.getWilaya());
		
		System.out.println (".Superficie : ");
		if ( input.nextInt() != 0 )
		{
			b.setSuperficie(input.nextInt() );
		}
		else b.setSuperficie(bien.getSuperficie());
		
		System.out.println (".Proprietaire : ");
		if ( input.nextInt() != 0 )
		{
			Proprietaire pro = null ;
			try {	pro = lectProp(input) ;	} 
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
		
		if ( ( ch=input.nextInt() ) != 0 )
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
				String wil = input.next () ;
				Wilaya wila = rechercheWilaya(wil) ;
				if ( wila == null )
				{
					System.out.println ( " Cette wilaya n'existe pas dans la liste, " + 
							"On va créer un nouveau wilaya "  );
					System.out.print("Donner le prix d'un métre carré pour cette wilaya : ");
					wila = new Wilaya ( wil , input.nextDouble() );
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
		if ( (ch=input.nextInt()) != 0 )
		{
			b.setPrix(ch);
		}
		else b.setPrix(bien.getPrix());
		
		System.out.println (".Est ce que le prix est négociable : ( écrire oui ou non ) ");
		if ( input.nextInt() != 0 )
		{
			boolean prixNegociable = false ;
			if ( (input.next()).equals("oui") )
			{
				prixNegociable = true ;
			}
			b.setPrixNegociable(prixNegociable);
		}
		else b.setPrixNegociable(bien.isPrixNegociable());
		
		System.out.println (".Descriptif : "  );
		if ( input.nextInt() != 0 )
		{
			b.setDescriptif(input.next());
		}
		else b.setDescriptif(bien.getDescriptif());
		
		System.out.println ( ".URLphotos :" );
		if ( input.nextInt() != 0 )
		{
			b.setURLphotos(input.next());
		}
		else b.setURLphotos(bien.getURLphotos());
		
		b.modifier( input , b );
		
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

	public void afficherbienArch() {
		
		ArrayList<Bien> biens = agence.getListe_biens_arch() ;
		Collections.sort(biens) ;
		if(biens.isEmpty()) System.out.println (" Pas de bien Archive ! ");
		for ( int i = 0 ; i < biens.size() ; i++)	
			{
				System.out.println();
				System.out.print  ((i+1)+".");
				biens.get(i).affich_bien();
			}
		
	}
	
	
}