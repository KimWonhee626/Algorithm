
public class HeapSort {
	public void heapSort(int[] arr) {
		int size = arr.length - 1;
		buildHeap(arr, size); // �־��� �迭 �ִ������� ����
		sort(arr, size);
		
	}
	
	public void downHeap(int[] arr, int i, int size) {
		int left = i * 2;
		int right = i * 2 + 1;
		int greater = i;
		
		if(left > size) { // �ڽ��� ���� ����϶�
			return;
		}
		
		greater = left;
		if(right <= size) {
			if(arr[right] > arr[greater]) {
				greater = right;
			}
		}
		
		if(arr[i] < arr[greater]) { // �ڽĵ麸�� �θ� ������ ��ȯ
			swap(arr, i, greater); // �� ū �ڽİ� swap
			downHeap(arr, greater, size);
		}
	}
	
	// �ִ��� �����
	public void buildHeap(int[] arr, int size) {
		for(int i = size / 2; i > 0; i--) {
			downHeap(arr, i, size);
		}
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void sort(int[]arr, int size) { // ������
		for(int i=size; i > 1; i--) {
			swap(arr, 1, i); // ������ ���� ��Ʈ swap
			buildHeap(arr, i-1); // ��Ʈ��带 �������� �ִ��� �����
			
			print(arr);
		}
	}
	
	public void print(int[] arr) {
		for(int i=1; i<arr.length ; i++) {
			
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		// �迭 �ε��� 1���� ����
		int[] arr = new int[] {-1, 2, 5, 4, 1, 9, 8, 7, 6, 3, 0};
		
		HeapSort heap = new HeapSort();
		
		heap.print(arr);
		heap.heapSort(arr);
		heap.print(arr);
	}
	
}
