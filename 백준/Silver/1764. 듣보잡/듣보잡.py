import collections
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    dic = collections.defaultdict(int)
    for _ in range(N):
        dic[input()] += 1
    for _ in range(M):
        dic[input()] += 1
    ans = []
    for key in dic:
        if dic[key] == 2:
            ans.append(key)
    print(len(ans))
    for i in sorted(ans):
        print(i)
        

if __name__ == '__main__':
    main()