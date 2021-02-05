
public class HeapSort {
	public void heapSort(int[] arr) {
		downHeap(arr, 1, arr.length);
		
		
	}
	
	public void downHeap(int[] arr, int i, int size) {
		int left = i * 2;
		int right = i * 2 + 1;
		int greater;
		
		if(left > size) { // 자식이 없는 노드일때
			return;
		}
		
		greater = left;
		if(right <= size) {
			if(arr[right] > arr[greater]) {
				greater = right;
			}
		}
		
		if(arr[i] >= arr[greater]) {
			return;
		}
		
		int temp = arr[i];
		arr[i] = arr[greater];
		arr[greater] = temp;
		
		downHeap(arr, greater, size);
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {

	}
	
}
