#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_QUEUE_SIZE 10000
#define MAX_COMMAND_SIZE 10

typedef struct
{
    int arr[MAX_QUEUE_SIZE];
    int front;
    int back;
} Queue;

void push(Queue *q, int x)
{
    q->arr[q->back++] = x;
}

int pop(Queue *q)
{
    return (q->front == q->back) ? -1 : q->arr[q->front++];
}

int size(Queue *q)
{
    return q->back - q->front;
}

int empty(Queue *q)
{
    return (q->front == q->back) ? 1 : 0;
}

int front(Queue *q)
{
    return (q->front == q->back) ? -1 : q->arr[q->front];
}

int back(Queue *q)
{
    return (q->front == q->back) ? -1 : q->arr[q->back - 1];
}

int main()
{
    int N;
    scanf("%d", &N);

    Queue q;
    q.front = 0;
    q.back = 0;

    for (int i = 0; i < N; i++)
    {
        char command[MAX_COMMAND_SIZE];
        scanf("%s", command);

        if (strcmp(command, "push") == 0)
        {
            int x;
            scanf("%d", &x);
            push(&q, x);
        }
        else if (strcmp(command, "pop") == 0)
            printf("%d\n", pop(&q));
        else if (strcmp(command, "size") == 0)
            printf("%d\n", size(&q));
        else if (strcmp(command, "empty") == 0)
            printf("%d\n", empty(&q));
        else if (strcmp(command, "front") == 0)
            printf("%d\n", front(&q));
        else if (strcmp(command, "back") == 0)
            printf("%d\n", back(&q));
    }

    return 0;
}