if __name__ == '__main__':
    a, b = map(int, input().split())
    if b > 0:
        div, mod = divmod(a, b)
        print(div)
        print(mod)
    else:
        div, mod = divmod(a, -b)
        print(-div)
        print(mod)
