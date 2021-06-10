package CSC310_Project;

import java.awt.Color;

public class InsertionSort implements Runnable {

	private int[] array;
	private VisualizerFrame window;
	private allAlgoFrame frame;
	private String chooseFrame;

	public InsertionSort(int[] array, VisualizerFrame window) {
		super();
		this.array = array;
		this.window = window;
		this.chooseFrame = "window";
	}

	public InsertionSort(int[] array, allAlgoFrame frame) {
		super();
		this.array = array;
		this.frame = frame;
		this.chooseFrame = "frame";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (chooseFrame.equalsIgnoreCase("window")) {
			runInsertionSort();
		} else {
			runInsertionSort2();
		}

	}

	public void runInsertionSort() {

		int temp = 0;
		int insert = 0;
		for (int i = 1; i < array.length; i++) {
			insert = i;
			for (int j = i - 1; j >= 0; j--) {
				// when pressing stop button
				while(window.stopBtn.isSelected()) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (array[i] < array[j]) {
					insert = j;
					if (j == 0) {
						break;
					}
				} else {
					break;
				}
				window.reDrawBoxes(array, i, insert);
				try {
					Thread.sleep(Main.speed1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			temp = array[i];
			for (int j = i; j > insert; j--) {
				array[j] = array[j - 1];
			}
			array[insert] = temp;
		}
		window.reDrawBoxes(array, -1, -1);

		Main.isSorted = true;
		window.showMessage();
		window.startBtn.setSelected(false);
		window.startBtn.setBackground(new Color(240, 240, 240));

	}
	
	
	/*********************************************************************************/
	
	public void runInsertionSort2(){

		int temp = 0;
		int insert = 0;
		for (int i = 1; i < array.length; i++) {
			insert = i;
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] < array[j]) {
					insert = j;
					if (j == 0) {
						break;
					}
				} else {
					break;
				}
				frame.reDrawBoxesInInsertionPanel(array, i, insert);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			temp = array[i];
			for (int j = i; j > insert; j--) {
				array[j] = array[j - 1];
			}
			array[insert] = temp;
		}
		frame.reDrawBoxesInInsertionPanel(array, -1, -1);
		frame.setInsertionPanleToGreen(array);
		Main.insertionPanel = true;
		
	}
	
	

}
