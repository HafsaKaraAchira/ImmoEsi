package tpGUI.Noyau.exceptions_personnalisees;

public class CritereVide extends Exception {
	public void printStackTrace()
	{
		System.out.println("Valeures des Criteres vides , inserer au moins une ! ") ;
	}

}
