pieces = list(map(int, input().split()))
correct_pieces = [1, 1, 2, 2, 2, 8]

for i in range(len(pieces)):
    diff = correct_pieces[i] - pieces[i]
    print(diff, end=" ")