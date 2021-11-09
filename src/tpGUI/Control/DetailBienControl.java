package tpGUI.Control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tpGUI.Noyau.Appartement;
import tpGUI.Noyau.Bien;
import tpGUI.Noyau.Maison;
import tpGUI.Noyau.Terrain;

public class DetailBienControl 
{

	    @FXML
	    private GridPane gridPane;

	    @FXML
	    private Label bien;

	    @FXML
	    private Label adresse;

	    @FXML
	    private Label wilaya;

	    @FXML
	    private Label superficie;

	    @FXML
	    private Label proprietaire;

	    @FXML
	    private Label transaction;

	    @FXML
	    private Label prix;

	    @FXML
	    private Label prixNegociable;

	    @FXML
	    private Label descriptif;

	    @FXML
	    private Label date;

	    @FXML
	    private Label uRLphotos;

	    @FXML
	    private Label case01;

	    @FXML
	    private Label case02;

	    @FXML
	    private Label case03;

	    @FXML
	    private Label case04;

	    @FXML
	    private Label case05;

	    @FXML
	    private Label case06;

	    @FXML
	    private Label case07;

	    @FXML
	    private Label case11;

	    @FXML
	    private Label case16;

	    @FXML
	    private Label case15;

	    @FXML
	    private Label case14;

	    @FXML
	    private Label case13;

	    @FXML
	    private Label case12;

	    @FXML
	    private Label case17;

	

    public void TypeBien( Bien b )
    {
    	adresse.setText(b.getAdresse());
    	wilaya.setText(b.getWilaya().getNom());
    	superficie.setText(Integer.toString(b.getSuperficie()));
    	proprietaire.setText(b.getProp().getNom());
    	transaction.setText(((b.getTrans().getClass().getName().substring(12))));
    	prix.setText(Double.toString(b.getPrix())) ;
    	prixNegociable.setText((b.isPrixNegociable())?"est négociable":"n'est pas négociable") ;
    	descriptif.setText(b.getDescriptif());
    	date.setText(b.getDate().toString());
    	uRLphotos.setText(b.getURLphotos());
    	
    	switch (( b.getClass().getName()) )
    	{
    	case("tpGUI.Noyau.Maison"):
    	{
    		Maison m = ((Maison)b);
        	bien.setText("Maison");
        	case01.setText("Le nombre de pièces:");
        	case02.setText("La maison est :");
        	case03.setText("Le nombre d'étages:");
        	case04.setText("Le garage:");
        	case05.setText("Le jardin");
        	case06.setText("La piscine:");
        	case07.setText("La surface habitable:");
        	
        	case11.setText(Integer.toString(m.getNbpieces()));
        	case12.setText((m.isMeuble())?"Meublé":"Non meublé");
        	case13.setText(Integer.toString(m.getNbetages()));
        	case14.setText((m.isGarage()?"exite":"n'existe pas"));
        	case15.setText((m.isJardin()?"exite":"n'existe pas"));
        	case16.setText((m.isPiscine()?"exite":"n'existe pas"));
        	case17.setText(Integer.toString(m.getSurfacehabitable()));
        	
        	break;
    	}
    	case ("tpGUI.Noyau.Appartement"):
    	{
    		Appartement a = ((Appartement)b);
        	bien.setText("Appartement");
        	case01.setText("Le nombre de pièces:");
        	case02.setText("L'appartement est :");
        	case03.setText("L'étages:");
        	case04.setText("L'ascenseur:");
        	
        	case11.setText(Integer.toString(a.getNbpieces()));
        	case12.setText((a.isMeuble())?"Meublé":"Non meublé");
        	case13.setText(Integer.toString(a.getEtage()));
        	case14.setText((a.isAscenseur()?"exite":"n'existe pas"));
        	
        	break ;
    	}
    	case ("tpGUI.Noyau.Terrain"):
    	{
    		Terrain a = ((Terrain)b);
        	bien.setText("Terrain");
        	case01.setText("Le nombre de facade:");
        	case02.setText("Le statut juredique :");
        	
        	case11.setText(Integer.toString(a.getNbfacade()));
        	case12.setText(a.getStatut());
        	
        	break ;
    	}
    	}
    	
    	
    	
    }
    public void TypeBien( Appartement b )
    {
    	
    }
    public void TypeBien( Terrain b )
    {
    }
    
    /*
     * 
     */
    
}
