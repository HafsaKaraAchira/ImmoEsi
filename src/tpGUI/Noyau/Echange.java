package tpGUI.Noyau;


public class Echange extends Transaction
{
	private Wilaya WilayaDeEchanger ;
	
	
	public Echange(Wilaya wilayaDeEchanger) {	WilayaDeEchanger = wilayaDeEchanger;}

	public Echange(Bien bien, Wilaya WilayaDeEchanger) 
	{
		super(bien);
		this.WilayaDeEchanger = WilayaDeEchanger;
	}

	public Wilaya getWilayaDeEchanger() {	return WilayaDeEchanger ; }

	public void setWilayaDeEchanger(Wilaya WilayaDeEchanger) {	this.WilayaDeEchanger = WilayaDeEchanger ; }
	
	
	public double calcul_prix ( ) 
	{	
		double prix = super.calcul_prix()  ;
		prix = bien.ajoutPrix(prix,this) ;
		
		if ( ! bien.getWilaya().equals(WilayaDeEchanger) )		prix += ( 0.25 / 100 ) * ( bien.getPrix() ) ;
		
		return prix ;
	}

}
