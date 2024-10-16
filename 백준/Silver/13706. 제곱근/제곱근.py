if __name__ == '__main__':
    N = int(input())

    left = 0
    right = N
    result = 0
    while left <= right:
        mid = (left + right) // 2

        if mid ** 2 == N:
            result = mid
            break
        elif mid ** 2 > N:
            right = mid - 1
        else:
            left = mid + 1

    print(result)