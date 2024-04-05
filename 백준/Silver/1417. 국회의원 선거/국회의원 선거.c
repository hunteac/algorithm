#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

int main(){
	int N, max, min, maxCnt;
	int *cnt;
	
	scanf("%d", &N);
	
	if (N == 1) // 0 
	{
		printf("%d", 0);
		return 0;
	}

	cnt = (int *) malloc(sizeof(int) * N); // 배열 크기를 동적으로 할당 

	max = min = maxCnt = 0;
	
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &cnt[i]);
		if (cnt[i] > max) max = cnt[i];
	}
	
	bool chk = false;
	
	while(cnt[0] <= max) 
	{
		max = 0;
		for (int i = 0; i < N; i++) 
		{
			if (cnt[i] > max) {
				max = cnt[i];	
				maxCnt = 1;
			}
			else if (cnt[i] == max)
			{
				maxCnt++;
			}
		}
		
		for (int i = 1; i < N; i++) 
		{
			if (cnt[i] == max)
			{
				cnt[i]--;
				cnt[0]++;
				maxCnt--;
				min++;
			}
			if (cnt[0] > max || (cnt[0] == max && maxCnt == 0))
			{
				chk = true;
				break;		
			}
		}
		if (chk || (cnt[0] >= max && maxCnt == 1)) break;
	}
	
	printf("%d", min);
	
	return 0;
}