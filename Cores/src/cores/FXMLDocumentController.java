package cores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jpc
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Slider slideRed;
    @FXML
    private Slider slideGreen;
    @FXML
    private Slider slideBlue;
    @FXML
    private Label lblRed;
    @FXML
    private Label lblGreen;
    @FXML
    private Label lblBlue;
    @FXML
    private Pane paneTela;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slideRed.valueProperty().addListener (new ChangeListener(){
          public void changed(ObservableValue observable, Object oldValue, Object newValue){
              pintar();
          }
        });
        slideGreen.valueProperty().addListener((Observable, oldValue, newValue)-> pintar());
        slideBlue.valueProperty().addListener((Observable, oldValue, newValue)-> pintar());
    }    
    
    private void pintar(){
        int r= (int)slideRed.getValue();
        int g= (int)slideGreen.getValue();
        int b= (int)slideBlue.getValue();
        
        lblRed.setText(String.format("%03d %02X", r, r));
        lblGreen.setText(String.format("%03d %02X", g, g));
        lblBlue.setText(String.format("%03d %02X", b, b));
        
        String cor= String.format("rgb(%d,%d,%d);", r,g,b);
        paneTela.setStyle("-fx-background-color: " + cor);
    }
}