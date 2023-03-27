# #include <stdio.h>
# #define INF 2147000000
#
# int s[100001];
#
# int abs(int x) {
# return x > 0 ? x : x * -1;
# }
#
# int main() {
# int N, rl = 0, rr = 0, min = INF;
# scanf("%d", &N);
#
# for (int i = 0; i < N; i++) {
#     scanf("%d", &s[i]);
# }
#
# int l = 0, r = N - 1;
# while (l < r) {
# int sum = s[l] + s[r];
#
# if (abs(sum) < min) {
# min = abs(sum);
# rl = s[l]; rr = s[r];
#
# if (min == 0) break;
# }
#
# if (sum < 0) l++;
# else r--;
# }
#
# printf("%d %d", rl, rr);
# return 0;
# }
import math

# CPP to Python3
rl = 0
N = int(input())
rr = 0
MIN = math.inf

s = list(map(int, input().split()))

l = 0
r = N - 1

while l < r:
    SUM = s[l] + s[r]

    if abs(SUM) < MIN:
        MIN = abs(SUM)
        rl, rr = s[l], s[r]

        if MIN == 0:
            break

    if SUM < 0:
        l += 1
    else:
        r -= 1

print(rl, rr)