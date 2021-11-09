package tpGUI.Noyau.exceptions_personnalisees;

public class SurfaceHabitableInvalid extends Exception {
	public void printStackTrace()
	{
			System.out.println("Erreur : Surface Habitable plus grand que la superficie !") ;
	}
}
