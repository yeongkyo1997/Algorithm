#include <iostream>
using namespace std;
int main() {
    int N;
    int a[1000];
    scanf("%d", &N);
    for(int i=0; i<N; i++) scanf("%d", &a[i]);
    int max = 0;
    int sum = 0;
    for(int i=0; i<N; i++) {
        if( a[i]>max ) max=a[i];
        sum += a[i];
    }
    printf("%f", 100.0*sum/N/max);
}