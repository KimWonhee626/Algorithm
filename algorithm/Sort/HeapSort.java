
public class HeapSort {
	public void heapSort(int[] arr) {
		int size = arr.length - 1;
		buildHeap(arr, size); // 주어진 배열 최대힙으로 만듬
		sort(arr, size);
		
	}
	
	public void downHeap(int[] arr, int i, int size) {
		int left = i * 2;
		int right = i * 2 + 1;
		int greater = i;
		
		if(left > size) { // 자식이 없는 노드일때
			return;
		}
		
		greater = left;
		if(right <= size) {
			if(arr[right] > arr[greater]) {
				greater = right;
			}
		}
		
		if(arr[i] < arr[greater]) { // 자식들보다 부모가 작으면 교환
			swap(arr, i, greater); // 더 큰 자식과 swap
			downHeap(arr, greater, size);
		}
	}
	
	// 최대힙 만들기
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
	
	public void sort(int[]arr, int size) { // 힙정렬
		for(int i=size; i > 1; i--) {
			swap(arr, 1, i); // 마지막 노드와 루트 swap
			buildHeap(arr, i-1); // 루트노드를 기준으로 최대힙 만들기
			
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
		// 배열 인덱스 1부터 시작
		int[] arr = new int[] {-1, 2, 5, 4, 1, 9, 8, 7, 6, 3, 0};
		
		HeapSort heap = new HeapSort();
		
		heap.print(arr);
		heap.heapSort(arr);
		heap.print(arr);
	}
	
}
