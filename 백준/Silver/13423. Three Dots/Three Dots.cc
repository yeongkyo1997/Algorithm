#include <cstdio>
#include <unordered_map>
#include <algorithm>
#include <vector>

using namespace std;
 
 
int main() {
    int tstcase;

	scanf("%d", &tstcase);
    while(tstcase--) {
		int n;
		
		scanf("%d", &n);
		
		vector<int>a(n);
		
		unordered_map<int,int>mp;
		
		for (int i = 0;i < n;i++) {
			scanf("%d", &a[i]);
			
			mp[a[i]]=1;
		}
		
		sort(a.begin(), a.end());
		
		int cnt=0;
		
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				if ((a[i] + a[j]) % 2 != 0)
                    continue;
                else {
                    if (mp[(a[i] + a[j]) / 2] == 1)
                        cnt++;
                }
            }
 
        printf("%d\n", cnt);
 
    }
    return 0;
}