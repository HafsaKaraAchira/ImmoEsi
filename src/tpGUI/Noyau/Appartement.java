package tpGUI.Noyau;

import java.util.Scanner;

//import java.util.Date;

public class Appartement extends Habitable {

	private int etage ;
	private TypeAppartement type ;
	private boolean ascenseur = false ;

	public Appartement(String adressse, Wilaya wilaya, int superficie, Proprietaire prop, Transaction trans, int prix,int nbpieces, int etage) 
	{
		super(adressse, wilaya, superficie, prop, trans, prix, nbpieces);
		this.etage = etage;
		//this.ascenseur = ascenseur ;
	}

	public Appartement() {
		// TODO Auto-generated constructor stub
	}

	public int getEtage() { return etage; }

	public void setEtage(int etage) { this.etage = etage; }

	public TypeAppartement getType() { return type; }

	public void setType(TypeAppartement type) { this.type = type; }
	
	public boolean isAscenseur() {	return ascenseur;	}

	public void setAscenseur(boolean ascenseur) {	this.ascenseur = ascenseur;	}

	public void affich_info() 
	{
		System.out.println ("	Appartement ");
		super.affich_info();
		System.out.println (". Appartement "+ type ) ;
		System.out.println (". Au "+ etage + ( ( etage == 1 )? "er":"eme") +" étage" );
		System.out.println ( (ascenseur?". Contient un ascenceur ":". Ne contient pas un ascenceur" ));
	}
	
	public String affich_bien ()
	{
		String s="" ;
		s = s + "\n- Appartement "+ ((type != null)?"type":"" ) + " F"+ nbpieces + " au "+ etage + ( ( etage == 1 )? "er":"eme") + " étage situé au wilaya :" +( wilaya != null? wilaya.getNom():"/" ) + " , adresse : " + adresse ;
		s = s + "\n prix final est :"+trans.calcul_prix() ;
		s = s + super.affich_bien();
		s = s + "\n. Date : " + date ;
		return s ;
	}
	
	public double ajoutPrix ( double prix , Vente v ) 
	{
		if ( etage >= 0  && etage <= 2 )	prix += 50000 ;
		return prix ;
	}
	public double ajoutPrix ( double prix , Location l )
	{
		if ( etage >= 0  && etage <= 2 )	prix += 5000 ;
		if ( etage >= 6 && !ascenseur )	prix = prix- 500*superficie ;
		return prix ;
	}
	public double ajoutPrix ( double prix , Echange e )
	{
		if ( etage >= 0  && etage <= 2 )	prix += 50000 ;
		return prix ;
	}

	public void modifier ( Scanner input, Bien b )
	{
		
		System.out.println (".Le nombre de pièces : ");
		int nb ;
		if ( (nb=input.nextInt()) != 0 )
		{
			super.setNbpieces(nb);
		}
		else ((Appartement)b).setNbpieces(nbpieces);
		
		
		System.out.println (".Est ce que cette appartement est meublé : ");
		if ( input.nextInt() != 0 )
		{
			boolean meuble = false ;
			if ( (input.next()).equals("oui") )		{	meuble = true ;		}
			super.setMeuble(meuble);
		}
		else ((Appartement)b).setMeuble(meuble);
		
		System.out.println(".L'étage : ");
		int e ;
		if ( (e=input.nextInt()) != 0 )
		{
			setEtage(e);
		}
		else ((Appartement)b).setEtage(etage);
		
		System.out.println(".Est ce que c'est un 1)simplexe ou 2)duplexe: ");
		if ( input.nextInt() != 0 )
		{
			setType ( input.nextInt()==1? TypeAppartement.simplexe : TypeAppartement.duplexe ) ;
		}
		else ((Appartement)b).setType(type);
		
		
		System.out.println(".Est ce que il y a un acsenseur:");
		if ( input.nextInt() != 0 )
		{
			boolean ascenseur = false ;
			if ((input.next()).equals("oui") )	{	ascenseur = true ;		}
			setAscenseur (ascenseur) ;
		}
		else ((Appartement)b).setAscenseur(ascenseur);
		
	}
	
}
