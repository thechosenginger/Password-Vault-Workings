import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private String MASTER_PASS_DEBUG = "1";

    private int passphraseCounter = 0;
    Text startMenuGreeting; // All initialized in the .start() method.
    BorderPane devMainUI;
    TextField startMenuPasswordField;
    GridPane devMenu;

    @Override
    public void start(Stage primaryStage) {  // anything graphical will be here
        primaryStage.setTitle("Password Vault");
        Group devRoot = new Group();
        Scene devRootScene = new Scene(devRoot, 480, 640);

        // Cardinal Direction style main UI container
        devMainUI = new BorderPane();
        devRoot.getChildren().add(devMainUI);

        // Add Main UI area
        devMenu = new GridPane();
        devMenu.setHgap(11);
        devMenu.setVgap(11);
        devMainUI.setCenter(devMenu);

        startMenuGreeting = new Text("Enter Master Passphrase Attempt(" + passphraseCounter + ")");
        GridPane.setConstraints(startMenuGreeting, 5, 3);

        startMenuPasswordField = new TextField("Enter Passphrase");
        GridPane.setConstraints(startMenuPasswordField, 5, 5);

        Button enterButton = new Button("Enter");
        GridPane.setConstraints(enterButton, 5, 8);
        enterButton.setOnAction(event -> enterVault());

        devMenu.getChildren().add(startMenuPasswordField);
        devMenu.getChildren().add(enterButton);
        devMenu.getChildren().add(startMenuGreeting);

        primaryStage.setScene(devRootScene);
        primaryStage.show();
    }

    public void viewVault() {
        System.out.println("in vault");

        // Show listView

        // Select option and view contents

        // buttons to return to viewVault

        // button to return to Main Menu



    }

    public void addEntry(){
        devMenu.getChildren().clear();

        // TextFields to allow entry of Data and store data in ArrayList
        Text entryNameField = new Text("Entry Name: ");
        GridPane.setConstraints(entryNameField,0, 1);
        TextField entryNameTField = new TextField("");
        GridPane.setConstraints(entryNameTField,1, 1);

        Text entryUserField = new Text("User Name: ");
        GridPane.setConstraints(entryUserField,0, 2);
        TextField entryUserTField = new TextField("");
        GridPane.setConstraints(entryUserTField,1, 2);

        Text entryPassField = new Text("Enter Passphrase: ");
        GridPane.setConstraints(entryPassField, 0, 3);
        TextField entryPassTField = new TextField("");
        GridPane.setConstraints(entryPassTField, 1, 3);

        Text entryURLField = new Text("URL: ");
        GridPane.setConstraints(entryURLField, 0, 4);
        TextField entryURLTField = new TextField("");
        GridPane.setConstraints(entryURLTField, 1, 4);

        Text entryNotesField = new Text("Notes: ");
        GridPane.setConstraints(entryNotesField, 0, 5);
        TextField entryNotesTField = new TextField("");
        GridPane.setConstraints(entryNotesTField, 1, 5);

        // Button to Encrypt Data
        Button encryptData = new Button("Encrypt Data");
        GridPane.setConstraints(encryptData, 0, 6);

        // Button to Main Menu
        Button mainMenu = new Button("Main Menu");
        GridPane.setConstraints(mainMenu, 1, 6);
        mainMenu.setOnAction(event -> enterVault());


        devMenu.getChildren().add(entryNameField);
        devMenu.getChildren().add(entryNameTField);
        devMenu.getChildren().add(entryUserField);
        devMenu.getChildren().add(entryUserTField);
        devMenu.getChildren().add(entryPassField);
        devMenu.getChildren().add(entryPassTField);
        devMenu.getChildren().add(entryURLField);
        devMenu.getChildren().add(entryURLTField);
        devMenu.getChildren().add(entryNotesField);
        devMenu.getChildren().add(entryNotesTField);
        devMenu.getChildren().add(encryptData);
        devMenu.getChildren().add(mainMenu);

        //Button enterButton = new Button("Enter");
        //GridPane.setConstraints(enterButton, 1, 4);
        //enterButton.setOnAction(enter ->print(entryNameTField));
        //devMenu.getChildren().add(enterButton);

    }

    public void updateEntry(){
        devMenu.getChildren().clear();
        System.out.println("update entry");

        // Display viewVault

        // Select option and view contents

        // Select Data to update

        // Save Button

        // Button to Main Menu
    }

    public void deleteEntry(){
        devMenu.getChildren().clear();
        System.out.println("delete entry");

        // Show viewVault

        // Select option

        // Popup to confirm deletion

        // listView.remove(option)
    }


    public void enterVault() {
        passphraseCounter++;
        startMenuGreeting.setText("Enter Master Passphrase Attempt(" + passphraseCounter + ")");

        startMenuPasswordField.getText(); // how to get results from TextFields
        String masterPassphrase = startMenuPasswordField.getText();

        if(masterPassphrase.equals(MASTER_PASS_DEBUG)){
            devMenu.getChildren().clear();

            Button viewVault = new Button("View Vault");
            GridPane.setConstraints(viewVault, 0, 0);
            viewVault.setOnAction(event -> viewVault());
            devMenu.getChildren().add(viewVault);

            Button addEntry = new Button("Add Entry");
            GridPane.setConstraints(addEntry, 0, 1);
            addEntry.setOnAction(event -> addEntry());
            devMenu.getChildren().add(addEntry);

            Button updateEntry = new Button("Update Entry");
            GridPane.setConstraints(updateEntry, 0, 2);
            updateEntry.setOnAction(event -> updateEntry());
            devMenu.getChildren().add(updateEntry);

            Button deleteEntry = new Button("Delete Entry");
            GridPane.setConstraints(deleteEntry, 0, 3);
            deleteEntry.setOnAction(event -> deleteEntry());
            devMenu.getChildren().add(deleteEntry);

            Button exitVault = new Button("Exit Vault");
            GridPane.setConstraints(exitVault, 0, 4);
            exitVault.setOnAction(event -> Platform.exit());
            devMenu.getChildren().add(exitVault);


        }
        else{
            if(passphraseCounter > 3) {
                //devMenu.getChildren().add(display("ALERT","Please enter the correct passphrase"));
                try {
                    Thread.sleep(10000*passphraseCounter);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // add popup block and notification
            // if fail check if attempt# _ == sleep
            // if passphraseCounter > 3 thread.sleep(10000*passphraseCounter)
        }
    }

    //public static void display(String title, String message){
    //    Stage window = new Stage();
    //
    //    window.initModality(Modality.APPLICATION_MODAL);
    //    window.setTitle(title);
    //    window.setMinWidth(250);
    //
    //    Label label = new Label();
    //    label.setText(message);
    //    Button closeButton = new Button("Close the window");
    //    closeButton.setOnAction(e -> window.close());
    //    VBox layout = new VBox(10);
    //    layout.getChildren().addAll(label, closeButton);
    //    layout.setAlignment(Pos.CENTER);
    //
    //    Scene scene = new Scene(layout);
    //    window.setScene(scene);
    //    window.showAndWait();
    //
    //}


    public static void main(String[] args) {
        launch(args);
    }
}