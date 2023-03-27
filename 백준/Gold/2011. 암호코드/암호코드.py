import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

string = input()
if string[0] == '0':
    print(0)
    exit()
    
dp = [0] * (len(string) + 1)
dp[0] = 1
dp[1] = 1

for i in range(2, len(string) + 1):
    if 0 < int(string[i - 1]):
        dp[i] += dp[i - 1]
    if 10 <= int(string[i - 2:i]) <= 26:
        dp[i] += dp[i - 2]
    dp[i] %= 1000000
    
print(dp[len(string)])
