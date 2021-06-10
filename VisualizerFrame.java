package CSC310_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;

public class VisualizerFrame {

	int[] arr5 = { 2, 9, 6, 10, 3 };
	int[] arr10 = { 2, 16, 1, 3, 6, 17, 8, 9, 12, 4 };
	int[] arr25 = { 34, 3, 7, 20, 6, 39, 44, 10, 26, 21, 50, 28, 43, 32, 27, 9, 23, 1, 12, 42, 11, 31, 25, 5, 33 };
	int[] arr50 = { 44, 31, 41, 29, 24, 16, 33, 15, 14, 21, 48, 4, 49, 2, 22, 19, 38, 45, 8, 9, 3, 47, 39, 7, 30, 13,
			28, 12, 27, 26, 43, 23, 18, 50, 25, 5, 32, 20, 11, 40, 6, 34, 1, 37, 36, 46, 42, 17, 10, 35 };
	int[] arr100 = { 175, 155, 199, 172, 131, 32, 18, 55, 14, 138, 51, 80, 114, 98, 147, 163, 44, 96, 108, 178, 148,
			127, 162, 187, 158, 100, 133, 135, 66, 91, 8, 149, 116, 176, 128, 181, 29, 167, 41, 17, 109, 177, 125, 46,
			99, 170, 194, 146, 106, 193, 75, 156, 198, 124, 145, 104, 20, 173, 139, 165, 4, 154, 85, 15, 196, 168, 2,
			68, 84, 30, 119, 113, 74, 71, 123, 164, 79, 21, 77, 144, 31, 159, 11, 141, 161, 157, 185, 73, 16, 192, 82,
			35, 132, 61, 179, 102, 10, 152, 97, 111 };

	private JFrame frame;
	static boolean opened = false;
	private JPanel bottomPanel;
	private GridBagConstraints c;
	private JPanel[] box;
	private int sizeModifier;
	private JComboBox<String> speedBox;
	private int width;
	private int factor;
	private int[] arr;
	static allAlgoFrame windowAll;
	JButton startBtn;
	JButton stopBtn;
	ImageIcon icon;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { VisualizerFrame window = new
	 * VisualizerFrame(); window.getFrame().setVisible(true); } catch (Exception e)
	 * { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public VisualizerFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1150, 700);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setResizable(false);
		getFrame().setLocationRelativeTo(null);
		getFrame().requestFocus();

		icon = new ImageIcon("C:\\Users\\lenovo\\eclipse-workspace-new\\Visualizer\\src\\picture4.png");
		getFrame().setIconImage(icon.getImage());
		getFrame().setTitle("Sorting Visaualizer | Hasan Mshawrab Spring 2021 | LAU-Beirut");

