package tpGUI.Noyau;

import tpGUI.Noyau.exceptions_personnalisees.TelephoneInvalid;

//import java.util.ArrayList;

public class Proprietaire
{
	private String nom ;
	private String prenom ;
	private String email ;
	private long telephone ;
	private String adresse ;
	private Bien [] listeBiens ;
	
	
	public String getNom() {	return nom; }

	public void setNom(String nom) {	this.nom = nom;	}

	public String getPrenom() {		return prenom;	}

	public void setPrenom(String prenom) {		this.prenom = prenom;	}

	public String getEmail() {		return email;	}

	public void setEmail(String email) {	this.email = email;	}

	public long getTelephone() {		return telephone;	}

	public void setTelephone(long telephone) throws TelephoneInvalid 
	{
		//if(Integer.toString(telephone).length()== 10 && Integer.toString(telephone).charAt(0) == '0' )
		this.telephone = telephone;
		//else throw new TelephoneInvalid() ;
		
	}

	public String getAdresse() {	return adresse;	}

	public void setAdresse(String adresse) {	this.adresse = adresse;	}

	public Bien[] getListeBiens() {		return listeBiens;	}

	public void setListeBiens(Bien[] listeBiens) {	this.listeBiens = listeBiens;	}

	public Proprietaire(String nom, String prenom, String email, long l, String adresse, Bien[] listeBiens)throws TelephoneInvalid
	{
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		if(Long.toString(l).length()== 10 )
			this.telephone = l;
		else throw new TelephoneInvalid() ;
		this.adresse = adresse;
		this.listeBiens = listeBiens;
		if ( listeBiens == null )
		{
			Bien [] bien = {} ;
			this.listeBiens = bien ;
		}
	}
	
	public void affich_prop()
	{
		System.out.println("nom :"+nom) ;
		System.out.println("prenom :"+prenom) ;
		System.out.println("email :"+email) ;
		System.out.println("telephone :"+telephone) ;
		System.out.println("adresse :"+adresse) ;
	}
	
	public void ajoutBien (Bien bien)
	{
		Bien[] biens = new Bien [listeBiens.length+1];
		int i = 0 ;
		for ( i = 0 ; i < listeBiens.length ; i ++ )
		{
			biens[i] = listeBiens[i] ;
		}
		biens [ i ] = bien ;
		setListeBiens(biens);
	}
	
	public void suppBien (Bien bien)
	{
		Bien[] biens = new Bien [listeBiens.length-1];
		int ind = 0 ;
		boolean trouv = false ;
		while ( ind < listeBiens.length && !trouv )
		{
			if ( bien.equals(listeBiens[ind]) )
			{
				trouv = true ;
			}
			else
			{
				biens[ind] = listeBiens[ind] ;
				ind += 1 ;
			}
		}
		if ( trouv )
		{
			for ( int i = ind ; i < biens.length ; i ++ )
			{
				biens[i] = listeBiens[i+1] ;
			}
			setListeBiens(biens);
		}
	}
	
	
	public boolean equals ( Object prop )
	{
		if ((nom+prenom).equals(  ((Proprietaire)prop).nom  +  ((Proprietaire)prop).prenom  ) )
			return ( email.equals(((Proprietaire)prop).email) && adresse.equals(((Proprietaire)prop).adresse) && telephone == ((Proprietaire)prop).telephone ) ;
		else
			return false ;
	}
	
}
