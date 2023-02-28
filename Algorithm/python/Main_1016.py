import math
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    min, max = map(int, input().split())

    for i in range(2, int(math.sqrt(max) + 1)):
        start = min // (i ** 2)
        if start*i*i!=min:
            start+=1

        # for (long long j = start; i * i * j <= max; j++) {
        #     isSqr[i * i * j - min] = true;
        # }
        for «



if __name__ == '__main__':
    main()
