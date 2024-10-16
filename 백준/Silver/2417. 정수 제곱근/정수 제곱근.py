if __name__ == '__main__':
    N = int(input())

    start = 0
    end = N

    result = 0
    while start <= end:
        mid = start + end >> 1

        if mid ** 2 >= N:
            end = mid - 1
            result = mid
        else:
            start = mid + 1

    print(result)