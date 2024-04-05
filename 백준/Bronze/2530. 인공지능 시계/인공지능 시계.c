#include<stdio.h>

main(){
	int h, m, s, D;
	scanf("%d %d %d", &h, &m, &s);
	scanf("%d", &D);
	
	h = (h + (m + (s + D) / 60) / 60) % 24; 
	m = (m + (s + D) / 60) % 60;
	s = (s + D) % 60;
	
	printf("%d %d %d", h, m, s);
}