import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    private JButton CF;
    private JButton FC;
    private JTextField t;

    public TemperatureWindow(){
	this.setTitle("Temperature Convertor");
	this.setSize(600,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	CF = new JButton("Convert Celsius to Fahrenheit");
	FC = new JButton("Convert Fahrenheit to Celsius");
	t = new JTextField(10);

	CF.addActionListener(this);
	FC.addActionListener(this);
	t.addActionListener(this);
	
	pane.add(t);
	pane.add(CF);
	pane.add(FC);
    }

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	System.out.println(s);
	if(s.equals("Convert Celsius to Fahrenheit")){
	    double temp = Double.parseDouble(t.getText());
	    t.setText(Double.toString(TempConversion.CtoF(temp)));
	}
	if(s.equals("Convert Fahrenheit to Celsius")){
	    double temp = Double.parseDouble(t.getText());
	    t.setText(Double.toString(TempConversion.FtoC(temp)));
	}
    }


	    

    public static void main(String[]args){
	TemperatureWindow w = new TemperatureWindow();
	w.setVisible(true);
    }
}
