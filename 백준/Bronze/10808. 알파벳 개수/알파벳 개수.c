#include<stdio.h>
#include<string.h>

int main(){
    char S[100];
    int arr[26] = { 0, };
    
    scanf("%s", &S);
    
	for (int i = 0; i < strlen(S); i++)
	{
		int idx = S[i] - 'a';
		arr[idx]++;
	}

	for (int i = 0; i < 26; i++)
	{
		printf("%d ", arr[i]);
	}	
    
    return 0;
}