def solution(left, right):
    result = sum(map(lambda x: x if measure(x) % 2 == 0 else -x, range(left, right + 1)))
    return result

def measure(n):
    return sum(1 for i in range(1, n + 1) if n % i == 0)
