#include<stdio.h>

int main() {
    int n, i, j, k;
    scanf("%d", &n);
    for(i=0; i<2*n-1; i++) {
        k = i < n ? i : 2*n-2-i;
        for(j=0; j<k+1; j++) {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}