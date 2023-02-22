import sys

input = sys.stdin.readline

n = int(input())
arr = list((map(int, input().split())))
tmp = sorted(set(arr))
dic = {tmp[i]: i for i in range(len(tmp))}

print(*[dic[i] for i in arr])
