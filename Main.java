package CSC310_Project;

public class Main {
	
	static VisualizerFrame window;
	static boolean started = false;
	static int[] array = { 2, 9, 6, 10, 3 };
	static boolean isSorted = false;
	static String sortAlgo;
	private static Thread soThread;
	static int speed1;
	static boolean done=false;
	/*
	 * These are for the allFrameAlgo
	 */
	static boolean selectionPanel=true;
	static boolean bubblePanel=true;
	static boolean insertionPanel=true;
	static boolean mergePanel=true;
	static boolean quickPanel=true;
	static boolean allSorted; 
	

	public static void main(String[] args) {
		
		window= new VisualizerFrame();
		window.getFrame().setVisible(true);
		window.getFrame().setLocationRelativeTo(null);
		
	}
	
	
	public static void startSorting() {
		
		switch (sortAlgo) {
		case "Bubble Sort":
			soThread = new Thread(new BubbleSort(array, window));
			break;
		case "Selection Sort":
			soThread = new Thread(new SelectionSort(array, window));
			break;
		case "Insertion Sort":
			soThread = new Thread(new InsertionSort(array, window));
			break;
		case "Merge Sort":
			soThread = new Thread(new MergeSort(array, window));
			break;
		case "Quick Sort":
			soThread = new Thread(new QuickSort(array, window));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + sortAlgo);
		}
		
		soThread.start();
		
	}

}
