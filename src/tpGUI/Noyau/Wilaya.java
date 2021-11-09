package tpGUI.Noyau;


public class Wilaya 
{
	private String nom ;
	private double prix_m2 ;
	
	public Wilaya(String nom, double prix_m2) 
	{
		this.nom = nom;
		this.prix_m2 = prix_m2;
	}

	public String getNom() {	return nom;}

	public void setNom(String nom) {	this.nom = nom;}

	public double getPrix_m2() {	return prix_m2;}

	public void setPrix_m2(double prix_m2) {	this.prix_m2 = prix_m2;}
	
	public boolean equals ( Object wilaya){		return  nom.equals( ((Wilaya)wilaya).nom ) ;	}

}
