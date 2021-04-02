//퀵정렬 quick sorting
#include <stdio.h>

#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t))

int partition(int list[], int left, int right) {
	int pivot, temp;
	int low, high;

	low = left;
	high = right + 1;
	pivot = list[left];
	do {
		do
			low++;
		while (low <= right && list[low] < pivot);
		do
			high--;
		while (high >= left && list[high] > pivot);
		if (low < high) SWAP(list[low], list[high], temp);
	} while (low < high);

	SWAP(list[left], list[high], temp);
	return high;
}

void QuickSort(int list[], int left, int right) {
	if (left < right) {
		int q = partition(list, left, right);
		QuickSort(list, left, q - 1);
		QuickSort(list, q + 1, right);
	}
}

int main() {
	int list[5] = { 4,3,5,1,7 };
	QuickSort(list, 0, 4);

	for (int i = 0; i < 5; i++) {
		printf("%d ", list[i]);
	}
	printf("\n");
	return 0;
}