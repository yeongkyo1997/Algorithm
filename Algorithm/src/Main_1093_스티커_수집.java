////스티커 수집
//#include<bits/stdc++.h>
//        #define pb push_back
//        #define lli long long
//        #define mp make_pair
//        #define fst first
//        #define snd second
//        using namespace std;
//
//        #define it map<int,int>::iterator
//
//        int n, price[35], value[35],k;
//        map<int,int> r,l;
//
//        void f(int idx, int p, int val, bool isLeft){
//        if(isLeft && idx == (n+1)/2){
//        if(l.count(-val) && l[-val]<p);
//        else l[-val] = p;
//        return;
//        }
//        if(!isLeft && idx == n){
//        if(r.count(-val) && r[-val]<p);
//        else r[-val] = p;
//        return;
//        }
//        f(idx+1,p,val,isLeft);
//        f(idx+1,p+price[idx],val+value[idx],isLeft);
//        }
//
//        int main(){
//        cin >> n;
//        for(int i=0; i<n; i++) cin >> price[i];
//        for(int i=0; i<n; i++) cin >> value[i];
//        cin >> k;
//
//        int sum = 0, cnt, a;
//        cin >> cnt;
//        while(cnt--){
//        cin >> a;
//        sum += price[a];
//        }
//
//        f(0,0,0,1);
//        f((n+1)/2,0,0,0);
//
//        vector<int> lkey, rkey;
//
//        int min_v = 1e9;
//        for(it i=l.begin(); i!=l.end(); i++){
//        min_v = min(min_v, i->snd);
//        i->snd = min_v;
//        lkey.pb(-(i->fst));
//        }
//
//        min_v = 1e9;
//        for(it i=r.begin(); i!=r.end(); i++){
//        min_v = min(min_v, i->snd);
//        i->snd = min_v;
//        rkey.pb(-(i->fst));
//        }
//
//        sort(lkey.begin(), lkey.end());
//        sort(rkey.begin(),rkey.end());
//
//        int ans = 1e9;
//        for(int i=0; i<lkey.size(); i++){
//        int lval = lkey[i];
//        int idx = lower_bound(rkey.begin(), rkey.end(),
//        max(0,k-lval))-rkey.begin();
//
//        if(idx == rkey.size()) continue;
//        ans = min(ans,r[-rkey[idx]] + l[-lval]);
//        }
//        for(int i=0; i<rkey.size(); i++){
//        int rval = rkey[i];
//        int idx = lower_bound(lkey.begin(), lkey.end(),
//        max(0,k-rval))-lkey.begin();
//
//        if(idx == lkey.size()) continue;
//        ans = min(ans,r[-rval]+l[-lkey[idx]]);
//        }
//
//        if(ans == 1e9) return cout << -1,0;
//        cout << max(0,ans-sum);
//        }

//cpp to java

import java.io.*;
import java.util.StringTokenizer;

public class Main_1093_스티커_수집 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, k;
    static int[] price, value;
    static int[] lprice, lvalue, rprice, rvalue;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        price = new int[n];
        value = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) price[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) value[i] = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        int sum = 0;
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) sum += price[Integer.parseInt(br.readLine())];

        lprice = new int[n / 2];
        lvalue = new int[n / 2];
        rprice = new int[n - n / 2];
        rvalue = new int[n - n / 2];

        for (int i = 0; i < n / 2; i++) {
            lprice[i] = price[i];
            lvalue[i] = value[i];
        }
        for (int i = 0; i < n - n / 2; i++) {
            rprice[i] = price[i + n / 2];
            rvalue[i] = value[i + n / 2];
        }

        int ans = 1 << 30;
        for (int i = 0; i < (1 << n / 2); i++) {
            int lsum = 0, lval = 0;
            for (int j = 0; j < n / 2; j++) {
                if ((i & (1 << j)) != 0) {
                    lsum += lprice[j];
                    lval += lvalue[j];
                }
            }
            if (lsum > k) continue;
            for (int j = 0; j < (1 << (n - n / 2)); j++) {
                int rsum = 0, rval = 0;
                for (int l = 0; l < n - n / 2; l++) {
                    if ((j & (1 << l)) != 0) {
                        rsum += rprice[l];
                        rval += rvalue[l];
                    }
                }
                if (rsum > k - lsum) continue;
                ans = Math.min(ans, lsum + rsum - sum);
            }
        }
        if (ans == 1 << 30) System.out.println(-1);
        else System.out.println(ans);
    }
}