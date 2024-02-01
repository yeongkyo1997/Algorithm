import sys


input = sys.stdin.read


N, *S = input().split()

print(*sorted(map(int, [i[::-1] for i in S])), sep='\n')