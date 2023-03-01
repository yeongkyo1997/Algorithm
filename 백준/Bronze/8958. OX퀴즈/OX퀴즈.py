for _ in range(int(input())):
    string = list(input())
    total = 0
    score = 0
    for i in string:
        if i == 'O':
            score += 1
            total += score
        else:
            score = 0

    print(total)