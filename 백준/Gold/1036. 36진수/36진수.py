import sys
from collections import defaultdict


def main():
    input = sys.stdin.read().split()
    ptr = 0
    N = int(input[ptr])
    ptr += 1

    numbers = []
    for _ in range(N):
        numbers.append(input[ptr].strip())
        ptr += 1

    K = int(input[ptr])

    initial_sum = 0
    gains = defaultdict(int)

    for num_str in numbers:
        dec_num = 0
        for c in num_str:
            dec_num = dec_num * 36 + (int(c) if c.isdigit() else ord(c) - ord("A") + 10)
        initial_sum += dec_num

        L = len(num_str)
        for i in range(L):
            c = num_str[i]
            pos = L - 1 - i
            weight = 36**pos
            c_val = int(c) if c.isdigit() else ord(c) - ord("A") + 10
            gains[c] += (35 - c_val) * weight

    sorted_gains = sorted(gains.items(), key=lambda x: (-x[1], x[0]))
    total_gain = sum(g for _, g in sorted_gains[:K])

    max_total = initial_sum + total_gain

    if max_total == 0:
        print("0")
        return

    digits = []
    while max_total > 0:
        rem = max_total % 36
        if rem < 10:
            digits.append(str(rem))
        else:
            digits.append(chr(ord("A") + rem - 10))
        max_total = max_total // 36

    print("".join(reversed(digits)))


if __name__ == "__main__":
    main()
