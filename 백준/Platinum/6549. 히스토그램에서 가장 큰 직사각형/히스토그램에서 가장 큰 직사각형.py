import sys

input = lambda: sys.stdin.readline().rstrip()

def main():
    while True:
        N, *arr = list(map(int, input().split()))
        if N == 0:
            break
        
        stack = []
        result = 0
        for i in range(N):
            while stack and arr[stack[-1]] > arr[i]:
                h = arr[stack.pop()]
                w = i if not stack else i - stack[-1] - 1
                result = max(result, h * w)
            stack.append(i)
        
        while stack:
            h = arr[stack.pop()]
            w = N if not stack else N - stack[-1] - 1
            result = max(result, h * w)
        
        print(result)

if __name__ == '__main__':
    main()