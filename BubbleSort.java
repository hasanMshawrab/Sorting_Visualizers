package CSC310_Project;

import java.awt.Color;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class BubbleSort implements Runnable {

	private int[] array;
	private VisualizerFrame window;
	private allAlgoFrame frame;
	private String chooseFrame;

	public BubbleSort(int[] array, VisualizerFrame window) {
		super();
		this.array = array;
		this.window = window;
		this.chooseFrame = "window";
	}
	
	
	

	public BubbleSort(int[] array, allAlgoFrame frame) {
		super();
		this.array = array;
		this.frame = frame;
		this.chooseFrame = "frame";
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(chooseFrame.equalsIgnoreCase("window")) {
			runBubbleSort();
		}else {
			runBubbleSort2();
		}

	}

	private void runBubbleSort() {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				// when pressing stop button
				while(window.stopBtn.isSelected()) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				window.reDrawBoxes(array, j, j + 1);
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
				
				try {
					Thread.sleep(Main.speed1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		Main.isSorted = true;
		window.showMessage();
		window.startBtn.setSelected(false);
		window.startBtn.setBackground(new Color(240, 240, 240));

	}

	/*******************************************************************************************/
	private void runBubbleSort2() {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				
				frame.reDrawBoxesInBubblePanel(array, j, j + 1);
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		
		frame.setBubblePanleToGreen(array);
		Main.bubblePanel = true;

	}
	
}
