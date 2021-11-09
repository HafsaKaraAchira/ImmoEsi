package tpGUI.Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AffichPropControl {

    @FXML
    private Button retourBouttom;

    @FXML
    private Label propNom;

    @FXML
    private Label propPrenom;

    @FXML
    private Label propEmail;

    @FXML
    private Label propTelephone;

    @FXML
    private Label propAdresse;

    @FXML
    private Button afficherBouttom;

    public void setInfoProp(String Nom, String Prenom, String Email, long Telephone, String Adresse) 
    {
		propNom.setText(Nom) ;
		propPrenom.setText(Prenom) ;
		propEmail.setText(Email);
		propTelephone.setText( ((Long)Telephone).toString() );
		propAdresse.setText(Adresse) ;
	}

	@FXML
    void afficher(ActionEvent event) 
    {

    }

    @FXML
    void retour(ActionEvent event) 
    {

    }

}
