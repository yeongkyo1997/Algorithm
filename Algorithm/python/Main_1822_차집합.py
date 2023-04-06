import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    a, b = map(int, input().split())
    arr1 = list(map(int, input().split()))
    arr2 = list(map(int, input().split()))
    
    set1 = set(arr1)
    set2 = set(arr2)
    
    minus = set1 - set2
    
    if len(minus) == 0:
        print(0)
    else:
        print(len(minus))
        for i in sorted(minus):
            print(i, end=' ')

if __name__ == '__main__':
    main()
