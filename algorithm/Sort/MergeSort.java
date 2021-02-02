
public class MergeSort {
	

	public void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
		
	}
	
	// 합병 정렬
	private void mergeSort(int[] arr, int start, int end) {
		
		if(start < end) {
			int middle = (start + end) / 2;
			
			// 분할
			mergeSort(arr, start, middle);
			mergeSort(arr,middle+1, end);
			
			// 합병
			merge(arr, start, middle, end);
		}
	}
	
	// 합병
	public void merge(int[] arr, int start, int middle, int end) {
		int i = start, j = middle + 1, k = i;
		int[] temp = new int[arr.length];
		
		while(i <= middle && j <= end) {
			if(arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
			}
		}
		
		while(i <= middle) {
			temp[k++] = arr[i++];
		}
		while(j <= end) {
			temp[k++] = arr[j++];
		}
		
		// 원래 배열에 복사
		for(int r=start; r<=end; r++) {
			arr[r] = temp[r];
		}
	}
	
	public void print(int[] arr) {
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {2, 5, 4, 1, 9, 8, 7, 6, 3, 0};
		MergeSort sort = new MergeSort();
		sort.print(arr);
		sort.mergeSort(arr);
		sort.print(arr);
	}

}
