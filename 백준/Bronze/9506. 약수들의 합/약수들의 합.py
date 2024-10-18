def get_divisor(x):
    ret = []
    for i in range(1, int(x ** 0.5) + 1):
        if x % i == 0:
            ret.append(i)
            if x // i != i:
                ret.append(x // i)
    ret.sort()
    ret.pop()
    return ret


if __name__ == '__main__':
    while True:
        n = int(input())
        if n == -1:
            break

        div = get_divisor(n)
        if n == sum(div):
            print(f'{n} = {" + ".join(map(str, div))}')
        else:
            print(f'{n} is NOT perfect.')