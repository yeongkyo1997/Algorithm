#include <iostream>
#include <vector>
#include <cstdio>
#include <algorithm>
#include <queue>

using namespace std;

int u, v, n;
double cnt,w;
int a[500001];
 
//1번노드에 들어가 있는 물의 양
int main() {
    cin >> n >> w;

	for(int i = 1 ; i<=n-1; i++) {
		cin >> u >> v;
		a[u]++;
		a[v]++;
	}
	for (int i = 2; i <= n; i++) {
		if (a[i] == 1)             
			cnt++;
	}
	printf("%.10f", w / cnt);    
}