package Clock;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import com.formdev.flatlaf.FlatDarculaLaf;
public class digitalClock {

	private JFrame frame;
	 JTextField Seconds;
	 private JTextField Hours;
	 private JTextField Min;
	 
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	    EventQueue.invokeLater(() -> {
            try {
                FlatDarculaLaf.setup();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                digitalClock window = new digitalClock();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public digitalClock() {
		
		initialize();
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		Font f=null;
		try {
			 f=Font.createFont(Font.TRUETYPE_FONT,digitalClock.class.getResourceAsStream("/digital-7 (mono italic).ttf"));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		/*panel.setBackground(new Color(0, 0, 0));*/
		panel.setBounds(0, 0, 550, 310);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		Hours = new JTextField();
		Hours.setEditable(false);
		/*Hours.setForeground(new Color(0, 255, 0));
		Hours.setBackground(new Color(0, 0, 0));*/
		Hours.setBorder(null);
		Hours.setHorizontalAlignment(SwingConstants.CENTER);
		Hours.setText("06");
		Hours.setBounds(23,65,123,129);
		Hours.setFont(f.deriveFont(Font.BOLD,100f));
		
		panel.add(Hours);
		Hours.setColumns(10);
		
		Min = new JTextField();
		/*Min.setForeground(new Color(0, 255, 0));
		Min.setBackground(new Color(0, 0, 0));*/
		Min.setBorder(null);
		Min.setHorizontalAlignment(SwingConstants.CENTER);
		Min.setFont(f.deriveFont(Font.BOLD,100f));
		Min.setText("15");
		Min.setEditable(false);
		Min.setBounds(185, 65, 123, 129);
		panel.add(Min);
		Min.setColumns(10);
		
		Seconds = new JTextField();
		/*Seconds.setForeground(new Color(0, 255, 0));
		Seconds.setBackground(new Color(0, 0, 0));*/
		
		Seconds.setBorder(null);
		Seconds.setHorizontalAlignment(SwingConstants.CENTER);
		Seconds.setFont(f.deriveFont(Font.BOLD,100f));
		Seconds.setText("45");
		Seconds.setEditable(false);
		Seconds.setBounds(352, 65, 113, 129);
		panel.add(Seconds);
		Seconds.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(":");
		/*lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));*/
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(148, 65, 27, 129);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(":");
		/*lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));*/
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 80));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(315, 65, 27, 129);
		panel.add(lblNewLabel_1);
		new ClockThread(this);
	}
}
