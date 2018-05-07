import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class pizzaOrder extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
//Setting the stage and creating all of the fields and buttons
	
	Stage stage;
	TextField txtName;
	TextField txtPhone;
	TextField txtAddress;
	RadioButton rdoSmall;
	RadioButton rdoMedium;
	RadioButton rdoLarge;
	RadioButton rdoThin;
	RadioButton rdoThick;
	CheckBox chkPepperoni;
	CheckBox chkMushrooms;
	CheckBox chkAnchovies;
	CheckBox chkBacon;
	ChoiceBox<String> choiceBox;
	
	@Override public void start(Stage primaryStage)
	{
		stage = primaryStage;
		
		//Creating a choice box
		ChoiceBox<String> choiceBox = new ChoiceBox<String>();
		choiceBox.getItems().add("Visa");
		choiceBox.getItems().add("MasterCard");
		choiceBox.getItems().add("American Express");
		choiceBox.getItems().add("Amex");



		
		//Create the name label and text field
		Label lblName = new Label("Name:");
		txtName = new TextField();
		txtName.setMinWidth(100);
		txtName.setPrefWidth(200);
		txtName.setMaxWidth(300);
		txtName.setPromptText("Enter the name here:");
		
		//Create the phone number and text field
		Label lblPhone = new Label("Phone Number:");
		txtPhone = new TextField();
		txtPhone.setMinWidth(100);
		txtPhone.setPrefWidth(120);
		txtPhone.setMaxWidth(180);
		txtPhone.setPromptText("Enter the phone number here:");
				
		//Create that address and text field
		Label lblAddress = new Label("Address:");
		txtAddress = new TextField();
		txtAddress.setMinWidth(100);
		txtAddress.setPrefWidth(200);
		txtAddress.setMaxWidth(300);
		txtAddress.setPromptText("Enter the Address here:");
		
		//Create the size pane
		Label lblSize = new Label("Size");
		rdoSmall = new RadioButton("Small");
		rdoMedium = new RadioButton("Medium");
		rdoLarge = new RadioButton("Large");
		rdoMedium.setSelected(true);
		ToggleGroup groupSize = new ToggleGroup();
		rdoSmall.setToggleGroup(groupSize);
		rdoMedium.setToggleGroup(groupSize);
		rdoLarge.setToggleGroup(groupSize);
		
		VBox paneSize = new VBox(lblSize, rdoSmall, rdoMedium, rdoLarge);
		paneSize.setSpacing(10);
		
	
		//Create the crust pane
		Label lblCrust = new Label("Crust");
		rdoThin = new RadioButton("Thin");
		rdoThick = new RadioButton("Thick");
		rdoThin.setSelected(true);
		ToggleGroup groupCrust = new ToggleGroup();
		rdoThin.setToggleGroup(groupCrust);
		rdoThick.setToggleGroup(groupCrust);
		
		VBox paneCrust = new VBox(lblCrust, rdoThin, rdoThick);
		paneCrust.setSpacing(10);
		
		//Create the topping's pane
		Label lblToppings = new Label("Toppings");
		chkPepperoni = new CheckBox("Pepperoni");
		chkMushrooms = new CheckBox("Mushrooms");
		chkAnchovies = new CheckBox("Anhovies");
		chkBacon = new CheckBox("Bacon");
		
		VBox paneToppings = new VBox(lblToppings, chkPepperoni, chkMushrooms, chkAnchovies, chkBacon);
		paneToppings.setSpacing(10);

	
		//Create the buttons
		Button btnOK = new Button("OK");
		btnOK.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-border-radius: 20;");
		
		btnOK.setPrefWidth(80);
		btnOK.setOnAction(e -> btnOK_Click());
		
		Button btnCancel = new Button("Cancel");
		btnCancel.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-border-radius: 20;");
		btnCancel.setPrefWidth(80);
		btnCancel.setOnAction(e -> btnCancel_click());
		
		HBox paneButtons = new HBox(10, btnOK, btnCancel);
		
		//Create the Grid Pane Layout
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setMinWidth(500);
		grid.setPrefWidth(500);
		grid.setMaxWidth(800);
		grid.setStyle("-fx-background-color: LightCyan;");
		
		//add the nodes to the pane
		grid.addRow(0, lblName, txtName);
		grid.addRow(1, lblPhone, txtPhone);
		grid.addRow(2, lblAddress, txtAddress);
		grid.addRow(3, paneSize, paneCrust, paneToppings);
		grid.add(paneButtons, 2, 4);
		grid.addRow(5, choiceBox);
		
		
		//Set alignments and spanning
		GridPane.setHalignment(lblName, HPos.RIGHT);
		GridPane.setHalignment(lblPhone, HPos.RIGHT);
		GridPane.setHalignment(lblAddress, HPos.RIGHT);
		GridPane.setColumnSpan(txtName, 2);
		GridPane.setColumnSpan(txtPhone, 2);
		GridPane.setColumnSpan(txtAddress, 2);
		
		//Set Column Widths
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(33);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(33);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPercentWidth(33);
		grid.getColumnConstraints().addAll(col1, col2, col3);
		
		//Create the scene and the stage
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pizza Order");
		primaryStage.setMinWidth(500);
		primaryStage.setMaxWidth(900);
		primaryStage.show();
		
	}
	
	//Clicking the okay button uses a message to display the customer's order
	
	public void btnOK_Click()
	{

		//Create a message string with the customer information
		String msg = "Customer: \n\n";
		msg += "\t" + txtName.getText() + "\n";
		msg += "\t" + txtPhone.getText() + "\n\n";
		msg += "\t" + txtAddress.getText() + "\n";
		msg += "You have ordered a ";
		//Trying to figure out how to display the drop down selection in the message
		//msg += "\t" + choiceBox.getSelectionModel().getSelectedItem();

				
		//add the pizza size
		if (rdoSmall.isSelected())
			msg += "small ";
				if (rdoMedium.isSelected())
			msg += "medium ";
		if (rdoLarge.isSelected())
			msg += "large";
		
		//Add the Crust Style
		if (rdoThin.isSelected())
			msg += "thin crust pizza with ";
		if (rdoThick.isSelected())
			msg += "thick crust pizza with ";
		
		//Add the topping's for the pizza 
		String toppings = "";
		toppings = buildToppings(chkPepperoni, toppings);
		toppings = buildToppings(chkMushrooms, toppings);
		toppings = buildToppings(chkAnchovies, toppings);
		toppings = buildToppings(chkBacon, toppings);
		if (toppings.equals(""))
			msg += "no toppings";
		else
			msg += "the following toppings: \n"
			+ toppings;
		
		//Display the payment type

		
		//Display the message
		Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
		a.setTitle("Order Details");
		a.showAndWait();
			
	}
	
	//Helper method for displaying the list of toppings
	public String buildToppings(CheckBox chk, String msg)
	{
		
		if (chk.isSelected())
		{
			if (!msg.equals(""))
			{
		msg += ", ";
		}
		msg += chk.getText();
		}
		
		return msg;
		}
//Cancels the customer's order by closing the applicaiton
	
		public void btnCancel_click()
		{
			stage.close();
		}
		
			
}