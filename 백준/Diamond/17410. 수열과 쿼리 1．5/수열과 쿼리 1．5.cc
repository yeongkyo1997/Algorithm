#include <bits/stdc++.h> 

using namespace std;

#define ll long long
#define all(x) ((x).begin()),((x).end()) 

#pragma GCC optimize("Ofast")

#pragma GCC target("avx,avx2,fma") 
#pragma GCC optimization ("unroll-loops")

#define usecppio ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);



int arr[101000];
vector <int> bucket[42];

int bsize;

int n, q; int main() {
    usecppio
        cin >> n; bsize = 2500; 
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        bucket[i/bsize].push_back(arr[i]);
    }
    
    for (int i = 0; i<42; i++)
        sort(all(bucket[i]));
    cin >> q;
    while (q--) {
        int qt; cin >> qt;
        if (qt == 1) {
            int ind, val;
            
            cin >> ind >> val;
            
            ind--;
            
            int u = arr[ind];
            int p = ind/bsize;
            
            bucket[p].erase(lower_bound(all(bucket[p]),u));
            arr[ind] = val;
            bucket[p].insert(lower_bound(all(bucket[p]),val),val);
        }
        
        else if (qt == 2) {
            int l, r, val;
            cin >> l >> r >> val;
            l--; r--;
            int lbs = l/bsize + 1 - (l%bsize==0);
            lbs *= bsize; int rbe = (r/bsize) * bsize; 
            int ct = 0;
            if (lbs < rbe) {
                for (int i = l; i<lbs; i++)
                    if (arr[i] > val)
                        ct++;
                
                for (int i = rbe; i<=r; i++)
                    if (arr[i] > val)
                        ct++;
                
                int lm = lbs/bsize;
                int rm = (rbe/bsize);
                
                for (int i = lm; i < rm; i++)
                    ct += (bucket[i].end()- upper_bound(all(bucket[i]),val));
            
            }
            else {
                for (int i = l; i<=r; i++)
                    if (arr[i] > val) ct++;
            }
            cout << ct << '\n';
        }
    }
}
