def solution(s):
    arr = [[0] * 300000 for _ in range(26)]
    arr_length = [0] * 26
    length = len(s)

    if length == 1:
        return 0

    for i in range(26):
        for j in range(length):
            arr[i][j] = 0

    tmp = s[0]
    cnt = 1

    for i in range(1, length):
        if tmp == s[i]:
            cnt += 1
        else:
            arr[ord(tmp) - 97][cnt] += 1

            if cnt > arr_length[ord(tmp) - 97]:
                arr_length[ord(tmp) - 97] = cnt
            tmp = s[i]
            cnt = 1
    arr[ord(tmp) - 97][cnt] += 1

    if cnt > arr_length[ord(tmp) - 97]:
        arr_length[ord(tmp) - 97] = cnt
    result = (length - 1) * length * (length + 1) // 6

    for i in range(26):
        acc = 0
        temp = 0

        for j in range(1, arr_length[i] + 1):
            temp += arr[i][j]
            acc += j * arr[i][j]

        for j in range(1, arr_length[i] + 1):
            result -= acc * (acc - 1) // 2
            acc -= temp
            temp -= arr[i][j]

    return result
