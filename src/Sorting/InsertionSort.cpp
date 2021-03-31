//삽입정렬 insertion sorting
#include <stdio.h>

#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t))

void InsertionSort(int list[], int n) {
	int i, j, key;
	for (i = 1; i < n; i++) {
		key = list[i];
		for (j = i - 1; j >= 0 && list[j] > key; j--)
			list[j + 1] = list[j];
		list[j + 1] = key;
	}
}

int main() {
	int list[5] = { 4,3,5,1,7 };
	InsertionSort(list, 5);

	for (int i = 0; i < 5; i++) {
		printf("%d ", list[i]);
	}
	printf("\n");
	return 0;
}