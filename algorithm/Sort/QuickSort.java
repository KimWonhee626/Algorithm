
public class QuickSort {
	public void quickSort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}
	
	
	// ����(����Լ�)
	private void sort(int[] arr, int start, int end) {
		if(start < end) {
			int mid = partition(arr, start, end);
			
			sort(arr, start, mid - 1);
			sort(arr, mid + 1, end);
		}
		
	}	
	
	
	// ����
	public int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2]; // ����� ����
		
		while(start < end) {
			while((arr[start] < pivot) && (start < end)) {
				start++;
			}
			
			while((arr[end] > pivot) && (start < end)){
				end--;
			}
			
			if(start < end) { // pivot�� �������� ���ʿ��� �� ������, �����ʿ��� �� ū �� ����
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		
		return start;
	}
	
	
	// ���
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
