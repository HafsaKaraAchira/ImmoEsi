package tpGUI.Noyau;


public class Vente extends Transaction
{
	public Vente() {}
	
	public Vente(Bien bien) {	super(bien);	}

	public double calcul_prix() 
	{
		double pr = super.calcul_prix()  ;
		
		pr = bien.ajoutPrix(pr,this) ;	
		return pr;
	}

}
