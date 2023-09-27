import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class MaintenanceContent extends ContentArea {
	@Override
	public void initialize() {
	    VBox vbox = new VBox();
		
	GridPane gridPane = new GridPane();
	gridPane.add(new Label("Maintenance"), 0, 2, 2, 1);
        gridPane.add(createMaintenanceTable(), 0, 3, 2, 1);
        
        GridPane.setHgrow(gridPane, Priority.ALWAYS);
        GridPane.setVgrow(gridPane, Priority.ALWAYS);
        gridPane.setMaxWidth(Double.MAX_VALUE);
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(50);

        gridPane.getColumnConstraints().addAll(col1, col2);

        vbox.getChildren().addAll(gridPane);

        content = vbox;
        content.getStyleClass().add("overview-content");
	}
private TableView<String> createMaintenanceTable() {
        TableView<String> maintenanceTable = new TableView<>();
        maintenanceTable.getStyleClass().add("overview-table");

        TableColumn<String, String> lastColumn = new TableColumn<>("Last maintenance");
        lastColumn.setCellValueFactory(new PropertyValueFactory<>("last"));

        TableColumn<String, String> underColumn = new TableColumn<>("Under maintenance");
        underColumn.setCellValueFactory(new PropertyValueFactory<>("under"));

        TableColumn<String, String> scheduledColumn = new TableColumn<>("Scheduled maintenance");
        scheduledColumn.setCellValueFactory(new PropertyValueFactory<>("scheduled"));
        

        maintenanceTable.getColumns().addAll(lastColumn, underColumn, scheduledColumn);

        return maintenanceTable;
    }
}

