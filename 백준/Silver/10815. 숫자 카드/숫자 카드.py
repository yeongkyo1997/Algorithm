if __name__ == '__main__':
    N = int(input())
    arr = set(map(int, input().split()))
    M = int(input())
    print(*list(map(lambda x: int(int(x) in arr), input().split())))