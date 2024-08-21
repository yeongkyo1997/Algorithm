class Square:
    def __init__(self, x1, x2, y1, y2):
        self.x1 = x1
        self.x2 = x2
        self.y1 = y1
        self.y2 = y2


def meet(a, b):
    if a.y2 > b.y2 and b.x2 < a.x2 and b.y1 > a.y1 and b.x1 > a.x1:
        return False
    if a.y2 < b.y2 and b.x2 > a.x2 and b.y1 < a.y1 and b.x1 < a.x1:
        return False
    if a.y2 < b.y1 or a.x2 < b.x1 or a.y1 > b.y2 or a.x1 > b.x2:
        return False

    return True


def find_parent(i):
    if parent[i] == i:
        return i
    else:
        parent[i] = find_parent(parent[i])
        return parent[i]


def make_union(i, j) -> None:
    i = find_parent(i)
    j = find_parent(j)
    if i < j:
        parent[j] = i
    elif i > j:
        parent[i] = j


def main():
    global parent
    N = int(input())
    parent = list(range(N + 1))

    squares = [Square(0, 0, 0, 0)]

    for _ in range(N):
        a, b, c, d = map(int, input().split())
        squares.append(Square(a, c, b, d))

    for i in range(N):
        for j in range(i + 1, N + 1):
            if meet(squares[i], squares[j]):
                make_union(i, j)

    connected_components = set()
    for i in range(N + 1):
        connected_components.add(find_parent(i))

    print(len(connected_components) - 1)


if __name__ == "__main__":
    main()