package tpGUI.Control;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//import javafx.scene.text.TextFlow;
import tpGUI.Noyau.Bien;

public class RecoiMessageControl 
{

	@FXML
    private ScrollPane scroll;
	
    @FXML
    private VBox listeMessage;
    
    @FXML
    private HBox cas;
    
    
    public RecoiMessageControl ( ArrayList<String> messageList , ArrayList<Bien> messageBiens , int nbNonLus )
    {
    	listeMessage = new VBox () ;
    	for ( int i = 0 ; i < (messageList).size() ; i ++ )
    	{
    		Bien b = messageBiens.get(i);
    		
    		cas = new HBox() ;
            Label bien = new Label () ;
            Label message = new Label () ;
            Label lus = new Label () ;
            lus.setText("Non Lu");

    		cas.getChildren().add(bien);
    		cas.getChildren().add(message);
    		
    		message.setText (messageList.get(i));
    		bien.setText(b.toString());
    		if ( nbNonLus > 0 )
    		{
        		cas.getChildren().add(lus);
    			nbNonLus -- ;
    		}
    		ObservableList<Node> child =  listeMessage.getChildren() ;
    		child.add(cas);
    		
    	}

		scroll.setContent(listeMessage);
    }

}
