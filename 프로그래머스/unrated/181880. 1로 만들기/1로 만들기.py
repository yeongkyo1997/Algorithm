def solution(num_list):
    def func(n):
        cnt = 0
        while n != 1:
            if n % 2 == 0:
                n //= 2
            else:
                n = (n - 1) // 2
            cnt += 1
        return cnt

    return sum(func(i) for i in num_list)
