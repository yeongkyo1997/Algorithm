# [Platinum IV] Bundling - 23898 

[문제 링크](https://www.acmicpc.net/problem/23898) 

### 성능 요약

메모리: 73892 KB, 시간: 344 ms

### 분류

자료 구조, 그리디 알고리즘, 문자열, 트리, 트라이

### 제출 일자

2025년 4월 13일 07:58:28

### 문제 설명

<p>Pip has <b>N</b> strings. Each string consists only of letters from <code>A</code> to <code>Z</code>. Pip would like to bundle their strings into <i>groups</i> of size <b>K</b>. Each string must belong to exactly one group.</p>

<p>The <i>score</i> of a group is equal to the length of the longest prefix shared by all the strings in that group. For example:</p>

<ul>
	<li>The group <code>{RAINBOW, RANK, RANDOM, RANK}</code> has a score of 2 (the longest prefix is <code>'RA'</code>).</li>
	<li>The group <code>{FIRE, FIREBALL, FIREFIGHTER}</code> has a score of 4 (the longest prefix is <code>'FIRE'</code>).</li>
	<li>The group <code>{ALLOCATION, PLATE, WORKOUT, BUNDLING}</code> has a score of 0 (the longest prefix is <code>"</code>).</li>
</ul>

<p>Please help Pip bundle their strings into groups of size <b>K</b>, such that the sum of scores of the groups is maximized.</p>

### 입력 

 <p>The first line of the input gives the number of test cases, <b>T</b>. <b>T</b> test cases follow. Each test case begins with a line containing the two integers <b>N</b> and <b>K</b>. Then, <b>N</b> lines follow, each containing one of Pip's strings.</p>

### 출력 

 <p>For each test case, output one line containing <code>Case #x: y</code>, where <code>x</code> is the test case number (starting from 1) and <code>y</code> is the maximum sum of scores possible.</p>

