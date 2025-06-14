package application;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;

/**
 *  @author znok, Samuel Pereira
 * 
 * 
 */


public class dashboradControl implements Initializable{

	@FXML
	private ComboBox<?> active;

	@FXML
	private AnchorPane addCriminal;

	@FXML
	private Button addCriminal_AddBtn;

	@FXML
	private ComboBox<Boolean> addCriminal_AorE;

	@FXML
	private Button addCriminal_ClearBtn;

	@FXML
	private Button addCriminal_DeleteBtn;

	@FXML
	private TextField addCriminal_Due;

	@FXML
	private ImageView addCriminal_Image;

	@FXML
	private Button addCriminal_ImportBtn;

	@FXML
	private Button addCriminal_UpdateBtn;

	@FXML
	private Button addCriminal_btn;

	@FXML
	private TableColumn<criminalData, String> addCriminal_col_Arrested;

	@FXML
	private TableColumn<criminalData, String> addCriminal_col_Due;

	@FXML
	private TableColumn<criminalData, String> addCriminal_col_arrestTime;

	@FXML
	private TableColumn<criminalData, String> addCriminal_col_criminalID;

	@FXML
	private TableColumn<criminalData, String> addCriminal_col_firstName;

	@FXML
	private TableColumn<criminalData, String> addCriminal_col_gender;

	@FXML
	private TableColumn<criminalData, String> addCriminal_col_lastName;

	@FXML
	private TableColumn<criminalData, String> addCriminal_col_setArrest;

	@FXML
	private TextField addCriminal_firstName;

	@FXML
	private ComboBox<String> addCriminal_gender;

	@FXML
	private TextField addCriminal_lastName;

	@FXML
	private TextField addCriminal_search;

	@FXML
	private ComboBox<Boolean> addCriminal_setArrest;

	@FXML
	private TableView<criminalData> addCriminal_tableView;

	@FXML
	private AnchorPane addPolice;

	@FXML
	private ImageView addPolice_Image;

	@FXML
	private TableView<?> addPolice_TableView;

	@FXML
	private TextField addPolice_Username;

	@FXML
	private Button addPolice_addBtn;

	@FXML
	private Button addPolice_btn;

	@FXML
	private Button addPolice_clearBtn;

	@FXML
	private TableColumn<?, ?> addPolice_col_Username;

	@FXML
	private TableColumn<?, ?> addPolice_col_active;

	@FXML
	private TableColumn<?, ?> addPolice_col_firstName;

	@FXML
	private TableColumn<?, ?> addPolice_col_gender;

	@FXML
	private TableColumn<?, ?> addPolice_col_lastName;

	@FXML
	private TableColumn<?, ?> addPolice_col_peopleArrested;

	@FXML
	private TableColumn<?, ?> addPolice_col_policeID;

	@FXML
	private TableColumn<?, ?> addPolice_col_started;

	@FXML
	private TableColumn<?, ?> addPolice_col_timeWorked;

	@FXML
	private Button addPolice_deleteBtn;

	@FXML
	private TextField addPolice_firstName;

	@FXML
	private ComboBox<?> addPolice_gender;

	@FXML
	private Button addPolice_importBtn;

	@FXML
	private TextField addPolice_lastName;

	@FXML
	private TextField addPolice_search;

	@FXML
	private Button addPolice_updateBtn;

	@FXML
	private Button close;

	@FXML
	private DatePicker criminalBirthDate;

	@FXML
	private Button criminal_Clear;

	@FXML
	private Label criminal_Due;

	@FXML
	private ComboBox<?> criminal_Gender;

	@FXML
	private TextField criminal_ID;

	@FXML
	private TableView<?> criminal_TableView;

	@FXML
	private DatePicker criminal_arrestTime;

	@FXML
	private ComboBox<?> criminal_arrested;

	@FXML
	private Label criminal_firstName;

	@FXML
	private Label criminal_lastName;

	@FXML
	private ComboBox<?> criminal_setArrest;

	@FXML
	private Button criminal_update;

	@FXML
	private AnchorPane gerenc_crim;

	@FXML
	private AnchorPane gerenc_police;

	@FXML
	private TableColumn<?, ?> gerenciarC_col_arrestTime;

