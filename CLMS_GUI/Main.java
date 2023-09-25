import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    CLMS data = new CLMS(); 
    private StackPane root;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cruise Liner Management System");

        // Create ToggleButtons for different categories
        ToggleButton overviewButton = new ToggleButton("Overview");
        ToggleButton cruisesButton = new ToggleButton("Cruises");
        ToggleButton manifestButton = new ToggleButton("Manifest");
        ToggleButton maintenanceButton = new ToggleButton("Maintenance");
        ToggleButton billingsButton = new ToggleButton("Billings");
        ToggleButton lodgingButton = new ToggleButton("Lodging");

        // Create a ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        overviewButton.setToggleGroup(toggleGroup);
        cruisesButton.setToggleGroup(toggleGroup);
        manifestButton.setToggleGroup(toggleGroup);
        maintenanceButton.setToggleGroup(toggleGroup);
        billingsButton.setToggleGroup(toggleGroup);
        lodgingButton.setToggleGroup(toggleGroup);

        // Create content tabs
        OverviewContent overviewContent = new OverviewContent();
        overviewContent.initialize();

        CruisesContent cruisesContent = new CruisesContent();
        cruisesContent.initialize();

        MaintenanceContent maintenanceContent = new MaintenanceContent();
        maintenanceContent.initialize();

        BillingsContent billingsContent = new BillingsContent();
        billingsContent.initialize();

        LodgingContent lodgingContent = new LodgingContent();
        lodgingContent.initialize();

        ManifestContent manifestContent = new ManifestContent();
        manifestContent.initialize();

        // Event handling for ToggleButtons
        overviewButton.setOnAction(e -> showCategoryContent(overviewContent.getContent()));
        cruisesButton.setOnAction(e -> showCategoryContent(cruisesContent.getContent()));
        manifestButton.setOnAction(e -> showCategoryContent(manifestContent.getContent()));
        maintenanceButton.setOnAction(e -> showCategoryContent(maintenanceContent.getContent()));
        billingsButton.setOnAction(e -> showCategoryContent(billingsContent.getContent()));
        lodgingButton.setOnAction(e -> showCategoryContent(lodgingContent.getContent()));
        
        // Default to overview
        overviewButton.setSelected(true);

        // Create an HBox for the ToggleButtons
        HBox categoryButtons = new HBox(10);
        categoryButtons.getChildren().addAll(overviewButton, cruisesButton, manifestButton, maintenanceButton, billingsButton, lodgingButton);
        categoryButtons.getStyleClass().add("toggle-group");

        // Create the main layout
        root = new StackPane(overviewContent.getContent());
        VBox mainLayout = new VBox(categoryButtons, root);
        Scene scene = new Scene(mainLayout, 800, 600);
        
        // Link the CSS file to the scene
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showCategoryContent(VBox content) {
        root.getChildren().clear();
        root.getChildren().add(content);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
