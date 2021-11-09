package tpGUI.Control;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tpGUI.IU.AcceuilAdmin;
import tpGUI.IU.Main;
import tpGUI.IU.Menu;
import tpGUI.Noyau.Admin;
import tpGUI.Noyau.exceptions_personnalisees.MotDePasseException;

public class AdminPasseControl
{
	AcceuilAdmin view ;
	
	Admin ad ;

	public Admin getAd() {
		return ad;
	}

	public void setAd(Admin ad) {
		this.ad = ad;
	}

	private HashMap<Admin,String> listeAdmins = Main.getAgence().getAdmins() ;

	public static Boolean motDePasse ( String mot ,  HashMap.Entry< Admin, String > admin   ) throws MotDePasseException
	{
		Boolean acces = false ;
		if ( mot.equals(admin.getValue()) )	acces = true ;
		else throw new MotDePasseException () ;
		return acces ;
	}
	
	@FXML
    private Label remarque;

    @FXML
    private Button annulBoutton;

    @FXML
    private Button validBoutton;

    @FXML
    private TextField nomDadmin;

    @FXML
    private PasswordField motDePasse;

    @FXML
    void annuler(ActionEvent event) 
    {
    	view.close();

    }

    public void setView(AcceuilAdmin view) {
		this.view = view;
	}

	@FXML
    void valider(ActionEvent event) 
    {

    	Boolean acces = false ;
		Boolean trouv = false ;
		//Boolean sortir = false ;
		String passe ;
		Admin admin  ;
		
		Set< HashMap.Entry< Admin, String > > entryAdmin =  listeAdmins.entrySet() ;
		
		 HashMap.Entry< Admin, String > ad = null;
		
			 passe = nomDadmin.getText() ;
			 Iterator < HashMap.Entry< Admin, String > >it = entryAdmin.iterator();
			 while (! trouv && it.hasNext())
			 {
				 //System.out.println ( it.next() ) ;
				 ad = it.next();
				 admin = ad.getKey() ;
				 if ( passe.equals(admin.getNom()) )	
				 {
					 passe = motDePasse.getText();
						try {
							acces = motDePasse (passe, ad) ;
							} 
						catch (MotDePasseException e) 
						{
							e.printStackTrace() ;
							remarque.setText(" Le mot de passe est faux ! Reéssayer .") ;
						}
					 trouv = true ; 
					 this.ad = admin  ;
					 
				}
			}
			if ( ! trouv ) 
			{
				remarque.setText("Le nom que vous avez inserer n'existe pas! Réessayer ");
			}
			
		
		if ( acces )
		{
			view.close();
			try 
			{         
	    		 Menu menuStage = new Menu ();
	    		 menuStage.AdminMenu(event) ;
	    		 menuStage.setAd(this.ad);
				 menuStage.show();  
				 
			 }
		     catch(Exception e) {	 e.printStackTrace();    } 
		}
		
    }

    //public AdminPasseControl(HashMap<Admin, String> listeAdmins) {
		//super();
		//this.listeAdmins = listeAdmins;
	//}

	//public void setView(Main main) {
		// TODO Auto-generated method stub
		
}

    