	@FXML
	private TableColumn<?, ?> gerenciarC_col_birthDate;

	@FXML
	private TableColumn<?, ?> gerenciarC_col_criminalId;

	@FXML
	private TableColumn<?, ?> gerenciarC_col_due;

	@FXML
	private TableColumn<?, ?> gerenciarC_col_firstName;

	@FXML
	private TableColumn<?, ?> gerenciarC_col_gender;

	@FXML
	private TableColumn<?, ?> gerenciarC_col_lastName;

	@FXML
	private TableColumn<?, ?> gerenciarC_col_setToArrest;

	@FXML
	private Button gerenciarCrim_btn;

	@FXML
	private TableColumn<?, ?> gerenciarD_col_Username;

	@FXML
	private TableColumn<?, ?> gerenciarD_col_active;

	@FXML
	private TableColumn<?, ?> gerenciarD_col_firstName;

	@FXML
	private TableColumn<?, ?> gerenciarD_col_gender;

	@FXML
	private TableColumn<?, ?> gerenciarD_col_lastName;

	@FXML
	private TableColumn<?, ?> gerenciarD_col_policeID;

	@FXML
	private TableColumn<?, ?> gerenciarD_col_startedOn;

	@FXML
	private Button gerenciarPol_btn;

	@FXML
	private Button home_btn;

	@FXML
	private BarChart<?, ?> home_chart;

	@FXML
	private AnchorPane home_page;

	@FXML
	private Label home_totalCriminal;

	@FXML
	private Label home_totalPolice;

	@FXML
	private Label home_totalWorked;

	@FXML
	private Button logout;

	@FXML
	private AnchorPane main_form;

	@FXML
	private Button minimise;

	@FXML
	private TextField policeId;

	@FXML
	private Button police_clear;

	@FXML
	private Label police_firstName;

	@FXML
	private Label police_gender;

	@FXML
	private Label police_lastName;

	@FXML
	private TableView<?> police_tableView;

	@FXML
	private Button police_update;

	@FXML
	private TextField police_username;
	
	@FXML
	private TextField addCriminal_criminalID;

	@FXML
    private Label username;
	
	private Image image;
	
	private Connection connect;
	private Statement statement;
	private PreparedStatement prepare;
	private ResultSet result;

	public AlertMessage alert  = new AlertMessage();
	
	private String[] arrested = {"Yes", "No"};
	private String[] setArrest = {"Yes", "No"};
	private String[] listGender = {"Male", "Female", "Others"};

	public ObservableList<criminalData> addCriminalData;

	private double x = 0, y = 0;

	private void defaultNav() {
        home_page.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
    }

	private void setButtonStyle(Button button, String style) {
		button.setStyle("-fx-background-color: " + style + ";");
	}
	
	public void addCriminalArrested() {
		List <String> listA = new ArrayList<>();
		
		for(String data: arrested) {
			listA.add(data);
		}
		ObservableList listData = FXCollections.observableArrayList(listA);
		addCriminal_AorE.setItems(listData);
	}
	
	public void addCriminalsetArrest() {
		List <String> listB = new ArrayList<>();
		
		for(String data: setArrest) {
			listB.add(data);
		}
		ObservableList listData = FXCollections.observableArrayList(listB);
		addCriminal_setArrest.setItems(listData);
	}
	
	public void addCriminalGenderList() {
		List <String> listG = new ArrayList<>();
		
		for(String data: listGender) {
			listG.add(data);
		}
		ObservableList listData = FXCollections.observableArrayList(listG);
		addCriminal_gender.setItems(listData);
	}

