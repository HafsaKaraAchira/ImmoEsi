package tpGUI.Noyau;


public abstract class Transaction
{
	protected Bien bien ;
	
	public Transaction(){}
	
	public Transaction(Bien bien){	this.bien = bien;	}

	public Bien getBien() {	return bien;}

	public void setBien(Bien bien) {	this.bien = bien;}
	
	public double calcul_prix ( ) 
	{
		double prix = bien.getPrix() ;
		double prixM2 = bien.getWilaya().getPrix_m2() ;
		double pourcentage = 0 ;
		
		if(prix<5000000)
		{
			if(prixM2<50000) pourcentage=(double)3/100 ;
			else pourcentage=(double)3.5/100 ;
		}
		else if(prix<15000000)
		{
			if(prixM2<50000) pourcentage=(double)2/100 ;
			else pourcentage=(double)2.5/100 ;
		}
		else
		{
			if(prixM2<70000) pourcentage=(double)1/100 ;
			else pourcentage=(double)2/100 ;
		}
		prix = prix + pourcentage*prix ;
		
		//System.out.println("     %   "+pourcentage) ;
		
		return prix ;
	}
	
	public boolean equals ( Transaction trans ) 
	{	return ( (this.getClass().getName()).equals( trans.getClass().getSimpleName() ) ) ;}

}
