//개선된 버블 정렬 improved bubble sorting
#include <stdio.h>

#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t))

void ImprovedBubbleSort(int list[], int n) {
	int i, j, least, temp, flag=true;
	j = 0;
	while ((j < n - 1) && flag) {
		flag = false;
		for(i=n-1;i>j;i--)
			if (list[i] < list[i - 1]) {
				SWAP(list[i], list[i - 1], temp);
				flag = true;
			}
		j++;
	}
}

int main() {
	int list[5] = { 4,3,5,1,7 };
	ImprovedBubbleSort(list, 5);

	for (int i = 0; i < 5; i++) {
		printf("%d ", list[i]);
	}
	printf("\n");
	return 0;
}