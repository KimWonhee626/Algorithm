
public class Sort_1 {
	
	public void selectionSort(int[] arr) {
		selectionSort(arr, arr.length);
	}
	
	
	// 선택정렬
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
	
	
	// 삽입정렬
	public void insertionSort(int[] arr) {
		insertionSort(arr, arr.length);
	}
	
	private void insertionSort(int[] arr, int size) {
		for(int i=1; i<size; i++) { // 두번째 인덱스부터 시작
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
		for(int i=0; i<size-1; i++) { // 반복 횟수를 나타냄
			for(int j=i; j<size-i-1; j++) {
				if(arr[j] > arr[j+1])
					swap(arr,j,j+1);
			}
		}
	}
	
	
	// 배열의 i번째 원소와 j번째 원소를 swap
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
