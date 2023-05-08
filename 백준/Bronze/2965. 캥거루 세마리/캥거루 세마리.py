a, b, c = map(int, input().split())

distance = max(b-a, c-b)

max_moves = distance - 1

print(max_moves)