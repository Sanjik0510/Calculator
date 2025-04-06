package Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//class with constuctor for frame
public class CalcFrame extends JFrame{

    CalcFrame(){

        this.setTitle("Calculator"); // set title of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out ot applicatio
        this.setSize(354,435); // sets the x-dimention and y-dimention of the frame
        this.setResizable(false); // prevent frame being resize
        this.setLayout(null);
        this.setVisible(true); // makes the frame visible

        ImageIcon image = new ImageIcon("Calculator\\assets\\images\\logo.png"); // create an imageIcon
        this.setIconImage(image.getImage()); // change icon of the frame
    }

}

//class with constuctor and ActionListener for buttons
class CalcButton extends JButton{

    ActionListener buttonClickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CalcButton clickedButton = (CalcButton) e.getSource();
            Calc.Controller(clickedButton);
            
        }
    };

    String txt = new String();
    
    //constructor
    CalcButton(String buttonText){
        this.txt = buttonText;
        this.setPreferredSize(new Dimension(79, 45));
        this.setText(buttonText);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setFont(new Font("Comic Sans", Font.BOLD, 20));
        this.setFocusable(false);
        this.addActionListener(buttonClickListener);
    }
}

//constructor for panels
class CalcPanel extends JPanel{

    CalcPanel(int x, int y, int width, int height, JLabel label, int fontSize){
        this.setBounds(x, y, width, height);
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.EAST);
        label.setFont(new Font("Comic Sanc", Font.BOLD, fontSize));
    }
}
