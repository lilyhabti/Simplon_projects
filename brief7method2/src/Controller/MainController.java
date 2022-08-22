package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import dao.Candidats;
import dao.DaoImp;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class MainController implements Initializable{
	@FXML
	private Label id;
	@FXML
	private Label firstName;
	@FXML
	private Label lastName;
	@FXML
	private Label email;
	@FXML
	private Label adress;
	@FXML
	private Label city;
	@FXML
	private Label country;
	@FXML
	private TextField conId;
	@FXML
	private TextField conFirstName;
	@FXML
	private TextField conLastName;
	@FXML
	private TextField ConEmail;
	@FXML
	private TextField conAdress;
	@FXML
	private TextField conCity;
	@FXML
	private TextField conCountry;
	@FXML
	private TableView<Candidats> tabCondidats;
	@FXML
	private TableColumn<Candidats, Integer> clmnId;
	@FXML
	private TableColumn<Candidats, String> clmnFirstName;
	@FXML
	private TableColumn<Candidats, String> clmLastName;
	@FXML
	private TableColumn<Candidats, String> clmnEmail;
	@FXML
	private TableColumn<Candidats, String> ClmnAdress;
	@FXML
	private TableColumn<Candidats, String> ClmnCity;
	@FXML
	private TableColumn<Candidats, String> clmnCountry;
	@FXML
	private Button btnCreate;
	@FXML
	private Button btnUpdate;
	@FXML
	private Button btnDelete;
	@FXML
	private Label welcome;
	
	DaoImp C = new DaoImp();

	// Event Listener on TableView[#tabCondidats].onMouseClicked
	@FXML
	public void handleMouseAction(MouseEvent event) {
		Candidats candidat = tabCondidats.getSelectionModel().getSelectedItem();
		conId.setText(""+candidat.getId());
		conFirstName.setText(candidat.getFirstName());
		conLastName.setText(candidat.getLastName());
		ConEmail.setText(candidat.getMail());
		conAdress.setText(candidat.getAdress());
		conCity.setText(candidat.getCity());
		conCountry.setText(candidat.getCountry());
	}
	
	public void showCandidats(){
    	ObservableList<Candidats> L = C.CandidatsList();
        
        clmnId.setCellValueFactory(new PropertyValueFactory<Candidats, Integer>("id"));
        clmnFirstName.setCellValueFactory(new PropertyValueFactory<Candidats, String>("firstName"));
        clmLastName.setCellValueFactory(new PropertyValueFactory<Candidats, String>("lastName"));
        clmnEmail.setCellValueFactory(new PropertyValueFactory<Candidats, String>("mail"));
        ClmnAdress.setCellValueFactory(new PropertyValueFactory<Candidats, String>("adress"));
        ClmnCity.setCellValueFactory(new PropertyValueFactory<Candidats, String>("city"));
        clmnCountry.setCellValueFactory(new PropertyValueFactory<Candidats, String>("country"));
        
        tabCondidats.setItems(L);
        
    }
	
	// Event Listener on Button[#btnCreate].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) {
		if(event.getSource() == btnCreate)
        {
        	C.Create(conId.getText(),conFirstName.getText(),conLastName.getText(),ConEmail.getText(),conAdress.getText(),conCity.getText(),conCountry.getText());
    	    showCandidats();
        }
        
	   else if (event.getSource() == btnUpdate)
	   {
		   C.Update(conId.getText(),conFirstName.getText(),conLastName.getText(),ConEmail.getText(),conAdress.getText(),conCity.getText(),conCountry.getText());
		  showCandidats();
	   }
        
        else if(event.getSource() == btnDelete)
        {
        	C.Delete(conId.getText());
    	   showCandidats();
        }
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showCandidats();
	}

}
