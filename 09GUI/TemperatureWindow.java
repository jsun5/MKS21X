import javax.swing.*;
import java.awt.*;

public class TemperatureWindow extends JFrame{
    private Container pane;
    private JButton CF;
    private JButton FC;
    private JTextField t;

    public TemperatureWindow(){
	this.setTitle("Temperature Convertor");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	CF = new JButton("Convert Celsius to Fahrenheit");
	FC = new JButton("Convert Fahrenheit to Celsius");
	t = new JTextField(10);
	pane.add(t);
	pane.add(CF);
	pane.add(FC);
    }

    public static void main(String[]args){
	TemperatureWindow w = new TemperatureWindow();
	w.setVisible(true);
    }
}
