package tpGUI.Noyau;

import java.util.Date;
import java.util.Scanner;

public abstract class Bien implements Comparable<Bien> 
{
	protected String adresse ;
	protected Wilaya wilaya ;
	protected int superficie ;
	protected Proprietaire prop ;
	protected Transaction trans ;
	protected int prix ;
	protected boolean prixNegociable ;
	protected String descriptif ;
	protected Date date ;
	protected String URLphotos ;
	//protected boolean archive ;
	
	
	public Bien(String adresse, Wilaya wilaya, int superficie, Proprietaire prop, Transaction trans, int prix) 
	{
		this.adresse = adresse;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.prop = prop;
		this.trans = trans;
		this.trans.setBien(this);
		this.prix = prix;
		this.date = new Date();
		
	}
	
	public Bien() {}

	public String getAdresse() {	return adresse; }
	
	public void setAdresse(String adresse) {	this.adresse = adresse;}
	
	public Wilaya getWilaya() {	return wilaya;}
	
	public void setWilaya(Wilaya wilaya) {	this.wilaya = wilaya;}
	
	public int getSuperficie() {	return superficie;}
	
	public void setSuperficie(int superficie) {	this.superficie = superficie;}
	
	public Proprietaire getProp() {		return prop;	}
	
	public void setProp(Proprietaire prop) {	this.prop = prop;	}
	
	public Transaction getTrans() {	return trans;}
	
	public void setTrans(Transaction trans) {	this.trans = trans;}
	
	public int getPrix() {	return prix;}
	
	public void setPrix(int prix) {	this.prix = prix;}
	
	public boolean isPrixNegociable() {	return prixNegociable;}
	
	public void setPrixNegociable(boolean prixNegociable) {	this.prixNegociable = prixNegociable;}
	
	public String getDescriptif() {	return descriptif;}
	
	public void setDescriptif(String descriptif) {	this.descriptif = descriptif;}
	
	public Date getDate() {	return date;}
	
	public void setDate(Date date) {	this.date = date;}
	
	public String getURLphotos() {	return URLphotos;}
	
	public void setURLphotos(String uRLphotos) {	URLphotos = uRLphotos;}
	
	//public boolean isArchive() {	return archive;}
	
	//public void setArchive(boolean archive) {	this.archive = archive;}
	
	public void affich_info ( )
	{
		System.out.println (". Adresse : " + adresse );
		if ( wilaya != null ) {System.out.println (". Wilaya : " + wilaya.getNom());}
		System.out.println (". Superficie : " + superficie);
		if ( prop != null ) {System.out.println (". Proprietaire : " + prop.getNom() + " " + prop.getPrenom() );}
		if ( trans != null ) {System.out.println (". Transaction :" + trans.getClass().getSimpleName() );}
		System.out.println (". Le prix est "+ prix + " DA " );
		System.out.println (". Le prix est "+ ( prixNegociable?"Negociable":"Non negociable"));
		if ( descriptif != null ) { System.out.println (". Descriptif : " + descriptif ); }
		System.out.println (". Date : " + date );
		if ( URLphotos != null ) { System.out.println (". URLphotos :" + URLphotos); }
		//System.out.println ("- Immobilier situé à :" + adresse + ",wilaya :"+ wilaya );
	}
	
	public abstract String affich_bien ();
	
	public abstract  double ajoutPrix ( double prix , Vente v ) ;
	public abstract  double ajoutPrix ( double prix , Location l ) ;
	public abstract  double ajoutPrix ( double prix , Echange e ) ;
	
	public int compareTo (Bien bien){	return date.compareTo(bien.date) ;	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((URLphotos == null) ? 0 : URLphotos.hashCode());
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((descriptif == null) ? 0 : descriptif.hashCode());
		result = prime * result + prix;
		result = prime * result + (prixNegociable ? 1231 : 1237);
		result = prime * result + ((prop == null) ? 0 : prop.hashCode());
		result = prime * result + superficie;
		result = prime * result + ((trans == null) ? 0 : trans.hashCode());
		result = prime * result + ((wilaya == null) ? 0 : wilaya.hashCode());
		return result;
	}


	public boolean equals(Object obj) 
	{
		if (this == obj)	return true;
		if (obj == null)	return false;
		if (getClass() != obj.getClass())	return false;
		
		Bien other = (Bien) obj;
		if (URLphotos == null) {	if (other.URLphotos != null)	return false;}
		else if (!URLphotos.equals(other.URLphotos))	return false;
		if (adresse == null) {	if (other.adresse != null)	return false;}
		else if (!adresse.equals(other.adresse))	return false;
		if (date == null) {		if (other.date != null)	return false;}
		else if (!date.equals(other.date))		return false;
		if (descriptif == null) {	if (other.descriptif != null)	return false;}
		else if (!descriptif.equals(other.descriptif))	return false;
		if (prix != other.prix)		return false;
		if (prixNegociable != other.prixNegociable)		return false;
		if (prop == null) {		if (other.prop != null)		return false;}
		else if (!prop.equals(other.prop))	return false;
		if (superficie != other.superficie)	return false;
		if (trans == null) {	if (other.trans != null)	return false;}
		else if (!trans.equals(other.trans))	return false;
		if (wilaya == null) {	if (other.wilaya != null)	return false;}
		else if (!wilaya.equals(other.wilaya))	return false;
		
		return true;
	}

	public abstract void modifier ( Scanner input, Bien b ) ;
	
}
