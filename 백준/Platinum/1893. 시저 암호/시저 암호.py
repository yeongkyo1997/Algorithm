import bisect

from collections import defaultdict as dd


def main():
    N = int(input().strip())

    base = 911
    mod = 10 ** 9 + 7
    max_power = 500000 + 1
    power = [1] * (max_power)
    for i in range(1, max_power):
        power[i] = (power[i - 1] * base) % mod

    for _ in range(N):
        A = input().strip()
        W = input().strip()
        S = input().strip()

        char_to_idx = dd(int)
        for idx, c in enumerate(A):
            char_to_idx[c] = idx

        val_map = {}
        for c in A:
            val_map[c] = char_to_idx[c] + 1

        W_idx = [char_to_idx[c] for c in W]

        if len(W) > len(S):
            candi = []
        else:
            pre_hash = dd(int)
            for i in range(len(S)):
                pre_hash[i + 1] = (pre_hash[i] * base + val_map[S[i]]) % mod

            list_sub_hashes = []
            for i in range(len(S) - len(W) + 1):
                hash_sub = (pre_hash[i + len(W)] - pre_hash[i] * power[len(W)]) % mod
                list_sub_hashes.append(hash_sub)
            list_sub_hashes.sort()

            hash_X_list = []
            for X in range(len(A)):
                hash_X = 0
                for j in range(len(W)):
                    shifted_char_idx = (W_idx[j] + X) % len(A)
                    c = A[shifted_char_idx]
                    c_val = val_map[c]
                    hash_X = (hash_X * base + c_val) % mod
                hash_X_list.append((X, hash_X))

            candi = []
            for X, hash_X in hash_X_list:
                left = bisect.bisect_left(list_sub_hashes, hash_X)
                right = bisect.bisect_right(list_sub_hashes, hash_X)
                cnt = right - left
                if cnt == 1:
                    candi.append(X)

        if not candi:
            print("no solution")
        elif len(candi) == 1:
            print(f"unique: {candi[0]}")
        else:
            candi_sorted = sorted(candi)
            candi_str = ' '.join(str(x) for x in candi_sorted)
            print(f"ambiguous: {candi_str}")


if __name__ == "__main__":
    main()