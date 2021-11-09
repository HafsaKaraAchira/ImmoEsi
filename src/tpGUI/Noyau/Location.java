package tpGUI.Noyau;


public class Location extends Transaction
{
	public Location() {}
	
	public Location(Bien bien) {	super(bien); }

	public double calcul_prix ( ) 
	{
		double prix = bien.getPrix() ;
		double prixM2 = bien.getWilaya().getPrix_m2() ;
		int superf = bien.getSuperficie() ;
		double pourcentage = 0 ;
		
		if ( ! (prixM2 < 50000 ) ){	pourcentage = 0.5 ;}
		
		if ( superf < 60 )	pourcentage = pourcentage + 1 ;
		else if ( superf < 150 )	pourcentage = pourcentage + 2 ;
		else if ( superf >= 150 )	pourcentage = pourcentage + 3 ;
		
		prix = prix + pourcentage / 100 * prix ;
		
		//System.out.print(" ( "+pourcentage+"% ) ");
		prix = bien.ajoutPrix(prix,this) ;
			
		return prix ;
	}

}