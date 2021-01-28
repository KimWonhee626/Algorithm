
public class Sort_1 {
	
	public void selectionSort(int[] arr) {
		selectionSort(arr, arr.length);
	}
	
	
	// ��������
	private void selectionSort(int[] arr, int size) {
		for(int i=0; i<size-1; i++) {
			int minIdx = i;
			
			for(int j=i+1; j<size; j++) {
				if(arr[j] < arr[minIdx])
					minIdx = j;
			}
		
			swap(arr, minIdx, i);
		}
	}
	
	
	// ��������
	public void insertionSort(int[] arr) {
		insertionSort(arr, arr.length);
	}
	
	private void insertionSort(int[] arr, int size) {
		for(int i=1; i<size; i++) { // �ι�° �ε������� ����
			int cur = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>cur) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = cur;
		}
	}
	
	public void bubbleSort(int[] arr) {
		bubbleSort(arr, arr.length);
	}
	
	private void bubbleSort(int[] arr, int size) {
		for(int i=0; i<size-1; i++) { // �ݺ� Ƚ���� ��Ÿ��
			for(int j=i; j<size-i-1; j++) {
				if(arr[j] > arr[j+1])
					swap(arr,j,j+1);
			}
		}
	}
	
	
	// �迭�� i��° ���ҿ� j��° ���Ҹ� swap
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
