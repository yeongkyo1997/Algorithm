import sys


roman_map_single = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}


arabic_map_convert = [
    (1000, "M"),
    (900, "CM"),
    (500, "D"),
    (400, "CD"),
    (100, "C"),
    (90, "XC"),
    (50, "L"),
    (40, "XL"),
    (10, "X"),
    (9, "IX"),
    (5, "V"),
    (4, "IV"),
    (1, "I"),
]


def roman_to_int(s):
    result = 0
    i = 0
    while i < len(s):

        v1 = roman_map_single[s[i]]

        if i + 1 < len(s):
            v2 = roman_map_single[s[i + 1]]
            if v1 < v2:
                result += v2 - v1
                i += 2
            else:

                result += v1
                i += 1
        else:

            result += v1
            i += 1
    return result


def int_to_roman(num):
    result = ""

    for value, symbol in arabic_map_convert:

        while num >= value:
            result += symbol
            num -= value
    return result


roman1 = sys.stdin.readline().strip()
roman2 = sys.stdin.readline().strip()


num1 = roman_to_int(roman1)
num2 = roman_to_int(roman2)


total_arabic = num1 + num2


total_roman = int_to_roman(total_arabic)


print(total_arabic)
print(total_roman)
