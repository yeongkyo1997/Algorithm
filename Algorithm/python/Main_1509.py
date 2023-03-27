# #include <iostream>
# #include <cstring>
#
# #define INF 1e9+7
#
# using namespace std;
#
# bool dp[2501][2501];
# string str;
# int N, res[2501];
#
# bool is_palin(int st, int ed){
# if(ed > N) return false;
#
# if(str[st] == str[ed]){
# if(dp[st+1][ed-1] || ed-st == 1){
# return true;
# }
# }
# return false;
# }
#
# void fill_dptable(){
# for(int d = 0; d < N; d++){
# for(int i = 1; i+d <= N; i++){
# if(d == 0){
# dp[i][i] = true;
# continue;
# }
# if(is_palin(i, i+d)){
# dp[i][i+d] = true;
# }
# }
# }
# }
#
# void solve(){
#     fill_dptable();
#
# res[0] = 0;
# for (int i = 1; i <= N; i++) {
#     res[i] = INF;
# for (int j = 1; j <= i; j++) {
# if (dp[j][i]) {
# if (res[i] > res[j-1]+1) {
# res[i] = res[j-1]+1;
# }
# }
# }
# }
# cout << res[N];
# }
#
# int main(){
#     cin >> str;
# N = str.size();
# str = " " + str;
# solve();
#
# return 0;
# }

# cpp to py3

INF = 1e9 + 7
str = input()
N = len(str)
str = " " + str
dp = [[False for _ in range(N + 1)] for _ in range(N + 1)]
res = [0 for _ in range(N + 1)]


def is_palin(st, ed):
    if ed > N:
        return False
    if str[st] == str[ed]:
        if dp[st + 1][ed - 1] or ed - st == 1:
            return True
    return False


def fill_dptable():
    for d in range(N):
        for i in range(1, N + 1):
            if d == 0:
                dp[i][i] = True
                continue
            if is_palin(i, i + d):
                dp[i][i + d] = True


def solve():
    fill_dptable()
    res[0] = 0
    for i in range(1, N + 1):
        res[i] = INF
        for j in range(1, i + 1):
            if dp[j][i]:
                if res[i] > res[j - 1] + 1:
                    res[i] = res[j - 1] + 1
    print(res[N])


solve()
