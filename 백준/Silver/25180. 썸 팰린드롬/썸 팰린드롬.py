
if __name__ == '__main__':
    N = int(input())
    result = 0

    while True:
        for i in range(9, 0, -1):
            if N - i == 0:
                result += 1
                N -= i
                break
            elif N - i * 2 >= 0:
                result += 2
                N -= i * 2
                break
        else:
            break

    print(result)