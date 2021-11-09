package tpGUI.Noyau;

import java.util.Scanner;

import tpGUI.Noyau.exceptions_personnalisees.SurfaceHabitableInvalid;

//import java.util.Date;

public class Maison extends Habitable {
	
	private int nbetages ;
	private boolean garage=false ;
	private boolean jardin=false ;
	private boolean piscine=false ;
	private int surfacehabitable ;
	
	
	public Maison(String adresse, Wilaya wilaya, int superficie, Proprietaire prop, Transaction trans, int prix,int nbpieces) 
	{
		super(adresse, wilaya, superficie, prop, trans, prix,nbpieces);
		//this.nbetages = nbetages;
		//this.garage = garage;
		//this.jardin = jardin;
		//this.piscine = piscine ;
		//this.surfacehabitable = surfacehabitable;
	}

	public Maison() {
		// TODO Auto-generated constructor stub
	}

	public int getNbetages() {	return nbetages;}

	public void setNbetages(int nbetages) {	this.nbetages = nbetages;}

	public boolean isGarage() {	return garage;}

	public void setGarage(boolean garage) {	this.garage = garage;}

	public boolean isJardin() {	return jardin;	}

	public void setJardin(boolean jardin) {	this.jardin = jardin;	}

	public boolean isPiscine() {	return piscine;}

	public void setPiscine(boolean piscine) {	this.piscine = piscine;	}

	public int getSurfacehabitable() {	return surfacehabitable;}

	public void setSurfacehabitable(int surfacehabitable) throws SurfaceHabitableInvalid
	{
		if(surfacehabitable>superficie) throw new SurfaceHabitableInvalid() ;
		this.surfacehabitable = surfacehabitable;}

	public void affich_info() 
	{
		System.out.println("	Maison") ;
		super.affich_info();
		System.out.println (". Maison de "+ nbetages + " étage (s)" ) ;
		if ( garage || jardin || piscine )		System.out.println (". Equipee par "+(garage?" un garage , ":"")+(jardin?" un jardin , ":"")+( piscine?" une piscine ":"") ) ;
		System.out.println (". La surface habitable : " + surfacehabitable );
	}
	
	public String affich_bien ()
	{
		String s = "- Maison de "+ nbetages+ " étage(s) situé au wilaya :" +( wilaya != null? wilaya.getNom():"/" ) + " , adresse : " + adresse +"\n" ;
		s = s+"prix final est :"+trans.calcul_prix() +"\n" ;
		s = s+super.affich_bien()+"\n. Date : " + date ;
		return s ;
	}

	public double ajoutPrix ( double prix , Vente v )
	{
		if ( garage || jardin || piscine )		prix += ( 0.5 / 100 ) * ( this.prix ) ;
		return prix ;
	}

	public double ajoutPrix ( double prix , Location loc )
	{
		if ( piscine )	prix += 50000 ;
		return prix ;
	}
	
	public double ajoutPrix ( double prix , Echange e )
	{
		if ( garage || jardin || piscine )		
		prix += ( 0.5 / 100 ) * ( this.prix ) ;
		
		return prix ;
	}
	
	public void modifier ( Scanner input  , Bien b )
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
		
		System.out.println (".Le nombre d'étage :");
		if ( input.nextInt() != 0 )
		{
			this.setNbetages( input.nextInt() );
		}
		else ((Maison)b).setNbetages(nbetages);
		
		System.out.println(".Est ce que il y a un garage :");
		if ( input.nextInt() != 0 )
		{
			boolean garage  = false ;
			if ((input.next()).equals("oui") )
			{
				garage = true ;
			}
			this.setGarage(garage);
		}
		else ((Maison)b).setGarage(garage);
		
		System.out.println(".Est ce que il y a un jardin: ");
		if ( input.nextInt() != 0 )
		{
			boolean jardin = false ;
			if ((input.next()).equals("oui") )	{	jardin = true ;		}
			this.setJardin(jardin);
		}
		else ((Maison)b).setJardin(jardin);
		
		System.out.println(".Est ce que il y a un piscine: ");
		if ( input.nextInt() != 0 )
		{
			boolean piscine = false ;
			if ((input.next()).equals("oui") )	{	piscine = true ;	}
			this.setPiscine(piscine);
		}
		else ((Maison)b).setPiscine(piscine);
		
		System.out.println(".La surface habitable: ");
		if ( input.nextInt() != 0 )
		{
			try {
				this.setSurfacehabitable(input.nextInt());
			} catch (SurfaceHabitableInvalid e) {
				System.out.println("Surface Habitable Invalid !") ;
			}
		} else
			try {	((Maison)b).setSurfacehabitable(surfacehabitable);}
			catch (SurfaceHabitableInvalid e) {	e.printStackTrace();	}
		
	}
	
}