	public void addCriminalADD() {
	
		String sql = "INSERT INTO criminal " 
					+ "(criminalId, firstName, lastName, gender, due, image, arresttime, arrested, setArrest)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		String check = "SELECT criminalID FROM criminal WHERE criminalID = '" + addCriminal_criminalID.getText()
						+ "'";

		String uri = getData.path;
		uri = uri.replace("\\", "\\\\");

		LocalDate birthDate = criminalBirthDate.getValue();
		java.sql.Date sqlDate = java.sql.Date.valueOf(birthDate);			
		
		connect = Database.connectDb();
		
		try {
			if(addCriminal_criminalID.getText().isEmpty()
				|| addCriminal_firstName.getText().isEmpty()
				|| addCriminal_lastName.getText().isEmpty()
				|| addCriminal_gender.getSelectionModel().getSelectedItem() == null
				|| addCriminal_Due.getText().isEmpty()
				|| criminalBirthDate.getValue() == null
				|| addCriminal_AorE.getSelectionModel().getSelectedItem() == null
				|| addCriminal_setArrest.getSelectionModel().getSelectedItem() == null) {
				
				alert.errorMessage("Por favor preencha as tabelas");
			
			} else {
				statement = connect.createStatement();
				result = statement.executeQuery(check);

				if (result.next()) {
					alert.errorMessage("Criminal ID: " + addCriminal_criminalID.getText() + " already exist!");
				} else {

					prepare = connect.prepareStatement(sql);
					prepare.setInt(1, Integer.parseInt(addCriminal_criminalID.getText()));
					prepare.setString(2, addCriminal_firstName.getText());
					prepare.setString(3, addCriminal_lastName.getText());
					prepare.setString(4, (String) addCriminal_gender.getSelectionModel().getSelectedItem());
					prepare.setString(5, addCriminal_Due.getText());
					prepare.setString(6, uri);
					prepare.setDate(7, sqlDate);
					prepare.setBoolean(8, addCriminal_AorE.getSelectionModel().getSelectedItem().equals("Yes"));
			        prepare.setBoolean(9, addCriminal_setArrest.getSelectionModel().getSelectedItem().equals("Yes"));
					prepare.executeUpdate();

					alert.successMessage("Sucessfully Added");
					addCriminalReset();
					addCriminalShowListData();
					
				}
			}
		} catch (SQLException e) {e.printStackTrace();}
	}

	public void addCriminalUpdate() {

	}

	public void addCriminalDelete() {

	}
	
	public void addCriminalReset() {
		addCriminal_criminalID.setText("");
		addCriminal_firstName.setText("");
		addCriminal_lastName.setText("");
		addCriminal_gender.getSelectionModel().clearSelection();
		addCriminal_Due.setText("");
		addCriminal_Image.setImage(null);
		getData.path = "";
		criminalBirthDate.setValue(null); 
		addCriminal_AorE.getSelectionModel().clearSelection();
		addCriminal_setArrest.getSelectionModel().clearSelection();
	}
	
