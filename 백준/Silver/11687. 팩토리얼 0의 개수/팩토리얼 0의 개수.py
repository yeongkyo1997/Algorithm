def count_trailing_zeros(n):
    count = 0
    while n >= 5:
        n //= 5
        count += n
    return count


def find_smallest_n(M):
    left, right = 0, M * 5
    result = -1

    while left <= right:
        mid = (left + right) // 2
        zeros = count_trailing_zeros(mid)

        if zeros < M:
            left = mid + 1
        elif zeros > M:
            right = mid - 1
        else:
            result = mid
            right = mid - 1

    return result


M = int(input())

print(find_smallest_n(M))