package application;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
	
	@FXML
	private Text textField;
	private long num1 = 0;
	private long num2 = 0;
	private String operator = "";
	private boolean start = true;
	
	@FXML
	private void setNumPad(ActionEvent event) {
		if(start) {
			textField.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		textField.setText(textField.getText() + value);
	}
	
	@FXML
	private void process(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		
		if(!"=".equals(value)) {
			if(!operator.isEmpty()) {
				return;
			}
			operator = value;
			num1 = Long.parseLong(textField.getText());
			textField.setText("");
		} else {
			if (operator.isEmpty()) {
				return;
			}
			textField.setText(String.valueOf(Model.calculate(num1, num2 = Long.parseLong(textField.getText()), operator)));
			operator = "";
			start = true;
		}
	}
	
}
