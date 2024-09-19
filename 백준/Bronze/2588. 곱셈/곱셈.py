if __name__ == '__main__':
    a = int(input())
    b = int(input())

    for i in map(int, str(b)[::-1]):
        print(a * i)

    print(a * b)