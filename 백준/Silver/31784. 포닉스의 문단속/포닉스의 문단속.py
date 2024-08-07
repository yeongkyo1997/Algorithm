N, K = map(int, input().split())
S = input()
S = list(S)
for i in range(N):
    if K <= 0:
        break
    rotate_count = (ord('Z') - ord(S[i]) + 1) % 26
    if K >= rotate_count:
        S[i] = 'A'
        K -= rotate_count
if K > 0:
    S[-1] = chr((ord(S[-1]) - ord('A') + K) % 26 + ord('A'))
print(''.join(S))