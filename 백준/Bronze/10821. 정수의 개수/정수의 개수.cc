#include <stdio.h>
#include <stdlib.h>

int main() {
    char str[101];
    int cnt = 0;
    scanf("%s", str);
    
    // ,의 개수
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == ',') {
            cnt++;
        }
    }

    printf("%d\n", cnt + 1);
}