package tpGUI.Noyau;

import java.util.Scanner;

public class Terrain extends NonHabitable 
{
	
	public Terrain(String adressse, Wilaya wilaya, int superficie, Proprietaire prop, Transaction trans, int prix,int nbFacade)
	{
		super(adressse, wilaya, superficie, prop, trans, prix, nbFacade);
	}

	public Terrain() {
		// TODO Auto-generated constructor stub
	}

	public void affich_info ( ) 
	{
		System.out.println ("	Terrain");
		super.affich_info();
		System.out.println ("\n. Statut Juridique : "+ ( (statut!=null)? "\nstatut":"Non disponible" ) );
		System.out.println ("\n. Nombre de façade : " + nbfacade );
	}
	
	public String affich_bien ()
	{
		String s = "" ;
		s = s + "- Terrain de "+ nbfacade + " façade situé au wilaya :" +( wilaya != null? wilaya.getNom():"/" ) + " , adresse : " + adresse  ;
		s= s + "prix final est :"+trans.calcul_prix() ;
		s = s +". Date : " + date ;
		return s ;
	}
	
	public double ajoutPrix ( double prix , Vente v )
	{
		if ( nbfacade > 1 )		prix += nbfacade *((double) 0.5 / 100 ) * ( super.prix ) ; 
		return prix ;
	}
	
	public double ajoutPrix ( double prix , Echange e )
	{
		if ( nbfacade > 1 )		prix += nbfacade *( 0.5 / 100 ) * ( super.prix ) ; 
		return prix ;
	}

	public double ajoutPrix(double prix, Location l) {	return prix;}
	
	
	public void modifier ( Scanner input , Bien b )
	{
		System.out.println (".Le statut juridique: ");
		if ( input.nextInt () != 0 )
		{
			super.setStatut(input.nextLine());
		}
		else ((Terrain)b).setStatut(statut);
		
		System.out.println(".Le nombre de façade: ");
		int nb ;
		if ( ( nb=input.nextInt() ) != 0 )
		{
			super.setNbfacade(nb);
		}
		else ((Terrain)b).setNbfacade(nbfacade);
	}
	
}
