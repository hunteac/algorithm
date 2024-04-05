#include<stdio.h>
#include<stdbool.h>
#include<limits.h>

#ifndef getMin
#define getMin(a,b) (((a) > (b)) ? (a) = (b) : (a))
#endif

main(){
	int E, S, M, year, min;
	scanf("%d %d %d", &E, &S, &M);
	
	year = 0;
	
	while(true)
	{
		min = INT_MAX;
		
		getMin(min, E);
		getMin(min, S);
		getMin(min, M);
		
		E -= min;
		E = E == 0 ? E = 15 : E;
		S -= min;
		S = S == 0 ? S = 28 : S;
		M -= min;
		M = M == 0 ? M = 19 : M;

		year += min;		
		
		if (E == 15 && S == 28 && M == 19) break;
	}
	
	printf("%d", year);
}