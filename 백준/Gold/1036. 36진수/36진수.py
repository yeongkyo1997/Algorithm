def main():
    def base36_to_int(s):
        ret = 0
        for c in s:
            if '0' <= c <= '9':
                dig = ord(c) - ord('0')
            else:
                dig = ord(c) - ord('A') + 10
            ret = ret * 36 + dig
        return ret

    def int_to_base36(n):
        if n == 0:
            return '0'
        digs = []
        while n > 0:
            rem = n % 36
            if rem < 10:
                digs.append(str(rem))
            else:
                digs.append(chr(ord('A') + rem - 10))
            n = n // 36
        return ''.join(reversed(digs))

    N = int(input())
    numbers = list(input() for _ in range(N))
    K = int(input())

    char_vals = {}
    for i in range(10):
        char_vals[str(i)] = i
    for i in range(26):
        char_vals[chr(ord('A') + i)] = 10 + i

    gains = {c: 0 for c in char_vals}

    power36 = [1]
    for _ in range(1, 51):
        power36.append(power36[-1] * 36)

    for number in numbers:
        length = len(number)
        for idx, c in enumerate(number):
            position = length - 1 - idx
            gains[c] += (35 - char_vals[c]) * power36[position]

    sorted_gains = sorted(gains.items(), key=lambda x: x[1], reverse=True)

    selected_chars = []
    for c, g in sorted_gains:
        if g > 0 and len(selected_chars) < K:
            selected_chars.append(c)
        if len(selected_chars) == K:
            break

    replaced_numbers = []
    for number in numbers:
        replaced = ''.join(['Z' if c in selected_chars else c for c in number])
        replaced_numbers.append(replaced)

    total_sum = 0
    for num in replaced_numbers:
        total_sum += base36_to_int(num)

    result = int_to_base36(total_sum)
    print(result)


if __name__ == "__main__":
    main()