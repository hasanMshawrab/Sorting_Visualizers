package CSC310_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;

import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class allAlgoFrame {

	private JFrame frame;

	int[] arrAlmostSort = { 1, 2, 3, 4, 6, 5, 7, 9, 8, 10, 11, 13, 12, 14, 15, 17, 16, 18, 19, 20, 22, 21, 24, 25, 23,
			26, 27, 29, 28, 30, 31, 32, 34, 33, 35, 36, 38, 37, 39 };
	int[] arrSortedFromEnd = { 40, 39, 38, 37, 36, 35, 34, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18,
			17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	int[] arrLastElemnet = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
			27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 40, 1 };

	private JPanel[] box;
	private int sizeModifier;
	private GridBagConstraints c;
	int[] arr, t1Arr, t2Arr, t3Arr, t4Arr, t5Arr;
	JPanel bubblePanel;
	JPanel selectionPanel;
	JPanel insertionPanel;
	JPanel quickPanel;
	JPanel mergePanel;
	JButton startBtn;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { allAlgoFrame window = new
	 * allAlgoFrame(); window.getFrame().setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public allAlgoFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param icon 
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(new Color(240, 240, 240));
		getFrame().setBounds(100, 100, 1150, 700);
		// getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setResizable(false);
		ImageIcon icon;
		icon = new ImageIcon("C:\\Users\\lenovo\\eclipse-workspace-new\\Visualizer\\src\\picture4.png");
		getFrame().setIconImage(icon.getImage());
		getFrame().setTitle("All Algorithms Visaualizer | Hasan Mshawrab Spring 2021 | LAU-Beirut");
		
		getFrame().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				VisualizerFrame.opened = false;
			}
		});

		c = new GridBagConstraints();
		c.insets = new Insets(0, 1, 0, 1);
		c.anchor = GridBagConstraints.SOUTH;

		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(new Color(0, 0, 51), 3));
		topPanel.setBackground(new Color(0, 0, 51));
		topPanel.setBounds(10, 11, 1124, 39);
		getFrame().getContentPane().add(topPanel);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Special Cases: ");
		lblNewLabel_1.setForeground(new Color(255, 153, 153));
		topPanel.add(lblNewLabel_1);

		// first let all panels in arrAlmostSort
		arr = new int[arrAlmostSort.length];
		t1Arr = new int[arrAlmostSort.length];
		t2Arr = new int[arrAlmostSort.length];
		t3Arr = new int[arrAlmostSort.length];
		t4Arr = new int[arrAlmostSort.length];
		t5Arr = new int[arrAlmostSort.length];
		System.arraycopy(arrAlmostSort, 0, arr, 0, arrAlmostSort.length);
		System.arraycopy(arrAlmostSort, 0, t1Arr, 0, arrAlmostSort.length);
		System.arraycopy(arrAlmostSort, 0, t2Arr, 0, arrAlmostSort.length);
		System.arraycopy(arrAlmostSort, 0, t3Arr, 0, arrAlmostSort.length);
		System.arraycopy(arrAlmostSort, 0, t4Arr, 0, arrAlmostSort.length);
		System.arraycopy(arrAlmostSort, 0, t5Arr, 0, arrAlmostSort.length);

		JComboBox<String> chooseBox = new JComboBox<String>();
		topPanel.add(chooseBox);

		chooseBox.addItem("Almost Sorted");
		chooseBox.addItem("Sorted From End");
		chooseBox.addItem("LastElement is the Least");
		chooseBox.setBackground(new Color(255, 240, 245));

		chooseBox.setSelectedIndex(0);

		chooseBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String choosen = (String) chooseBox.getSelectedItem();
				/*
				 * System.out.println("Allsorted "+ Main.allSorted);
				 * System.out.println("Slecti: "+Main.selectionPanel);
				 * System.out.println("Bubble: "+Main.bubblePanel);
				 * System.out.println("Insert: "+Main.insertionPanel);
				 */
				Main.allSorted = Main.selectionPanel && Main.bubblePanel && Main.insertionPanel && Main.mergePanel && Main.quickPanel;
				
				if (Main.allSorted) {
					switch (choosen) {
					case "Almost Sorted":
						arr = new int[arrAlmostSort.length];
						t1Arr = new int[arrAlmostSort.length];
						t2Arr = new int[arrAlmostSort.length];
						t3Arr = new int[arrAlmostSort.length];
						t4Arr = new int[arrAlmostSort.length];
						t5Arr = new int[arrAlmostSort.length];
						System.arraycopy(arrAlmostSort, 0, arr, 0, arrAlmostSort.length);
						System.arraycopy(arrAlmostSort, 0, t1Arr, 0, arrAlmostSort.length);
						System.arraycopy(arrAlmostSort, 0, t2Arr, 0, arrAlmostSort.length);
						System.arraycopy(arrAlmostSort, 0, t3Arr, 0, arrAlmostSort.length);
						System.arraycopy(arrAlmostSort, 0, t4Arr, 0, arrAlmostSort.length);
						System.arraycopy(arrAlmostSort, 0, t5Arr, 0, arrAlmostSort.length);
						break;
					case "Sorted From End":
						arr = new int[arrSortedFromEnd.length];
						t1Arr = new int[arrSortedFromEnd.length];
						t2Arr = new int[arrSortedFromEnd.length];
						t3Arr = new int[arrSortedFromEnd.length];
						t4Arr = new int[arrSortedFromEnd.length];
						t5Arr = new int[arrSortedFromEnd.length];
						System.arraycopy(arrSortedFromEnd, 0, arr, 0, arrSortedFromEnd.length);
						System.arraycopy(arrSortedFromEnd, 0, t1Arr, 0, arrSortedFromEnd.length);
						System.arraycopy(arrSortedFromEnd, 0, t2Arr, 0, arrSortedFromEnd.length);
						System.arraycopy(arrSortedFromEnd, 0, t3Arr, 0, arrSortedFromEnd.length);
						System.arraycopy(arrSortedFromEnd, 0, t4Arr, 0, arrSortedFromEnd.length);
						System.arraycopy(arrSortedFromEnd, 0, t5Arr, 0, arrSortedFromEnd.length);
						break;
					case "LastElement is the Least":
						arr = new int[arrLastElemnet.length];
						t1Arr = new int[arrLastElemnet.length];
						t2Arr = new int[arrLastElemnet.length];
						t3Arr = new int[arrLastElemnet.length];
						t4Arr = new int[arrLastElemnet.length];
						t5Arr = new int[arrLastElemnet.length];
						System.arraycopy(arrLastElemnet, 0, arr, 0, arrLastElemnet.length);
						System.arraycopy(arrLastElemnet, 0, t1Arr, 0, arrLastElemnet.length);
						System.arraycopy(arrLastElemnet, 0, t2Arr, 0, arrLastElemnet.length);
						System.arraycopy(arrLastElemnet, 0, t3Arr, 0, arrLastElemnet.length);
						System.arraycopy(arrLastElemnet, 0, t4Arr, 0, arrLastElemnet.length);
						System.arraycopy(arrLastElemnet, 0, t5Arr, 0, arrLastElemnet.length);
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + choosen);
					}
					bubblePanel.removeAll();
					selectionPanel.removeAll();
					insertionPanel.removeAll();
					quickPanel.removeAll();
					mergePanel.removeAll();
					bubblePanel.revalidate();
					selectionPanel.revalidate();
					insertionPanel.revalidate();
					quickPanel.revalidate();
					mergePanel.revalidate();
					bubblePanel.repaint();
					selectionPanel.repaint();
					insertionPanel.repaint();
					quickPanel.repaint();
					mergePanel.repaint();
					drawBoxes();
				} else {
					JOptionPane.showMessageDialog(null, "Wiat till the Sort Done!");
				}
			}
		});

		startBtn = new JButton("Start");
		startBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		startBtn.setFocusPainted(false);
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.allSorted = Main.selectionPanel && Main.bubblePanel && Main.insertionPanel && Main.mergePanel && Main.quickPanel;
				if (Main.allSorted) {
					startBtn.setSelected(false);
				}

				if (!startBtn.isSelected()) {
					startBtn.setSelected(true);
					Main.selectionPanel = false;
					Main.bubblePanel = false;
					Main.insertionPanel = false;
					Main.mergePanel = false;
					Main.quickPanel = false;
					Thread t1 = new Thread(new SelectionSort(t1Arr, VisualizerFrame.windowAll));
					Thread t2 = new Thread(new BubbleSort(t2Arr, VisualizerFrame.windowAll));
					Thread t3 = new Thread(new InsertionSort(t3Arr, VisualizerFrame.windowAll));
					Thread t4 = new Thread(new MergeSort(t4Arr, VisualizerFrame.windowAll));
					Thread t5 = new Thread(new QuickSort(t5Arr, VisualizerFrame.windowAll));
					t1.start();
					t2.start();
					t3.start();
					t4.start();
					t5.start();
				} else {
					JOptionPane.showMessageDialog(null, "Wiat till the Sort Done!");
				}
			}
		});
		topPanel.add(startBtn);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(255, 204, 204));
		bottomPanel.setBounds(10, 58, 1124, 602);
		getFrame().getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);

		bubblePanel = new JPanel();
		bubblePanel.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		bubblePanel.setBackground(new Color(240, 240, 241));
		bubblePanel.setBounds(10, 11, 361, 270);
		bottomPanel.add(bubblePanel);
		GridBagLayout gbl_bubblePanel = new GridBagLayout();
		gbl_bubblePanel.columnWidths = new int[] { 0 };
		gbl_bubblePanel.rowHeights = new int[] { 0 };
		gbl_bubblePanel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_bubblePanel.rowWeights = new double[] { Double.MIN_VALUE };
		bubblePanel.setLayout(gbl_bubblePanel);

		selectionPanel = new JPanel();
		selectionPanel.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		selectionPanel.setBackground(new Color(240, 240, 241));
		selectionPanel.setBounds(381, 11, 361, 270);
		bottomPanel.add(selectionPanel);
		GridBagLayout gbl_selectionPanel = new GridBagLayout();
		gbl_selectionPanel.columnWidths = new int[] { 0 };
		gbl_selectionPanel.rowHeights = new int[] { 0 };
		gbl_selectionPanel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_selectionPanel.rowWeights = new double[] { Double.MIN_VALUE };
		selectionPanel.setLayout(gbl_selectionPanel);

		insertionPanel = new JPanel();
		insertionPanel.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		insertionPanel.setBackground(new Color(240, 240, 241));
		insertionPanel.setBounds(10, 308, 361, 270);
		bottomPanel.add(insertionPanel);
		GridBagLayout gbl_insertionPanel = new GridBagLayout();
		gbl_insertionPanel.columnWidths = new int[] { 0 };
		gbl_insertionPanel.rowHeights = new int[] { 0 };
		gbl_insertionPanel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_insertionPanel.rowWeights = new double[] { Double.MIN_VALUE };
		insertionPanel.setLayout(gbl_insertionPanel);

		quickPanel = new JPanel();
		quickPanel.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		quickPanel.setBackground(new Color(240, 240, 241));
		quickPanel.setBounds(381, 308, 361, 270);
		bottomPanel.add(quickPanel);
		GridBagLayout gbl_quickPanel = new GridBagLayout();
		gbl_quickPanel.columnWidths = new int[] { 0 };
		gbl_quickPanel.rowHeights = new int[] { 0 };
		gbl_quickPanel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_quickPanel.rowWeights = new double[] { Double.MIN_VALUE };
		quickPanel.setLayout(gbl_quickPanel);

		mergePanel = new JPanel();
		mergePanel.setBorder(new LineBorder(new Color(0, 0, 51), 2));
		mergePanel.setBackground(new Color(240, 240, 241));
		mergePanel.setBounds(753, 150, 361, 270);
		bottomPanel.add(mergePanel);
		GridBagLayout gbl_mergePanel = new GridBagLayout();
		gbl_mergePanel.columnWidths = new int[] { 0 };
		gbl_mergePanel.rowHeights = new int[] { 0 };
		gbl_mergePanel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_mergePanel.rowWeights = new double[] { Double.MIN_VALUE };
		mergePanel.setLayout(gbl_mergePanel);

		JLabel lblNewLabel = new JLabel("Merge Sort");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(911, 428, 78, 16);
		bottomPanel.add(lblNewLabel);

		JLabel lblQuickSort = new JLabel("Quick Sort");
		lblQuickSort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuickSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuickSort.setBounds(518, 583, 78, 14);
		bottomPanel.add(lblQuickSort);

		JLabel lblInsertionSort = new JLabel("Insertion Sort");
		lblInsertionSort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInsertionSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertionSort.setBounds(150, 583, 78, 14);
		bottomPanel.add(lblInsertionSort);

		JLabel lblBubbleSort = new JLabel("Bubble Sort");
		lblBubbleSort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBubbleSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblBubbleSort.setBounds(150, 288, 78, 14);
		bottomPanel.add(lblBubbleSort);

		JLabel lblSelectionSort = new JLabel("Selection Sort");
		lblSelectionSort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectionSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionSort.setBounds(518, 288, 89, 14);
		bottomPanel.add(lblSelectionSort);
		getFrame().setResizable(false);

		drawBoxes();

	}

	public void drawBoxes() {

		box = new JPanel[arr.length];

		sizeModifier = (int) ((bubblePanel.getHeight() * 0.9) / (40));

		for (int i = 0; i < box.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(new Color(255, 153, 153));
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, arr[i] * sizeModifier));
			bubblePanel.add(box[i], c);
		}

		for (int i = 0; i < box.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(new Color(255, 153, 153));
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, arr[i] * sizeModifier));
			selectionPanel.add(box[i], c);
		}

		for (int i = 0; i < box.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(new Color(255, 153, 153));
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, arr[i] * sizeModifier));
			insertionPanel.add(box[i], c);
		}

		for (int i = 0; i < box.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(new Color(255, 153, 153));
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, arr[i] * sizeModifier));
			quickPanel.add(box[i], c);
		}

		for (int i = 0; i < box.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(new Color(255, 153, 153));
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, arr[i] * sizeModifier));
			mergePanel.add(box[i], c);
		}

	}

	/************
	 * ReDrawForSelectionPanel
	 ***********************************************************/
	public void reDrawBoxesInSelectionPanel(int[] array, int currentIndex, int comparingIndex) {

		selectionPanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			if (i == currentIndex) {
				box[i].setBackground(Color.GREEN);
			} else if (i == comparingIndex) {
				box[i].setBackground(Color.RED);
			} else {
				box[i].setBackground(new Color(255, 153, 153));
				box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			}
			selectionPanel.add(box[i], c);
		}
		selectionPanel.repaint();
		selectionPanel.revalidate();

	}

	/************
	 * ReDrawForBubblePanel
	 ***********************************************************/

	public void reDrawBoxesInBubblePanel(int[] array, int currentIndex, int comparingIndex) {

		bubblePanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			if (i == currentIndex) {
				box[i].setBackground(Color.GREEN);
			} else if (i == comparingIndex) {
				box[i].setBackground(Color.RED);
			} else {
				box[i].setBackground(new Color(255, 153, 153));
				box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			}
			bubblePanel.add(box[i], c);
		}
		bubblePanel.repaint();
		bubblePanel.revalidate();

	}

	/************
	 * ReDrawForBubblePanel
	 ***********************************************************/

	public void reDrawBoxesInInsertionPanel(int[] array, int currentIndex, int comparingIndex) {

		insertionPanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			if (i == currentIndex) {
				box[i].setBackground(Color.GREEN);
			} else if (i == comparingIndex) {
				box[i].setBackground(Color.RED);
			} else {
				box[i].setBackground(new Color(255, 153, 153));
				box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			}
			insertionPanel.add(box[i], c);
		}
		insertionPanel.repaint();
		insertionPanel.revalidate();

	}

	/************
	 * ReDrawForMergePanel
	 ***********************************************************/

	public void reDrawBoxesMergePanel(int[] array, int currentIndex, int comparingIndex, int readingIndex) {

		mergePanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			int num = array[i];
			String s = "" + num;
			JLabel label = new JLabel(s);
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			if (i == currentIndex) {
				box[i].setBackground(Color.GREEN);
			} else if (i == comparingIndex) {
				box[i].setBackground(Color.RED);
			} else if (i == readingIndex) {
				box[i].setBackground(Color.yellow);
			} else {
				box[i].setBackground(new Color(255, 153, 153));
				box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			}

			mergePanel.add(box[i], c);
		}
		mergePanel.repaint();
		mergePanel.revalidate();

	}
	
	/************
	 * ReDrawForQuickPanel
	 ***********************************************************/

	public void reDrawBoxesQuickPanel(int[] array, int currentIndex, int comparingIndex, int readingIndex) {

		quickPanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			int num = array[i];
			String s = "" + num;
			JLabel label = new JLabel(s);
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			if (i == currentIndex) {
				box[i].setBackground(Color.GREEN);
			} else if (i == comparingIndex) {
				box[i].setBackground(Color.RED);
			} else if (i == readingIndex) {
				box[i].setBackground(Color.yellow);
			} else {
				box[i].setBackground(new Color(255, 153, 153));
				box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			}

			quickPanel.add(box[i], c);
		}
		quickPanel.repaint();
		quickPanel.revalidate();

	}
	
	/*********************
	 * Set Selection panel when done sorting to Green
	 **************************************************************/

	public void setSelectionPanleToGreen(int[] array) {

		selectionPanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(Color.green);
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			selectionPanel.add(box[i], c);
		}
		selectionPanel.repaint();
		selectionPanel.revalidate();

	}

	/*********************
	 * Set Bubble panel when done sorting to Green
	 **************************************************************/

	public void setBubblePanleToGreen(int[] array) {

		bubblePanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(Color.green);
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			bubblePanel.add(box[i], c);
		}
		bubblePanel.repaint();
		bubblePanel.revalidate();

	}

	/*********************
	 * Set Insertion panel when done sorting to Green
	 **************************************************************/

	public void setInsertionPanleToGreen(int[] array) {

		insertionPanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(Color.green);
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			insertionPanel.add(box[i], c);
		}
		insertionPanel.repaint();
		insertionPanel.revalidate();

	}

	/*********************
	 * Set Merge panel when done sorting to Green
	 **************************************************************/

	public void setMergePanelToGreen(int[] array) {

		mergePanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(Color.green);
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			mergePanel.add(box[i], c);
		}
		mergePanel.repaint();
		mergePanel.revalidate();

	}
	
	/*********************
	 * Set Quick panel when done sorting to Green
	 **************************************************************/

	public void setQuickPanelToGreen(int[] array) {

		quickPanel.removeAll();
		for (int i = 0; i < array.length; i++) {
			box[i] = new JPanel();
			box[i].setBackground(Color.green);
			box[i].setBorder(new LineBorder(new Color(0, 51, 102), 2));
			box[i].setPreferredSize(new Dimension(7, array[i] * sizeModifier));
			quickPanel.add(box[i], c);
		}
		quickPanel.repaint();
		quickPanel.revalidate();

	}
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
