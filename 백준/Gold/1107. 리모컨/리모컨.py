import sys

input = lambda: sys.stdin.readline().rstrip()

min_cnt = 0x3f3f3f3f
num_int = 0
btn_set = [1] * 10


def find(num):
    global min_cnt, num_int, btn_set

    for i in range(10):
        if btn_set[i]:
            tmp_num = num + str(i)
            min_cnt = min(abs(num_int - int(tmp_num)) + len(tmp_num), min_cnt)

            if len(tmp_num) < 6:
                find(tmp_num)


def main():
    global min_cnt, num_int, btn_set
    num_int = int(input())
    n = int(input())
    min_cnt = min(abs(100 - num_int), min_cnt)

    for i in map(int, input().split()):
        btn_set[i] = 0

    if n < 10:
        find("")

    print(min_cnt)


if __name__ == '__main__':
    main()