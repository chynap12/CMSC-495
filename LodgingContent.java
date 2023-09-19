import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LodgingContent extends ContentArea {
	@Override
	public void initialize() {
		
        TextField destinationField = new TextField("TEST");
        DatePicker departingDate = new DatePicker();
        Spinner<Integer> durationSpinner = new Spinner<>(1, 30, 1);
        Spinner<Integer> travelersSpinner = new Spinner<>(1, 100, 1);
        Button searchButton = new Button("Search");

        HBox inputFields = new HBox(10); 
        inputFields.getChildren().addAll(destinationField, departingDate, durationSpinner, travelersSpinner, searchButton);
		content = new VBox(inputFields);
	}
}
