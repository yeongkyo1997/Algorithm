def solution(bin1, bin2):
    return bin(int(f'0b{bin1}', 2) + int(f'0b{bin2}', 2))[2:]
