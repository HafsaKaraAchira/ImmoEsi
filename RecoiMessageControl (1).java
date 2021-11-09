package tpGUI.Control;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
import tpGUI.IU.Main;
//import javafx.scene.text.TextFlow;
import tpGUI.Noyau.Bien;

public class RecoiMessageControl 
{

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane listeMessage;
    
    @FXML
    private HBox cas;
    
    
    public ScrollPane RecoiMessage ( ArrayList<String> messageList , ArrayList<Bien> messageBiens , int nbNonLus )
    {
    	listeMessage = new GridPane ( ) ;// .setHgap((messageList).size());
    	scroll = new ScrollPane () ;
    	if ( messageList.isEmpty() )
    	{
    		Label warning = new Label() ; warning.setText( "La liste des messages est vide!" ) ;
    		listeMessage.add(warning, 0, 0);
    	}
    	else
    	{
    		listeMessage.setGridLinesVisible(true);
    		for ( int i = 0 ; i < (messageList).size() ; i ++ )
        	{
        		Bien b = messageBiens.get(i);
        		
        		//cas = new HBox(20) ;
                Label bien = new Label () ;
                Label message = new Label () ;
                Label lus = new Label () ;
                lus.setText("Non Lu");

        		listeMessage.add(bien,0,i);
        		listeMessage.add(message, 1 , i);
        		
        		message.setText (messageList.get(i));
        		bien.setText(b.affich_bien() );
        		
        		if ( nbNonLus > 0 )
        		{
            		listeMessage.add ( lus , 2 , i );
        			nbNonLus -- ;
        		}
        		Main.getAgence().setMessageNonLu(0);
        		//listeMessage.getChildren().add(cas);
        		
        	}

    	}
		scroll.setContent(listeMessage);
		return scroll;
    }

}
