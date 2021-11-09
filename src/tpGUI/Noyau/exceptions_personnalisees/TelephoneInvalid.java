package tpGUI.Noyau.exceptions_personnalisees;

public class TelephoneInvalid extends Exception {
	public void printStackTrace()
	{
			System.out.println("Erreur : Telephone Invalid  , nombre de chiffre doit etre 10 !") ;
	}

}
