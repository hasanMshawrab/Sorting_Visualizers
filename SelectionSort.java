package CSC310_Project;

import java.awt.Color;
import java.awt.desktop.ScreenSleepEvent;

public class SelectionSort implements Runnable {

	private int[] array;
	private VisualizerFrame window;
	private allAlgoFrame frame;
	private String chooseFrame;

	public SelectionSort(int[] array, VisualizerFrame window) {
		super();
		this.array = array;
		this.window = window;
		this.chooseFrame = "window";
	}

	public SelectionSort(int[] array, allAlgoFrame frame) {
		super();
		this.array = array;
		this.frame = frame;
		this.chooseFrame = "frame";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (chooseFrame.equalsIgnoreCase("window")) {
			runSelectionSort();
		} else {
			runSelectionSort2();
		}
	}

	public static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}

		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;

	}

	public void runSelectionSort() {

		for (int lastUnsortedindex = array.length - 1; lastUnsortedindex > 0; lastUnsortedindex--) {
			int largestIndex = 0;
			for (int i = 1; i <= lastUnsortedindex; i++) {
				while(window.stopBtn.isSelected()) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (array[i] > array[largestIndex]) {
					largestIndex = i;
				}

				window.reDrawBoxes(array, largestIndex, i - 1);
				try {
					Thread.sleep(Main.speed1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			swap(array, largestIndex, lastUnsortedindex);
		}

		window.reDrawBoxes(array, -1, -1);

		Main.isSorted = true;
		window.showMessage();
		window.startBtn.setSelected(false);
		window.startBtn.setBackground(new Color(240, 240, 240));
	}

	/**************
	 * For All Sorting Frame
	 *************************/

	public void runSelectionSort2() {

		for (int lastUnsortedindex = array.length - 1; lastUnsortedindex > 0; lastUnsortedindex--) {
			int largestIndex = 0;
			for (int i = 1; i <= lastUnsortedindex; i++) {

				if (array[i] > array[largestIndex]) {
					largestIndex = i;
				}

				frame.reDrawBoxesInSelectionPanel(array, largestIndex, i - 1);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			swap(array, largestIndex, lastUnsortedindex);
		}

		frame.reDrawBoxesInSelectionPanel(array, -1, -1);
		frame.setSelectionPanleToGreen(array);
		Main.selectionPanel = true;
	}

};
