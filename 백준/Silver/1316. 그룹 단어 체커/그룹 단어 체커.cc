#include <stdio.h>
#include <stdbool.h>

bool isGroupWord(char word[]) {
    bool alpha[26] = { false };
    int prev = -1;
    for (int i = 0; word[i] != '\0'; i++) {
        int curr = word[i] - 'a';
        if (prev != curr) {
            if (alpha[curr])
                return false;
            alpha[curr] = true;
            prev = curr;
        }
    }
    return true;
}

int main() {
    int n;
    scanf("%d", &n);
    int ans = 0;
    for (int i = 0; i < n; i++) {
        char word[101];
        scanf("%s", word);
        if (isGroupWord(word))
            ans++;
    }
    printf("%d\n", ans);
    return 0;
}