//버블정렬 bubble sorting
#include <stdio.h>

#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t))

void BubbleSort(int list[], int n) {
	int i, j, temp;
	for (int i = n - 1; i > 0; i--) {
		for (int j = 0; j < i; j++)
			if (list[j] > list[j + 1]) SWAP(list[j], list[j + 1], temp);
	}
}

int main() {
	int list[5] = { 4,3,5,1,7 };
	BubbleSort(list, 5);

	for (int i = 0; i < 5; i++) {
		printf("%d ", list[i]);
	}
	printf("\n");
	return 0;
}