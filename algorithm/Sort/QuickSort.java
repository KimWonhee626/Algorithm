
public class QuickSort {
	public void quickSort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}
	
	
	// 정렬(재귀함수)
	private void sort(int[] arr, int start, int end) {
		if(start < end) {
			int mid = partition(arr, start, end);
			
			sort(arr, start, mid - 1);
			sort(arr, mid + 1, end);
		}
		
	}	
	
	
	// 분할
	public int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2]; // 가운데값 저장
		
		while(start < end) {
			while((arr[start] < pivot) && (start < end)) {
				start++;
			}
			
			while((arr[end] > pivot) && (start < end)){
				end--;
			}
			
			if(start < end) { // pivot을 기준으로 왼쪽에는 더 작은값, 오른쪽에는 더 큰 값 저장
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		
		return start;
	}
	
	
	// 출력
	public void print(int[] arr) {
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {2, 9, 4, 1, 5, 8, 7, 6, 3, 0};
		QuickSort sort = new QuickSort();
		sort.print(arr);
		sort.quickSort(arr);
		sort.print(arr);
		
	}

}
