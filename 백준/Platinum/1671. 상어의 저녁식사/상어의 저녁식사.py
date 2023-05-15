class Shark:
    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c
        
    def __eq__(self, other):
        return self.a == other.a and self.b == other.b and self.c == other.c

    def __gt__(self, other):
        return self.a < other.a or self.b < other.b or self.c < other.c

def dfs(a, arr, B, visited):
    visited[a] = True
    for i in range(len(arr)):
        if arr[a] == arr[i] and a < i:
            continue
        if i == a or arr[a] > arr[i]:
            continue
        if B[i] == -1 or not visited[B[i]] and dfs(B[i], arr, B, visited):
            B[i] = a
            return True
    return False

def main():
    n = int(input())
    arr = [Shark(*map(int, input().split())) for _ in range(n)]

    B = [-1] * n
    ret = 0

    for i in range(n):
        for j in range(2):
            visited = [False] * n
            if dfs(i, arr, B, visited):
                ret += 1

    print(n - ret)

if __name__ == "__main__":
    main()