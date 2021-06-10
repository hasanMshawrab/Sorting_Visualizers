package CSC310_Project;

import java.awt.Color;

public class QuickSort implements Runnable{

	private int[] array;
	private static VisualizerFrame window;
	private static allAlgoFrame frame;
	private String chooseFrame;
	
	public QuickSort(int[] array, VisualizerFrame window) {
		super();
		this.array = array;
		this.window = window;
		this.chooseFrame = "window";
	}


	public QuickSort(int[] array, allAlgoFrame frame) {
		super();
		this.array = array;
		this.frame = frame;
		this.chooseFrame = "frame";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (chooseFrame.equalsIgnoreCase("window")) {
			runQuickSort(array, 0, array.length-1);
			Main.isSorted = true;
			window.showMessage();
			window.startBtn.setSelected(false);
			window.startBtn.setBackground(new Color(240, 240, 240));
		} else {
			runQuickSort2(array, 0, array.length-1);
			frame.setQuickPanelToGreen(array);
			Main.quickPanel=true;
		}
	}


	private static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	private static int partition(int[] arr, int low, int high)
	{
	     
	    int pivot = arr[high];
	    
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	        if (arr[j] < pivot)
	        {
	            i++;
	            swap(arr, i, j);
	        }
	    	window.reDrawBox2(arr, high, j+1, j);
	    	try {
				Thread.sleep(Main.speed1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    swap(arr, i + 1, high);
	    window.reDrawBox2(arr, pivot, low, high);
		try {
			Thread.sleep(Main.speed1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    return (i + 1);
	}
	
	static void runQuickSort(int[] arr, int low, int high)
	{
	    if (low < high)
	    {
	        int pi = partition(arr, low, high);
	        runQuickSort(arr, low, pi - 1);
	        runQuickSort(arr, pi + 1, high);
	    }
	}
	
	/****
	 * For the allFramVisualizer
	 */
	
	private static int partition2(int[] arr, int low, int high)
	{
	     
	    int pivot = arr[high];
	    
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	        if (arr[j] < pivot)
	        {
	            i++;
	            swap(arr, i, j);
	        }
	    	frame.reDrawBoxesQuickPanel(arr, high, j+1, j);
	    	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    swap(arr, i + 1, high);
	    frame.reDrawBoxesQuickPanel(arr, pivot, low, high);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    return (i + 1);
	}
	
	static void runQuickSort2(int[] arr, int low, int high)
	{
	    if (low < high)
	    {
	        int pi = partition2(arr, low, high);
	        runQuickSort2(arr, low, pi - 1);
	        runQuickSort2(arr, pi + 1, high);
	    }
	}
	

}
