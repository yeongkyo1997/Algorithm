N = int(input())

while N:
    N -= 1
    quiz = list(input())

    result = 0
    cnt = 0

    for i in quiz:
        if i == 'O':
            cnt += 1
        else:
            cnt = 0

        result += cnt

    print(result)
