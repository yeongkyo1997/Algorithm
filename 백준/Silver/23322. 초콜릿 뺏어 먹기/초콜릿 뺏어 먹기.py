input = __import__('sys').stdin.readline
mis = lambda: map(int, input().split())
ii = lambda: int(input())

n, k = mis()
a = list(mis())
print(sum(a) - n*a[0], n - a.count(a[0]))