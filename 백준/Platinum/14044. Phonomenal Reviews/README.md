# [Platinum V] Phonomenal Reviews - 14044 

[문제 링크](https://www.acmicpc.net/problem/14044) 

### 성능 요약

메모리: 9232 KB, 시간: 52 ms

### 분류

깊이 우선 탐색, 다이나믹 프로그래밍, 트리에서의 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 트리

### 제출 일자

2025년 1월 14일 10:47:05

### 문제 설명

<p>Jo is a blogger, specializing in the critique of restaurants. Today, she wants to visit all the Vietnamese Pho restaurants in the Waterloo area, in order to determine which one is the best.</p>

<p>There are N restaurants in the city of Waterloo, numbered 0 to N-1. However, only M of them are Pho restaurants. Jo can choose to start at any restaurant. There are N-1 roads in Waterloo, each road connecting exactly two restaurants. It is possible to reach every restaurant from any restaurant using these roads. It takes Jo exactly 1 minute to travel along any road.</p>

<p>In computer science, a road network with this structure is called a tree. Here are three examples of trees:</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/80320f3c-73f2-465e-bbc4-f3cfca09f486/-/preview/" style="width: 622px; height: 149px;"></p>

<p>One property that is true for all trees is that there is exactly one path that does not repeat any roads between any two points in the tree.</p>

<p>What is the minimal length of time that Jo needs to spend on travelling on roads to visit all of the Pho restaurants?</p>

### 입력 

 <p>The first line of input contains 2 integers, N and M (2 ≤ M ≤ N ≤ 100 000).</p>

<p>The second line of input contains M distinct integers indicating the restaurants which are Pho restaurants.</p>

<p>The next N-1 lines contain 2 integers each. The i-th line contains a<sub>i</sub> and b<sub>i</sub>, (0 ≤ a<sub>i</sub>, b<sub>i</sub> ≤ N − 1), representing a path between the two restaurants numbered a<sub>i</sub> and b<sub>i</sub>.</p>

### 출력 

 <p>Your program should output one line, containing one integer - the minimum amount of time Jo needs to spend travelling on roads in order to visit all Pho restaurants, in minutes.</p>

