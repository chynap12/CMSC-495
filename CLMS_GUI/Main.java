import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class Main extends Application {
    private StackPane root;
    Map<String, ContentArea> contentAreas = new HashMap<>();

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

        // Content for Tabs
        contentAreas.put("Overview", new OverviewContent());
        contentAreas.put("Cruises", new CruisesContent());
        contentAreas.put("Maintenance", new MaintenanceContent());
        contentAreas.put("Billings", new BillingsContent());
        contentAreas.put("Lodging", new LodgingContent());
        contentAreas.put("Manifest", new ManifestContent());

        // Event handling for ToggleButtons
        overviewButton.setOnAction(e -> showCategoryContent(contentAreas.get("Overview").getContent()));
        cruisesButton.setOnAction(e -> showCategoryContent(contentAreas.get("Cruises").getContent()));
        manifestButton.setOnAction(e -> showCategoryContent(contentAreas.get("Manifest").getContent()));
        maintenanceButton.setOnAction(e -> showCategoryContent(contentAreas.get("Maintenance").getContent()));
        billingsButton.setOnAction(e -> showCategoryContent(contentAreas.get("Billings").getContent()));
        lodgingButton.setOnAction(e -> showCategoryContent(contentAreas.get("Lodging").getContent()));
        
        // Default to overview
        overviewButton.setSelected(true);

        // Create an HBox for the ToggleButtons
        HBox categoryButtons = new HBox(10);
        categoryButtons.getChildren().addAll(overviewButton, cruisesButton, manifestButton, maintenanceButton, billingsButton, lodgingButton);
        categoryButtons.getStyleClass().add("toggle-group");

        // Create the main layout
        root = new StackPane(contentAreas.get("Overview").getContent()); /** not properly initializing overview **/
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
