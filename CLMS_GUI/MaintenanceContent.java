import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MaintenanceContent extends ContentArea {
	@Override
	public void initialize() {
		content = new VBox(
				new Label("Maintenance Content")
				);
	}
}
