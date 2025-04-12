#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
 
const int MAXT = 100000;
 
struct Node {
    int f;
    ll sum;
    ll S;
};
 
int segSize;
vector<Node> seg;
 
Node mergeNode(const Node &L, const Node &R) {
    Node res;
    res.f = L.f + R.f;
    res.sum = L.sum + R.sum;
    res.S = L.S + R.S + (ll)L.f * R.sum;
    return res;
}
 
void seg_update(int idx, int pos, int newf) {
    seg[idx].f = newf;
    seg[idx].sum = (ll) pos * newf;
    seg[idx].S = (ll) pos * ((ll)newf*(newf+1) / 2);
    for(idx /= 2; idx >= 1; idx /= 2)
        seg[idx] = mergeNode(seg[2*idx], seg[2*idx+1]);
}
 
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
 
    int N, C;
    cin >> N >> C;
    vector<int> Larr(N+1), Tarr(N+1);
    ll globalL = 0, globalT = 0;
    vector<int> freq(MAXT+1,0);
    for(int i=1;i<=N;i++){
        cin >> Larr[i] >> Tarr[i];
        globalL += Larr[i];
        globalT += Tarr[i];
        freq[Tarr[i]]++;
    }
    segSize = 1;
    while(segSize < MAXT+1) segSize *= 2;
    seg.assign(2*segSize, {0,0,0});
    for(int i=1; i<=MAXT; i++){
        int f = freq[i];
        seg[segSize + i - 1].f = f;
        seg[segSize + i - 1].sum = (ll) i * f;
        seg[segSize + i - 1].S = (ll) i * ((ll)f*(f+1)/2);
    }
    for(int i=MAXT+1; i<=segSize; i++){
        seg[segSize + i - 1] = {0,0,0};
    }
    for(int i = segSize - 1; i >= 1; i--){
        seg[i] = mergeNode(seg[2*i], seg[2*i+1]);
    }
    auto getWeightedSum = [&](){
        return seg[1].S;
    };
    auto calcTip = [&](){
        ll Sval = getWeightedSum();
        return globalL - ((ll)(N+1)*globalT - Sval);
    };
    cout << calcTip() << "\n";
    for(int i=0;i<C;i++){
        int R, newL, newT;
        cin >> R >> newL >> newT;
        globalL += (ll)newL - Larr[R];
        globalT += (ll)newT - Tarr[R];
        int posOld = Tarr[R];
        freq[posOld]--;
        seg_update(segSize + posOld - 1, posOld, freq[posOld]);
        int posNew = newT;
        freq[posNew]++;
        seg_update(segSize + posNew - 1, posNew, freq[posNew]);
        Larr[R] = newL; Tarr[R] = newT;
        cout << calcTip() << "\n";
    }
    return 0;
}
