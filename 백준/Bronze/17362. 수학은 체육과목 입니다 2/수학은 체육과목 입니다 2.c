#include<stdio.h>

main(){
	int n;
	scanf("%d", &n);
	
	int answer;
	
	if (n <= 5)
	{
		answer = n;
	}
	else
	{
		int num = (n - 6) / 4;
		if (num % 2 == 0)
		{
			answer = 4 - (n % (6 + num * 4));
		}
		else
		{
			answer = 2 + (n % (6 + num * 4));
		}
	}
	
	printf("%d", answer); 
}