	public ObservableList<criminalData> pushList() {

		ObservableList<criminalData> listdata = FXCollections.observableArrayList();
		String sql = "SELECT * FROM criminal";

		connect = Database.connectDb();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			criminalData crimdata;

			while (result.next()) {
				crimdata = new criminalData(	 
						result.getInt("criminalId"), 
						result.getString("firstName"),
						result.getString("lastName"), 
						result.getString("gender"),
						result.getString("due"),
						result.getString("Image"),
						result.getDate("arrestTime"),
						result.getBoolean("arrested"),
						result.getBoolean("setArrest"));
				listdata.add(crimdata);
			}
		} catch (Exception e) {e.printStackTrace();}		
		return listdata;
	}
	
	
	public void addCriminalSelect() {
		criminalData crimData = addCriminal_tableView.getSelectionModel().getSelectedItem();
		
		if (crimData != null) {
			addCriminal_firstName.setText(crimData.getFirstName());
			addCriminal_lastName.setText(crimData.getLastName());
			addCriminal_Due.setText(crimData.getDue());
			criminalBirthDate.setValue(crimData.getArrestTime().toLocalDate());
			
			/*
			 * addCriminal_gender.getSelectionModel().select(crimData.getGender());
			 * addCriminal_AorE.getSelectionModel().select(crimData.isArrested());
			 * addCriminal_setArrest.getSelectionModel().select(crimData.isSetArrest());
			 */

	
			getData.path = crimData.getImage();
			String uri = "file:" + crimData.getImage();
	
			image = new Image(uri, 132, 188, false, true);
			addCriminal_Image.setImage(image);
		}
	}
	
	public void addCriminalInsertImage() {
		FileChooser open = new FileChooser();
		File file = open.showOpenDialog(main_form.getScene().getWindow());
		
		if(file != null) {
			getData.path = file.getAbsolutePath();
			image = new Image(file.toURI().toString(), 132, 188, false, true);
			addCriminal_Image.setImage(image);
		}
	}
	
	public void addCriminalShowListData() {
		addCriminalData = pushList();
		
		addCriminal_col_criminalID.setCellValueFactory(new PropertyValueFactory<>("criminalId"));
		addCriminal_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		addCriminal_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		addCriminal_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		addCriminal_col_Due.setCellValueFactory(new PropertyValueFactory<>("due"));
		addCriminal_col_arrestTime.setCellValueFactory(new PropertyValueFactory<>("arrestTime"));
		addCriminal_col_Arrested.setCellValueFactory(new PropertyValueFactory<>("arrested"));
		addCriminal_col_setArrest.setCellValueFactory(new PropertyValueFactory<>("setArrest"));
		
		addCriminal_tableView.setItems(addCriminalData);
	}
	
	public void checkAcess () {
		// SELECT check_access('user1');
	}
	
	public void showLastAcessDate() {
		String sql = "SELECT update_access_date('admin')";
		connect = Database.connectDb();
		System.out.println("Ultimo acesso: /n" );
	}

	public void switchForm(ActionEvent event) {
	    Map<Button, Pair<Pane, String>> buttonMap = new HashMap<>();
	    buttonMap.put(home_btn, new Pair<>(home_page, "linear-gradient(to bottom right, #272b3f, #256b51)"));
	    buttonMap.put(gerenciarPol_btn, new Pair<>(gerenc_police, "linear-gradient(to bottom right, #272b3f, #256b51)"));
	    buttonMap.put(gerenciarCrim_btn, new Pair<>(gerenc_crim, "linear-gradient(to bottom right, #272b3f, #256b51)"));
	    buttonMap.put(addCriminal_btn, new Pair<>(addCriminal, "linear-gradient(to bottom right, #272b3f, #256b51)"));
	    buttonMap.put(addPolice_btn, new Pair<>(addPolice, "linear-gradient(to bottom right, #272b3f, #256b51)"));

	    buttonMap.forEach((button, pair) -> {
	        pair.getKey().setVisible(false);
	        setButtonStyle(button, "transparent");
	    });

	    Pair<Pane, String> selectedPair = buttonMap.get(event.getSource());
	    if (selectedPair != null) {
	        selectedPair.getKey().setVisible(true);
	        setButtonStyle((Button) event.getSource(), selectedPair.getValue());
	        
	        if (event.getSource() == addCriminal_btn) {
	            addCriminalArrested();
	            addCriminalsetArrest();
	            addCriminalGenderList();
	        }
	    }
	}

	public void logout() {
		try {
			if (alert.confirmMessage("Are you sure you want to logout?")) {

				logout.getScene().getWindow().hide();
				Parent root = FXMLLoader.load(getClass().getResource("principal.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);

				root.setOnMousePressed((MouseEvent event) -> {
					x = event.getSceneX();
					y = event.getSceneY();
				});

				root.setOnMouseDragged((MouseEvent event) -> {
					stage.setX(event.getScreenX() - x);
					stage.setY(event.getScreenY() - y);
					stage.setOpacity(.8);
				});

				root.setOnMouseReleased((MouseEvent event) -> {
					stage.setOpacity(1);
				});

				stage.initStyle(StageStyle.TRANSPARENT);

				stage.setScene(scene);
				stage.show();
			}
		} catch (Exception e) {e.printStackTrace();}
	}

	public void displayUsername() {
		try {
			String text = getData.username;
			if(!text.isEmpty()) {
				text = text.substring(0, 1).toUpperCase() + text.substring(1);
			}
			username.setText(text);	
		} catch (Exception e) {e.printStackTrace();}
	}
	
	public void close() {
		Platform.exit();
	}

	public void minimize() {
		Stage stage = (Stage) main_form.getScene().getWindow();
		stage.setIconified(true);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		displayUsername();
		defaultNav();
		
		


		addCriminalShowListData();
		addCriminalArrested();
		addCriminalsetArrest();
		addCriminalGenderList();
	}
}