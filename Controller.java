package application;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
	
	@FXML
	private Text textField;
	private double num1 = 0;
	private double num2 = 0;
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
			num1 = Double.parseDouble(textField.getText());
			textField.setText("");
		} else {
			if (operator.isEmpty()) {
				return;
			}
			textField.setText(String.valueOf(Model.calculate(num1, num2 = Double.parseDouble(textField.getText()), operator)));
			operator = "";
			start = true;
		}
	}
	
	@FXML
	private void squareRoot(ActionEvent event) {
		num1 = Double.parseDouble(textField.getText());
		String value = ((Button)event.getSource()).getText();
		operator = value;
		if(num1 == 0) {
			return;
		} else {
			textField.setText(String.valueOf(Model.calculate(num1, 0, operator)));
		}
		operator = "";
		start = true;
	}
	
	@FXML
	private void clear(ActionEvent event) {
		num1 = 0;
		num2 = 0;
		textField.setText("");
	}
	
}
	

