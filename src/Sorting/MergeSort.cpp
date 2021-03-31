//병합정렬 merge sorting
#include <stdio.h>
#define MAX_SIZE 15

int sorted[MAX_SIZE];

void merge(int list[], int left, int mid, int right) {
	int i, j, k, l;
	i = left;
	j = mid + 1;
	k = left;

	//분할 정렬된 list 합병
	while (i <= mid && j <= right) {
		if (list[i] <= list[j])
			sorted[k++] = list[i++];
		else sorted[k++] = list[j++];
	}

	if (i > mid) //남아있는 레코드 일괄복사
		for (l = j; l <= right; l++)
			sorted[k++] = list[l];
	else
		for (l = i; l <= mid; l++)
			sorted[k++] = list[l];

	for (l = left; l <= right; l++)
		list[l] = sorted[l];
}

void MergeSort(int list[], int left, int right) {
	int mid;
	if (left < right) {
		mid = (left + right) / 2;
		MergeSort(list, left, mid);
		MergeSort(list, mid + 1, right);
		merge(list, left, mid, right);
	}
}

int main() {
	int list[5] = { 4,3,5,1,7 };
	MergeSort(list, 0, 4);

	for (int i = 0; i < 5; i++) {
		printf("%d ", list[i]);
	}
	printf("\n");
	return 0;
}