package tpGUI.Noyau;

//import java.util.Date;

public abstract class NonHabitable extends Bien {
	
	protected String statut ;
	protected int nbfacade ;

	public NonHabitable(String adressse, Wilaya wilaya, int superficie, Proprietaire prop, Transaction trans, int prix,int nbfacade) 
	{
		super(adressse, wilaya, superficie, prop, trans, prix);
		//this.statut = statut;
		this.nbfacade = nbfacade;
	}
	public NonHabitable() {} 
	
	public String getStatut() {	return statut;	}

	public void setStatut(String statut) {	this.statut = statut;	}

	public int getNbfacade() {	return nbfacade;	}

	public void setNbfacade(int nbfacade) {	this.nbfacade = nbfacade;	}


	
	
}
