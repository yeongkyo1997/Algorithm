def solution(number, limit, power):
    def get(n):
        result = 0
        for i in range(1, int(n ** 0.5) + 1):
            if n % i == 0:
                result += 1
                if i < n // i:
                    result += 1
        return result

    g = [get(i) for i in range(1, number + 1)]
    return sum(i if i <= limit else power for i in g)

