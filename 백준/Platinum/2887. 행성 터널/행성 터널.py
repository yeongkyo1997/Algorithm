import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    arr = []
    for i in range(N):
        x, y, z = map(int, input().split())
        arr.append([x, y, z, i])

    arr.sort(key=lambda x: x[0])
    arr2 = []
    for i in range(N - 1):
        arr2.append([arr[i][3], arr[i + 1][3], abs(arr[i][0] - arr[i + 1][0])])

    arr.sort(key=lambda x: x[1])
    for i in range(N - 1):
        arr2.append([arr[i][3], arr[i + 1][3], abs(arr[i][1] - arr[i + 1][1])])

    arr.sort(key=lambda x: x[2])
    for i in range(N - 1):
        arr2.append([arr[i][3], arr[i + 1][3], abs(arr[i][2] - arr[i + 1][2])])

    arr2.sort(key=lambda x: x[2])

    parent = [i for i in range(N)]
    rank = [1] * N

    def find(x):
        if parent[x] == x:
            return x
        parent[x] = find(parent[x])
        return parent[x]

    def union(x, y):
        x = find(x)
        y = find(y)
        if x == y:
            return
        if rank[x] > rank[y]:
            parent[y] = x
        else:
            parent[x] = y
            if rank[x] == rank[y]:
                rank[y] += 1

    answer = 0
    for i in arr2:
        if find(i[0]) != find(i[1]):
            union(i[0], i[1])
            answer += i[2]

    print(answer)


if __name__ == '__main__':
    main()