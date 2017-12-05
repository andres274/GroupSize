import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class GroupSize extends Application {
    private int attempt = 0;
    public enum AccountType{
        SelectAccount, JediMaster, JediKnight, Padawan, Youngling
    }
    public static void main (String [] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String username = "Andres";
        String password = "javaisfun";
        AccountType accountType = AccountType.JediMaster;
        final int LIMIT = 3;

        TextField usernameTxt = new TextField();
        usernameTxt.setText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setText("Password");
        ComboBox <AccountType> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(AccountType.SelectAccount, AccountType.JediMaster, AccountType.JediKnight, AccountType.Padawan, AccountType.Youngling);
        comboBox.setValue(AccountType.SelectAccount);
        comboBox.setVisible(false);
        Button submitBtn = new Button("Login");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        submitBtn.setOnAction(e->{

            if ((username).equals(username) && passwordField.equals(password) && attempt<=LIMIT) {
                comboBox.setVisible(true);
            }
            else if (attempt < LIMIT) {
                alert.setContentText("Your username or password is incorrect");
                alert.showAndWait();
                attempt++;
            }
            else if (attempt>=LIMIT) {
                alert.setContentText("Contact your administrator");
                alert.showAndWait();
            }
        });

        comboBox.setOnAction(e->{
            if (comboBox.getValue().equals(accountType)) {
                alert.setContentText("Welcome " + username + "!");
                alert.showAndWait();
            }
            else {
                alert.setContentText("Incorrect Account!");
                alert.showAndWait();
            }
        });

        VBox pane = new VBox();
        pane.getChildren().addAll(usernameTxt, passwordField, comboBox, submitBtn);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Group Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

