# 정렬 알고리즘 2(합병, 퀵)
</br>
</br>

## 4. 합병 정렬(Merge Sort)
합병 정렬은 분할 정복 방식에 기초한 정렬 알고리즘입니다. 분할 정복이란 입력된 데이터를 둘 이상의 분리된 부분 집합으로 나눠 문제를 해결한 후, 부문제들에대한 해결을 합쳐 전체 문제의 해결을 구하는 방법입니다.  
분할은 배열의 크기가 1보다 작거나 같아질 때 까지 반복합니다.  
</br>

합병 정렬은 배열을 반으로 쪼개는 분할과 그 배열을 다시 합치는 합병의 과정으로 나눌 수 있습니다.
</br>

**분할** 과정의 로직은 배열의 크기가 0또는 1이 될 때 까지 배열을 계속 반으로 쪼개는 것입니다.  
**합병** 과정의 로직은 분할된 두 배열 A, B가 있고, 각각의 시작 인덱스를 i, j라 하면 A[i]와 B[j]를 비교하여 더 작은값을 새로운 배열 C에 저장합니다. 그리고 그 배열의 인덱스와 C의 인덱스를 1증가시킵니다.  
이러한 과정을 A또는 B배열의 끝에 도달할 때 까지 반복한 후, 남은 배열의 나머지 원소들을 C에 저장합니다.  
C를 원래 배열에 저장합니다.  
</br>

<img width="926" alt="합병정렬" src="https://user-images.githubusercontent.com/69297345/106427685-205bbb80-64ab-11eb-965f-18ed6de98a90.png">
</br>
</br>

### 4.1 합병 정렬 구현 코드
```java
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
```
</br>
</br>

### 4.2 정리
합병 정렬은 **비교**에 기초한 정렬이며, 힙정렬과 같은 **O(nlogn)** 의 시간복잡도를 가집니다. 선택, 삽입정렬에 비하면 시간이 적게 걸리기 때문에 대규모 입력에 적합합니다.  
또한 정렬을 위한 배열을 하나 더 사용하므로 제자리 정렬에 해당하지는 않습니다.
</br>
</br>
</br>

## 5. 퀵 정렬(Quick Sort)
퀵 정렬도 병합 정렬과 마찬가지로 분할 정복 방식에 기초한 정렬 알고리즘 입니다.  
병합 정렬과의 차이점은 항상 가운데를 기준으로 분할을 하는 병합 정렬과 달리, 퀵 정렬은 피봇(pivot)이라고 불리는 **임의의 기준값을 정하여 분할**합니다.  
</br>

pivot을 정한 후 pivot보다 작은 값들은 모두 pivot의 왼편으로, 큰 값들은 오른쪽으로 이동시킵니다.  
이제 pivot을 기준으로 나뉜 두 배열에서 또 각각의 pivot을 정하여 같은 과정을 반복합니다.
</br>

<img width="837" alt="퀵정렬" src="https://user-images.githubusercontent.com/69297345/106537313-67928c80-653d-11eb-99c3-c0e44c391e52.png">
</br>
</br>

### 5.1 퀵 정렬 구현 코드
```java
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
		int pivot = arr[(start + end) / 2];
		
		while(start < end) {
			while((arr[start] < pivot) && (start < end)) {
				start++;
			}
			
			while((arr[end] > pivot) && (start < end)){
				end--;
			}
			
			if(start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		
		return start;
	}
```
</br>
</br>

### 5.2 정리
퀵 정렬도 분할 정복 방식이지만 병합 정렬과는 큰 차이가 있습니다. 병합 정렬은 항상 정가운데 인덱스를 기준으로 분할 후 병합 시점에서 비교 연산이 발생하지만, 퀵 정렬은 분할 시점부터 비교 연산이 일어납니다. 따라서 그 이후 병합을 할때 소요되는 비용이 매우 적어지게 됩니다.
</br>

퀵 정렬의 성능은 pivot을 어떻게 선택하느냐에 따라서 크게 달라집니다. 이상적인 경우 pivot을 기준으로 왼쪽과 오른쪽이 **동일한 개수의 값들로 분할**된다면 **O(nlogn)** 의 시간복잡도를 가지게 됩니다.  
하지만 pivot값이 한 쪽으로 크게 치우친 경우 최악의 경우에 **O(n^2)** 의 시간 복잡도를 가지게 됩니다.  
따라서 중앙값에 가까운 pivot을 선택하는것이 효율을 높이는데 중요하게 작용합니다.  
또한 **제자리 정렬**로 구현 가능합니다.  