		c = new GridBagConstraints();
		c.insets = new Insets(0, 1, 0, 1);
		c.anchor = GridBagConstraints.SOUTH;

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(0, 0, 51));
		topPanel.setBounds(10, 11, 898, 39);
		getFrame().getContentPane().add(topPanel);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Select Algorithm: ");
		lblNewLabel.setForeground(Color.PINK);
		topPanel.add(lblNewLabel);

		JComboBox<String> selectionBox = new JComboBox<String>();
		selectionBox.addItem("Select Algorithm");
		selectionBox.addItem("Bubble Sort");
		selectionBox.addItem("Selection Sort");
		selectionBox.addItem("Insertion Sort");
		selectionBox.addItem("Merge Sort");
		selectionBox.addItem("Quick Sort");

		selectionBox.setSelectedIndex(0);
		topPanel.add(selectionBox);

		JLabel lblNewLabel_1 = new JLabel("Array Size: ");
		lblNewLabel_1.setForeground(Color.PINK);
		topPanel.add(lblNewLabel_1);

		JComboBox<Integer> sizeBox = new JComboBox<Integer>();
		sizeBox.addItem(5);
		sizeBox.addItem(10);
		sizeBox.addItem(25);
		sizeBox.addItem(50);
		sizeBox.addItem(100);
		topPanel.add(sizeBox);

		sizeBox.setSelectedIndex(0);

		// first assign the array needed to be sorted to array5, and set width to be 50
		arr = new int[5];
		System.arraycopy(arr5, 0, arr, 0, 5);
		width = 50;
		factor = 5;

		sizeBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!startBtn.isSelected()) {
					int size = (int) sizeBox.getSelectedItem();
					arr = new int[size];
					/*
					 * In the following switch we set the array to be sorted "arr" to a specific
					 * array based on the chosen size
					 */
					switch (size) {
					case 5:
						System.arraycopy(arr5, 0, arr, 0, size);
						width = 50;
						factor = 5;
						break;
					case 10:
						System.arraycopy(arr10, 0, arr, 0, size);
						width = 40;
						factor = 8;
						break;
					case 25:
						System.arraycopy(arr25, 0, arr, 0, size);
						width = 25;
						factor = 23;
						break;
					case 50:
						System.arraycopy(arr50, 0, arr, 0, size);
						width = 18;
						factor = 30;
						break;
					case 100:
						System.arraycopy(arr100, 0, arr, 0, size);
						width = 9;
						factor = 90;
						break;
					}
					// redraw the new array based on the
					drawBoxes();
					Main.array = arr;
					Main.isSorted = false;
				} else {
					JOptionPane.showMessageDialog(null, "Wiat till the sorting done, and then rechoose NEW SIZE!");
				}
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Speed: ");
		lblNewLabel_2.setForeground(Color.PINK);
		topPanel.add(lblNewLabel_2);

		speedBox = new JComboBox<String>();
		speedBox.addItem("Noraml Speed");
		speedBox.addItem("Slow Speed");
		speedBox.addItem("Fast Speed");

		speedBox.setSelectedIndex(0);
		Main.speed1 = 500;
		speedBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) speedBox.getSelectedItem();
				if (s.equalsIgnoreCase("Fast Speed")) {
					Main.speed1 = 10;
				} else if (s.equalsIgnoreCase("Slow Speed")) {
					Main.speed1 = 2000;
				} else {
					Main.speed1 = 500;
				}

			}
		});

		topPanel.add(speedBox);

		startBtn = new JButton("Start");
		startBtn.setFocusPainted(false);
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!Main.isSorted) {
					if (!startBtn.isSelected()) {
						startBtn.setSelected(true);
						startBtn.setBackground(new Color(255, 113, 126));

						String sortAlgo1 = (String) selectionBox.getSelectedItem();
						if (sortAlgo1.equalsIgnoreCase("Select Algorithm")) {
							JOptionPane.showMessageDialog(null, "Select a valid Algorithm!");
							startBtn.setSelected(false);
							startBtn.setBackground(new Color(240, 240, 240));
						} else {
							bottomPanel.removeAll();
							bottomPanel.revalidate();
							bottomPanel.repaint();
							Main.sortAlgo = sortAlgo1;
							Main.startSorting();
						}

					} else {
						JOptionPane.showMessageDialog(null, "Wait till the sort Done!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "It's sorted choose another SIZE!");

				}
			}
		});
		topPanel.add(startBtn);

		stopBtn = new JButton("Stop");
		stopBtn.setFocusPainted(false);

		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopBtn.setSelected(true);
			}
		});
		topPanel.add(stopBtn);

		JButton btnNewButton_1 = new JButton("Continue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopBtn.setSelected(false);
			}
		});
		topPanel.add(btnNewButton_1);

		bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(255, 204, 204));
		bottomPanel.setBounds(10, 61, 1114, 589);
		getFrame().getContentPane().add(bottomPanel);
		bottomPanel.setLayout(new GridBagLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(918, 11, 206, 39);
		getFrame().getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton comparingBtn = new JButton("View All Algorithms");
		comparingBtn.setFocusPainted(false);

		comparingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							if (!startBtn.isSelected()) {
								if (!opened) {
									opened = true;
									windowAll = new allAlgoFrame();
									windowAll.getFrame().setVisible(true);
									windowAll.getFrame().setLocationRelativeTo(null);
								} else {
									JOptionPane.showMessageDialog(null, "It is already opened!");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Wait till the sort Done!");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panel.add(comparingBtn);

		drawBoxes();

	}

	/********
	 * Methods
	 ***************************************************************************************/

	private void drawBoxes() {
		box = new JPanel[arr.length];
		bottomPanel.removeAll();
		bottomPanel.revalidate();
		bottomPanel.repaint();
		sizeModifier = (int) ((bottomPanel.getHeight() * 0.9) / (factor * 2));
		for (int i = 0; i < box.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(new Color(255, 153, 153));
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(width, arr[i] * sizeModifier));
			int num = arr[i];
			String s = "" + num;
			JLabel label = new JLabel(s);
			if (arr.length != 100) {
				box[i].add(label);
			}
			bottomPanel.add(box[i], c);
		}
	}

	public void reDrawBoxes(int[] array, int currentIndex, int comparingIndex) {

		bottomPanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			int num = array[i];
			String s = "" + num;
			JLabel label = new JLabel(s);
			box[i].setPreferredSize(new Dimension(width, array[i] * sizeModifier));
			if (i == currentIndex) {
				box[i].setBackground(Color.GREEN);
				if (arr.length != 100) {
					box[i].add(label);
				}
			} else if (i == comparingIndex) {
				box[i].setBackground(Color.RED);
				if (arr.length != 100) {
					box[i].add(label);
				}
			} else {
				box[i].setBackground(new Color(255, 153, 153));
				box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
				if (arr.length != 100) {
					box[i].add(label);
				}
			}
			bottomPanel.add(box[i], c);
		}
		bottomPanel.repaint();
		bottomPanel.revalidate();

	}

	/*****
	 * reDraw for Merge sort and Quick sort
	 */

	public void reDrawBox2(int[] array, int currentIndex, int comparingIndex, int readingIndex) {

		bottomPanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			int num = array[i];
			String s = "" + num;
			JLabel label = new JLabel(s);
			box[i].setPreferredSize(new Dimension(width, array[i] * sizeModifier));
			if (i == currentIndex) {
				box[i].setBackground(Color.GREEN);
				if (arr.length != 100) {
					box[i].add(label);
				}
			} else if (i == comparingIndex) {
				box[i].setBackground(Color.RED);
				if (arr.length != 100) {
					box[i].add(label);
				}
			} else if (i == readingIndex) {
				box[i].setBackground(Color.yellow);
				if (arr.length != 100) {
					box[i].add(label);
				}
			} else {
				box[i].setBackground(new Color(255, 153, 153));
				box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
				if (arr.length != 100) {
					box[i].add(label);
				}
			}
			bottomPanel.add(box[i], c);
		}
		bottomPanel.repaint();
		bottomPanel.revalidate();
	}

	/*****
	 * 
	 * Show message after done sorting
	 */

	public void showMessage() {
		JOptionPane.showMessageDialog(null, "We've done Sorting!");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
