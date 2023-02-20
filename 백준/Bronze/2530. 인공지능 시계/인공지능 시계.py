import sys

input = sys.stdin.readline

hour, minute, second = map(int, input().split())
cook = int(input())

total = hour * 3600 + minute * 60 + second

cook = cook + total

h = cook // 3600
cook %= 3600

m = cook // 60
cook %= 60

s = cook

print(h % 24, m, s)
