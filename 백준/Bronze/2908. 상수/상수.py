if __name__ == '__main__':
    a, b = map(lambda x: int(x[::-1]), input().split())
    print(max(a, b))