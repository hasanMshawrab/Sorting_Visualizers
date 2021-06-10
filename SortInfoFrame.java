package CSC310_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SortInfoFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortInfoFrame window = new SortInfoFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SortInfoFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1150, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setForeground(new Color(255, 204, 255));
		panel.setBounds(226, 11, 897, 33);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton bubbleBtn = new JButton("Bubble Sort");
		panel.add(bubbleBtn);
		
		JButton selectionBtn = new JButton("SelectionSort");
		panel.add(selectionBtn);
		
		JButton insertionBtn = new JButton("Insertion Sort");
		panel.add(insertionBtn);
		
		JButton mergeBtn = new JButton("Merge Sort");
		panel.add(mergeBtn);
		
		JButton quickBtn = new JButton("Quick Sort");
		panel.add(quickBtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setForeground(new Color(255, 204, 255));
		panel_1.setBounds(10, 11, 206, 33);
		frame.getContentPane().add(panel_1);
		
		JButton returnBtn = new JButton("Return Back");
		panel_1.add(returnBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 51), 4));
		panel_2.setForeground(new Color(0, 0, 51));
		panel_2.setBounds(10, 55, 1113, 605);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 51));
		panel_3.setBounds(10, 58, 394, 193);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JTextPane txtpnBubbleSortIs = new JTextPane();
		txtpnBubbleSortIs.setEditable(false);
		txtpnBubbleSortIs.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtpnBubbleSortIs.setText("Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.");
		txtpnBubbleSortIs.setBounds(39, 29, 316, 136);
		panel_3.add(txtpnBubbleSortIs);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 204, 204));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		panel_4.setBounds(645, 246, 46, 208);
		panel_2.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("10");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_4.add(lblNewLabel);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(102, 204, 204));
		panel_4_1.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		panel_4_1.setBounds(701, 40, 46, 414);
		panel_2.add(panel_4_1);
		
		JLabel lblNewLabel_1 = new JLabel("25");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_4_1.add(lblNewLabel_1);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(new Color(102, 204, 204));
		panel_4_2.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		panel_4_2.setBounds(757, 74, 46, 380);
		panel_2.add(panel_4_2);
		
		JLabel lblNewLabel_2 = new JLabel("23");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_4_2.add(lblNewLabel_2);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setBackground(new Color(102, 204, 204));
		panel_4_3.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		panel_4_3.setBounds(813, 365, 46, 89);
		panel_2.add(panel_4_3);
		
		JLabel lblNewLabel_3 = new JLabel("4");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_4_3.add(lblNewLabel_3);
		
		JPanel panel_4_4 = new JPanel();
		panel_4_4.setBackground(new Color(102, 204, 204));
		panel_4_4.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		panel_4_4.setBounds(869, 208, 46, 246);
		panel_2.add(panel_4_4);
		
		JLabel lblNewLabel_4 = new JLabel("13");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_4_4.add(lblNewLabel_4);
		
		JPanel panel_4_5 = new JPanel();
		panel_4_5.setBackground(new Color(102, 204, 204));
		panel_4_5.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		panel_4_5.setBounds(925, 105, 46, 349);
		panel_2.add(panel_4_5);
		
		JLabel lblNewLabel_5 = new JLabel("20");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_4_5.add(lblNewLabel_5);
		
		JPanel panel_4_6 = new JPanel();
		panel_4_6.setBackground(new Color(102, 204, 204));
		panel_4_6.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		panel_4_6.setBounds(981, 301, 46, 153);
		panel_2.add(panel_4_6);
		
		JLabel lblNewLabel_6 = new JLabel("8");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_4_6.add(lblNewLabel_6);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 51));
		separator.setBounds(624, 465, 423, 2);
		panel_2.add(separator);
		
		JTextPane txtpnIntArray = new JTextPane();
		txtpnIntArray.setEditable(false);
		txtpnIntArray.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnIntArray.setText("\r\nint[] array = { 10,  25, 23, 4, 13, 20, 8};\r\n\r\n        for (int i = 0; i < array.length; i++) {\r\n\r\n            for (int j = 0; j < array.length - 1 - i; j++) {\r\n\r\n                if (array[j] > array[j + 1]) {\r\n                    swap(array, j, j+1);\r\n                }\r\n\r\n            }\r\n        }");
		txtpnIntArray.setBounds(134, 262, 453, 308);
		panel_2.add(txtpnIntArray);
	}
}
