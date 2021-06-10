package CSC310_Project;

import java.awt.Color;

public class MergeSort implements Runnable {

	private int[] array;
	private VisualizerFrame window;
	private allAlgoFrame frame;
	private String chooseFrame;

	public MergeSort(int[] array, VisualizerFrame window) {
		super();
		this.array = array;
		this.window = window;
		this.chooseFrame = "window";
	}
	
	
	
	public MergeSort(int[] array, allAlgoFrame frame) {
		super();
		this.array = array;
		this.frame = frame;
		this.chooseFrame = "frame";
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (chooseFrame.equalsIgnoreCase("window")) {
		runMergeSort(array, 0, array.length-1);
		Main.isSorted = true;
		window.showMessage();
		window.startBtn.setSelected(false);
		window.startBtn.setBackground(new Color(240, 240, 240));
		}else {
			runMergeSort2(array, 0, array.length-1);
			frame.setMergePanelToGreen(array);
			Main.mergePanel=true;
		}
	}

	public void runMergeSort(int[] x, int start, int end) {
		int mid, left, right;
		int tmp;

		if (start >= end)
			return;

		mid = (start + end) / 2;

		runMergeSort(x, start, mid);
		runMergeSort(x, mid + 1, end);

		left = start;
		right = mid + 1;

		if (x[mid] <= x[right]) {
			return;
		}

		while (left <= mid && right <= end) {
			// when pressing stop button
			while(window.stopBtn.isSelected()) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (x[left] <= x[right]) {
				left++;
			} else {
				tmp = x[right];
				for (int i = right - left; i > 0; i--) {
					x[left + i] = x[left + i - 1];
				}
				x[left] = tmp;
				left++;
				mid++;
				right++;
			}
			window.reDrawBox2(x, mid, right, left);
			try {
				Thread.sleep(Main.speed1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*************************************************************************/
	
	public void runMergeSort2(int[] x, int start, int end) {
		int mid, left, right;
		int tmp;

		if (start >= end)
			return;

		mid = (start + end) / 2;

		runMergeSort2(x, start, mid);
		runMergeSort2(x, mid + 1, end);

		left = start;
		right = mid + 1;

		if (x[mid] <= x[right]) {
			return;
		}

		while (left <= mid && right <= end) {

			if (x[left] <= x[right]) {
				left++;
			} else {
				tmp = x[right];
				for (int i = right - left; i > 0; i--) {
					x[left + i] = x[left + i - 1];
				}
				x[left] = tmp;
				left++;
				mid++;
				right++;
			}
			frame.reDrawBoxesMergePanel(x, mid, right, left);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
