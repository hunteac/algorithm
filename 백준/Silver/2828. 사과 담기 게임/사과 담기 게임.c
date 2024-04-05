#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

int main(){
    int N, M, J, min, left, right;
    
    scanf("%d %d", &N, &M);
    scanf("%d", &J);
    
    int *arr = (int*)malloc(sizeof(int) * J); // 동적할당
     
    for (int i = 0; i < J; i++)
        scanf("%d", &arr[i]); 
        
    min = 0;
    left = 1;
    right = M;
    
    for (int i = 0; i < J; i++)
    {
        if (arr[i] >= left && arr[i] <= right) 
            continue;
        
        if (arr[i] < left)
        {
            int dist = left - arr[i];
            min += dist;
            left -= dist;
            right -= dist;
        }
        else if (arr[i] > right)
        {
            int dist = arr[i] - right;
            min += dist;
            left += dist;
            right += dist;
        }
    }
    
    printf("%d", min);
    
    return 0;
}