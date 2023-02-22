#include<cstdio>
#include<algorithm>

using namespace std;

pair<int, int> p[4];

long long mini = 8e9;

int r, a[8];

int main() {
    for (int i = 0; i<4; i++)
		scanf("%d%d", &p[i].first, &p[i].second);
    
	sort(p, p + 4);
    
	do {
        for (int i = 0; i < 4; i++)
            a[i] = p[i].first*(1 - i / 2 % 2 * 2),
            a[i + 4] = p[i].second*(1 - i % 2 * 2);
      
		sort(a, a + 8);
        
		long long s = 0;
        
		for (int i = 0; i < 8; i++) 
			s += abs(a[i] - a[4]);

        if (s<mini || s == mini&&a[4]>r)
			mini = s, r = a[4];
    } while (next_permutation(p, p + 4));
    
	printf("%d", max(r * 2, 1));

    return 0;
}