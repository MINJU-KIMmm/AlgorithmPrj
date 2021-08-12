//선택정렬 selection sorting
#include <stdio.h>

#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t))

void SelectionSort(int list[], int n) {
	int i, j, least, temp;

	for (i = 0; i < n - 1; i++) {
		least = i;
		for (j = i + 1; j < n; j++) 
			if (list[j] < list[least])least = j;
		SWAP(list[i], list[least], temp);
	}	
}

int main() {
	int list[5] = { 4,3,5,1,7 };
	SelectionSort(list, 5);

	for (int i = 0; i < 5; i++) {
		printf("%d ", list[i]);
	}
	printf("\n");
	return 0;
}