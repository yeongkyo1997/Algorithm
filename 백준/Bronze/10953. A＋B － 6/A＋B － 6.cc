#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int t;
    scanf("%d", &t);

    while (t--) { 
        char input[10];
        scanf("%s", input);

        char *ptr = strtok(input, ","); 
        int a = atoi(ptr);
        ptr = strtok(NULL, ","); 
        int b = atoi(ptr);

        printf("%d\n", a+b); 
    }

    return 0;
}