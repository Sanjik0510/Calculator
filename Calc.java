package Calculator;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Calc {

    //initialization of variables for expression, number, buttons, frame, labels
    CalcPanel exprPanel;
    CalcPanel numPanel;
    JPanel bPanel;

    CalcFrame frame;
    
    JLabel numLabel = new JLabel("0", SwingConstants.RIGHT);
    JLabel exprLabel = new JLabel("", SwingConstants.RIGHT);
    
    String nums = new String();  //variable for the value of the numLabel
    String expression = new String(); //variable for the value of the exprLabel
    
    int count = 0; //variable to count the symbol "="
    String a = new String(); //number one
    String b = new String(); //number two
    String operation = new String(); // operation
    
    // Main method
    Calc(){
        frame = new CalcFrame(); //creating the frame

        bPanel = new JPanel(); // creating the bPanel
        bPanel.setBounds(0, 93, 340, 450); 
        
        exprPanel = new CalcPanel(0, 5, 340, 33, exprLabel, 18); // creating the exprPenel 
        numPanel = new CalcPanel(0, 40, 340, 50, numLabel, 30); // creating the numPanel

        frame.add(bPanel);
        frame.add(exprPanel); //adding all panels to the frame
        frame.add(numPanel);

        buttons(bPanel); //initiating the method which will creat buttons
        

        frame.setVisible(true);
    }

    //method to create all buttons
    void buttons(JPanel panel){
        String[] btext = new String[]{"%", "CE", "C", "Del", "1/x", "x^2", "√x", "÷", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "+/-", "0", ".", "="};
        for (String i: btext) {
            CalcButton button = new CalcButton(i); //creating a new button
            panel.add(button);
        }

    }
    
    // method to control actoins
    void Controller(CalcButton clickButton) {

        switch (clickButton.txt) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".":
                if (nums.equals("0")){
                    nums = "";
                }
                if (clickButton.txt.equals(".") & nums.contains(".")){
                    break;
                } else if (expression.contains("=")){
                    expression = nums = a = b = "";
                    count = 0;
                    exprLabel.setText(expression);
                    nums += clickButton.txt;
                    numLabel.setText(nums);
                    break;
                } else if ((numLabel.getText().equals("enter your expression") | numLabel.getText().equals("")) & clickButton.txt.equals(".")){
                    nums += "0.";
                    numLabel.setText(nums);
                    break;
                }
                nums += clickButton.txt;
                numLabel.setText(nums);
                break;

            case "CE":
                if (nums.equals("") | numLabel.getText().equals("enter your expression")){
                    break;
                }
                nums = "0";
                numLabel.setText(nums);
                break;

            case "C":
                if ((expression.equals("") & nums.equals("")) | numLabel.getText().equals("enter your expression")){
                    break;
                }
                count = 0;
                nums = "0";
                expression = "";
                numLabel.setText(nums);
                exprLabel.setText(nums);
                break;

            case "Del":
                if (nums.equals("") | numLabel.getText().equals("enter your expression")){
                    break;
                }
                String labText = numLabel.getText();
                nums = labText.substring(0, labText.length()-1);
                numLabel.setText(nums);
                break;

            case "+/-":
                if (nums.equals("") | numLabel.getText().equals("enter your expression")){
                    break;
                }
                expression = "";
                expression += "negate(" + nums + ")";
                nums = Calculation.negate(nums);
                exprLabel.setText(expression);
                expression = "";
                numLabel.setText(nums);
                break;

            case "1/x":
                if (nums.equals("") | numLabel.getText().equals("enter your expression")){
                    break;
                }
                expression = "";
                expression = "1/("+nums+")";
                nums = Calculation.power(nums, -1);
                numLabel.setText(nums);
                exprLabel.setText(expression);
                expression = "";
                break;

            case "√x":
                if (nums.equals("") | numLabel.getText().equals("enter your expression")){
                    break;
                }
                expression = "√("+nums+")";
                nums = String.valueOf(Math.sqrt(Double.valueOf(nums)));
                numLabel.setText(nums);
                exprLabel.setText(expression);
                expression = "";
                break;

            case "x^2":
                if (nums.equals("") | numLabel.getText().equals("enter your expression")){
                    break;
                }
                expression = "";
                expression = "sqr("+nums+")";
                nums = Calculation.power(nums, 2);
                numLabel.setText(nums);
                exprLabel.setText(expression);
                expression = "";
                break;

            case "+", "-", "x", "÷":
                if (nums.equals("") | numLabel.getText().equals("enter your expression")){
                    break;
                }
                count = 0;
                a = nums;
                operation = clickButton.txt;
                expression = "";
                expression += a + " " + operation;
                exprLabel.setText(expression);
                nums = "0";
                numLabel.setText(nums);
                break;

            case "=":
                if (count > 0 | expression.equals("") | nums.equals("")){
                    break;
                } else{
                    b = nums;
                    count++;
                    expression += " " + b;
                    exprLabel.setText(expression + " =");
                    nums = Calculation.calc(a, b, operation);
                    numLabel.setText(nums);
                    break;
                }
            default:
                expression = nums = "";
                exprLabel.setText(expression);
                numLabel.setText("Error");
                break;

        }

        numPanel.add(numLabel); 
        frame.setVisible(true);
    }

}