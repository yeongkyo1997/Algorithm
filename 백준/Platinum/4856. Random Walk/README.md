# [Platinum I] Random Walk - 4856 

[문제 링크](https://www.acmicpc.net/problem/4856) 

### 성능 요약

메모리: 2240 KB, 시간: 0 ms

### 분류

기하학, 정렬

### 제출 일자

2025년 5월 4일 09:39:15

### 문제 설명

<p>Random walks are used to model a wide range of phenomena, from Brownian motion to gambling. For example, a gambler who bets on heads or tails on a coin toss wins or loses his bet each turn. The amount of money the gambler has throughout the game is a random walk. Although the bets in each turn may be different, it is easy to see that the gambler wins the maximum amount of money if he wins every turn. Similarly, he loses the maximum amount if he loses every turn.</p>

<p>We consider the following two-dimensional variation of the random walk. We are given <em>n</em> two-dimensional nonzero vectors <em>v<sub>i</sub> = (x<sub>i</sub>, y<sub>i</sub>)</em>, no two of which are parallel. In step <em>i</em>, a coin is flipped. If it is heads, we move <em>x<sub>i</sub></em>meters in the <em>x</em> direction and <em>y<sub>i</sub></em> meters in the <em>y</em> direction. If it is tails, we move <em>-x<sub>i</sub></em> and <em>-y<sub>i</sub></em> meters in the <em>x</em> and <em>y</em> directions.</p>

<p>We are interested in computing the maximum distance we can be away from our starting point. This is easy in one-dimension, but it is not so easy in the two-dimensional version.</p>

### 입력 

 <p>The input consists of a number of test cases. Each test case starts with a line containing the integer <em>n</em>, which is at most 100. Each of the next <em>n</em> lines gives a pair of integers <em>x<sub>i</sub></em> and <em>y<sub>i</sub></em> specifying <em>v<sub>i</sub></em>. The coordinates are less than 1000 in magnitude. The end of input is specified by <em>n</em> = 0.</p>

### 출력 

 <p>For each test case, print on a line the maximum distance we can be away from the starting point, in the format shown below. Output the answer to 3 decimal places.</p>

