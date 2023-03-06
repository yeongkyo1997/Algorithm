import collections

# import sys

# sys.setrecursionlimit(1000000)
# input = lambda: sys.stdin.readline().rstrip()

# SWEA 5658. 보물상자 비밀번호
def main():
    for _ in range(int(input())):
        N, K = map(int, input().strip().split())
        arr = list(input().strip())
        arr = arr + arr
        result = set()
        q = collections.deque()
        
        for i in range(N):
            q.append(arr[i])
            if len(q) == N // 4:
                result.add(int(''.join(q), 16))
                q.popleft()
        
        for i in range(N, N * 2):
            q.append(arr[i])
            if len(q) == N // 4:
                result.add(int(''.join(q), 16))
                q.popleft()
        
        result = list(result)
        
        result.sort(reverse=True)
        
        print(f'#{_ + 1} {result[K - 1]}')

if __name__ == '__main__':
    main()
