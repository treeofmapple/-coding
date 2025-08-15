package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainScreen implements Initializable {

    @FXML
    private Button close;

    @FXML
    private Button loginBtch;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    private Connection connect;
    private PreparedStatement prepared;
    private ResultSet result;

    private final static String admin = "SELECT * FROM admin WHERE username = ? and password = ?";
    private final static String police = "SELECT * FROM policeOfficer WHERE username = ? and password = ?";

    private double x = 0;
    private double y = 0;
    
    private AlertMessage alert = new AlertMessage();

    public void loginAdmin() {
        connect = Database.connectDb();

        try {
            prepared = connect.prepareStatement(admin);
            prepared.setString(1, username.getText());
            prepared.setString(2, password.getText());
            result = prepared.executeQuery();

            if (username.getText().isEmpty() || password.getText().isEmpty()) {
            	alert.errorMessage("Por favor preencha as linhas vazias");
            } else if (result.next()) {
            	getData.username = username.getText();
            	alert.successMessage("Login realizado com sucesso");
            	closeCurrentWindowAndOpenDashboard();
            } else {
                prepared = connect.prepareStatement(police);
                prepared.setString(1, username.getText());
                prepared.setString(2, password.getText());
                result = prepared.executeQuery();
                if (result.next()) {
                	getData.username = username.getText();
                    alert.successMessage("Login realizado com sucesso");
                    closeCurrentWindowAndOpenDashboard();
                } else {
                	alert.errorMessage("Usuário ou Senha errados");
                }
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    private void closeCurrentWindowAndOpenDashboard() {
        loginBtch.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dashborad.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });

            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {e.printStackTrace();}
    }
    
    public void close() {
        Platform.exit();
    }
}
