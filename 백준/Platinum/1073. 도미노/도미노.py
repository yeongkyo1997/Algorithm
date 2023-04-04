import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

MAP = [[0] * 11 for _ in range(11)]
numbers = [0] * 10
d = [1, 0, 1, 0, 3, 0, 15, 0, 105, 0]
number = int(input())
for i in range(number):
    temp = int(input())
    a = temp // 10
    b = temp % 10
    numbers[a] += 1
    numbers[b] += 1
result = 1
for i in range(10):
    result *= d[numbers[i]]
print(result)