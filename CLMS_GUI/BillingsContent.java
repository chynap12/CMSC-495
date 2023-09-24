import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;

public class BillingsContent extends ContentArea {
    private Stage primaryStage;

    @Override
    public void initialize() {
        // Create a VBox to contain the navigation bar and content
        VBox vbox = new VBox();

        // Create a navigation bar at the top with a "Generate Invoice" button
        VBox navigationBar = createNavigationBar();
        navigationBar.setPadding(new Insets(10, 10, 10, 10));

        // Create a GridPane layout with a single column
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);

        // Define the top row for a standard billing form
        VBox billingForm = createBillingForm();
        billingForm.getStyleClass().add("billings-category");
        billingForm.setMaxWidth(Double.MAX_VALUE);

        // Define the bottom row for showing a table of transactions
        TableView<Transaction> transactionTable = createTransactionTable();
        transactionTable.getStyleClass().add("transaction-table");
        transactionTable.setMaxWidth(Double.MAX_VALUE);

        // Use RowConstraints to distribute space
        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);
        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);
        
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);

        gridPane.getRowConstraints().addAll(row1, row2);
        gridPane.getColumnConstraints().add(col);

        gridPane.add(billingForm, 0, 0);
        gridPane.add(new Label("Transaction History"), 0, 1);
        gridPane.add(transactionTable, 0, 2);

        vbox.getChildren().addAll(navigationBar, gridPane);

        content = vbox;
        content.getStyleClass().add("billings-content");
    }

    private VBox createNavigationBar() {
        VBox navigationBar = new VBox();
        navigationBar.getStyleClass().add("overview-navigation-bar");

        Button generateInvoiceButton = new Button("Generate Invoice");
        generateInvoiceButton.getStyleClass().add("generate-invoice-button");
        generateInvoiceButton.setOnAction((event) -> {
        	
            // Add logic for generating an invoice here
        	
            System.out.println("Generate Invoice button clicked");
        });
        navigationBar.getChildren().add(generateInvoiceButton);

        return navigationBar;
    }

    private VBox createBillingForm() {
        VBox billingForm = new VBox();
        billingForm.getStyleClass().add("billing-form");

        // Create form components (labels, text fields, etc.)
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Label dateLabel = new Label("Date:");
        DatePicker datePicker = new DatePicker();

        Button submitButton = new Button("Submit");

        billingForm.getChildren().addAll(nameLabel, nameField, amountLabel, amountField, dateLabel, datePicker, submitButton);

        return billingForm;
    }

    private TableView<Transaction> createTransactionTable() {
        TableView<Transaction> transactionTable = new TableView<>();
        transactionTable.getStyleClass().add("transaction-table");

        TableColumn<Transaction, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Transaction, String> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        TableColumn<Transaction, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        transactionTable.getColumns().addAll(nameColumn, amountColumn, dateColumn);

        return transactionTable;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public static class Transaction {
        private final SimpleStringProperty name;
        private final SimpleStringProperty amount;
        private final SimpleStringProperty date;

        public Transaction(String name, String amount, String date) {
            this.name = new SimpleStringProperty(name);
            this.amount = new SimpleStringProperty(amount);
            this.date = new SimpleStringProperty(date);
        }

        public String getName() {
            return name.get();
        }

        public String getAmount() {
            return amount.get();
        }

        public String getDate() {
            return date.get();
        }
    }
}
