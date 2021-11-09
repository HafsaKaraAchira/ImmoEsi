package tpGUI.Noyau;

//import java.util.Date;

public abstract class Habitable extends Bien {
	
	protected int nbpieces ;
	protected boolean meuble ;
	
	public Habitable(String adressse, Wilaya wilaya, int superficie, Proprietaire prop, Transaction trans, int prix,int nbpieces) 
	{
		super(adressse, wilaya, superficie, prop, trans, prix);
		this.nbpieces = nbpieces;
	}
	
	public Habitable() {}
	
	public void affich_info()
	{
		super.affich_info();
		System.out.println(". Nombre de pieces : "+nbpieces);
		System.out.println("."+(meuble?" Meublé":" Non meublé"));
		
	}
	
	public String affich_bien()
	{
		
		String s = "" ;
		s = "\n"+(meuble?" meublé ":" non meublé ")+" de nombre de pieces : "+nbpieces ;
		return s;
	}

	public int getNbpieces() {	return nbpieces;	}

	public void setNbpieces(int nbpieces) {		this.nbpieces = nbpieces;	}

	public boolean isMeuble() {	return meuble;	}

	public void setMeuble(boolean meuble) {		this.meuble = meuble;	}
	
	
	
	
	
	

}
