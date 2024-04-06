#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

int main(){
    int A, B;
    
    scanf("%d %d", &A, &B);
    
    int num = A / 2;
    
    if (B >= num)
    {
    	printf("%d", num);
	}
	else
	{
		printf("%d", B);
	}
    
    return 0;
}