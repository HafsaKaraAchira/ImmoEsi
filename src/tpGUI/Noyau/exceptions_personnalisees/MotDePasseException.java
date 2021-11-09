package tpGUI.Noyau.exceptions_personnalisees;

public class MotDePasseException extends Exception 
{
	public void printStackTrace()
	{
		System.out.println ("Ce mot de passe est faux ! Ressayer ?" );
	}

}
