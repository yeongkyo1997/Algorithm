# program pas;
#
# const MAXN = 300000;
# const inf = 1000000000;
#
# type
# pnode = ^node;
# node  =
# record
# next : pnode;
# key  : longint;
# end;
#
# var
# n, qhead, qtail       : longint;
# adj                   : array[0..MAXN] of pnode;
# queue, dad, dist      : array[0..MAXN] of longint;
# visina, how_visina    : array[0..MAXN, 0..2] of longint;
# dole_diametar         : array[0..MAXN] of longint;
# best_dole_diametar    : array[0..MAXN, 0..1] of longint;
# how_dole_diametar     : array[0..MAXN, 0..1] of longint;
# rez_diametar, rez_put : array[0..MAXN] of longint;
# i, j, a, b, V, D      : longint;
# novi_diametar         : longint;
# ret, how              : longint;
# pn, it                : pnode;
#
# procedure bfs(start, nemoj_tamo : longint);
# var
# i, a, b : longint;
# it      : pnode;
# begin
# for i:=0 to n-1 do begin
# dad[i] := -1;
# dist[i] := inf;
# end;
#
# if nemoj_tamo >= 0 then dist[nemoj_tamo] := -inf;
#
# qhead := 0; qtail := 0;
# dist[start] := 0;
# queue[qtail] := start; inc(qtail);
# while qhead <> qtail do begin
# a := queue[qhead]; inc(qhead);
#
# it := adj[a];
# while it <> nil do begin
# b := it^.key;
# if dist[a]+1 < dist[b] then begin
# dad[b] := a;
# dist[b] := dist[a]+1;
# queue[qtail] := b; inc(qtail);
# end;
# it := it^.next;
# end;
# end;
# end;
#
# function pol_dijametra(A, nemoj_tamo : longint) : longint;
# var B, C, D, i : longint;
# begin
# bfs(A, nemoj_tamo);
# B := queue[qhead-1];
# bfs(B, nemoj_tamo);
# C := queue[qhead-1];
# D := C;
# for i:=1 to dist[C] div 2 do D := dad[D];
# pol_dijametra := D;
# end;
#
# function max(a, b : longint) : longint; begin if a > b then max := a else max := b; end;
#
# begin
# read(n);
# for i:=0 to n-1 do adj[i] := nil;
#
# for i:=1 to n-1 do begin
# read(a, b); dec(a); dec(b);
# new(pn); pn^.key := b; pn^.next := adj[a]; adj[a] := pn;
# new(pn); pn^.key := a; pn^.next := adj[b]; adj[b] := pn;
# end;
#
# bfs(0, -1);
#
# for i:=0 to n-1 do begin
# for j:=0 to 2 do begin
# visina[i, j] := 0;
# how_visina[i, j] := -1;
# end;
#
# for j:=0 to 1 do begin
# best_dole_diametar[i, j] := 0;
# how_dole_diametar[i, j] := -1;
# end;
# dole_diametar[i] := 0;
# rez_put[i] := 0;
# rez_diametar[i] := 0;
# end;
#
# for i:=n-1 downto 0 do begin
# a := queue[i];
#
# it := adj[a];
# while it <> nil do begin
# b := it^.key;
# if b = dad[a] then begin
# it := it^.next;
# continue;
# end;
#
# V := visina[b, 0] + 1;
# for j:=2 downto 0 do begin
# if V > visina[a, j] then begin
# if j+1 < 3 then begin
# visina[a, j+1] := visina[a, j];
# how_visina[a, j+1] := how_visina[a, j];
# end;
# visina[a, j] := V;
# how_visina[a, j] := b;
# end else break;
# end;
#
# D := dole_diametar[b];
# for j:=1 downto 0 do begin
# if D > best_dole_diametar[a, j] then begin
# if j+1 < 2 then begin
# best_dole_diametar[a, j+1] := best_dole_diametar[a, j];
# how_dole_diametar[a, j+1] := how_dole_diametar[a, j];
# end;
# best_dole_diametar[a, j] := D;
# how_dole_diametar[a, j] := b;
# end else break;
# end;
#
# it := it^.next;
# end;
#
# dole_diametar[a] := best_dole_diametar[a, 0];
# dole_diametar[a] := max(dole_diametar[a], visina[a, 0] + visina[a, 1]);
# end;
#
# ret := inf;
# for i:=0 to n-1 do begin
# a := queue[i];
# b := dad[a];
#
# if b = -1 then begin
# rez_put[a] := -inf;
# rez_diametar[a] := -inf;
# continue;
# end;
#
# rez_put[a] := max(rez_put[a], 1+rez_put[b]);
#
# if how_visina[b, 0] = a then rez_put[a] := max(rez_put[a], visina[b, 1])
# else rez_put[a] := max(rez_put[a], visina[b, 0]);
#
# rez_diametar[a] := max(rez_diametar[a], rez_diametar[b]);
#
# if how_visina[b, 0] = a then begin
# rez_diametar[a] := max(rez_diametar[a], (1+rez_put[b]) + visina[b, 1]);
# rez_diametar[a] := max(rez_diametar[a], visina[b, 1] + visina[b, 2]);
# end else if how_visina[b, 1] = a then begin
# rez_diametar[a] := max(rez_diametar[a], (1+rez_put[b]) + visina[b, 0]);
# rez_diametar[a] := max(rez_diametar[a], visina[b, 0] + visina[b, 2]);
# end else begin
# rez_diametar[a] := max(rez_diametar[a], (1+rez_put[b]) + visina[b, 0]);
# rez_diametar[a] := max(rez_diametar[a], visina[b, 0] + visina[b, 1]);
# end;
#
# if how_dole_diametar[b, 0] = a then
# rez_diametar[a] := max(rez_diametar[a], best_dole_diametar[b, 1])
# else
# rez_diametar[a] := max(rez_diametar[a], best_dole_diametar[b, 0]);
#
# novi_diametar := max(dole_diametar[a], rez_diametar[a]);
# novi_diametar := max(novi_diametar, 1 + (dole_diametar[a]+1) div 2 + (rez_diametar[a]+1) div 2);
#
# if novi_diametar < ret then begin
# ret := novi_diametar;
# how := a;
# end;
# end;
#
# a := how; b := dad[how];
# writeln(ret);
# writeln(a+1, ' ', b+1);
# writeln(pol_dijametra(a, b)+1, ' ', pol_dijametra(b, a)+1);
# end.


# to py3

import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def dfs(u, p):
    global adj, dad, queue, n
    dad[u] = p
    queue.append(u)
    for v in adj[u]:
        if v != p:
            dfs(v, u)


def pol_dijametra(a, b):
    global visina, how_visina, n
    if visina[a][0] == visina[b][0] + 1:
        return how_visina[a][0]
    if visina[a][0] == visina[b][0] + 2:
        return how_visina[a][1]
    return how_visina[a][0]


def solve():
    global adj, dad, queue, n, rez_put, rez_diametar, visina, how_visina, best_dole_diametar, how_dole_diametar, dole_diametar
    n = int(input())
    adj = [[] for _ in range(n)]
    dad = [-1 for _ in range(n)]
    queue = []
    rez_put = [-1 for _ in range(n)]
    rez_diametar = [-1 for _ in range(n)]
    visina = [[-1 for _ in range(3)] for _ in range(n)]
    how_visina = [[-1 for _ in range(3)] for _ in range(n)]
    best_dole_diametar = [[-1 for _ in range(2)] for _ in range(n)]
    how_dole_diametar = [[-1 for _ in range(2)] for _ in range(n)]
    dole_diametar = [-1 for _ in range(n)]
    for _ in range(n - 1):
        a, b = map(int, input().split())
        a -= 1
        b -= 1
        adj[a].append(b)
        adj[b].append(a)
    dfs(0, -1)
    queue.reverse()
    for i in range(n):
        a = queue[i]
        it = adj[a]
        while it:
            b = it[0]
            if b == dad[a]:
                it = it[1]
                continue
            V = visina[b][0] + 1
            for j in range(2, -1, -1):
                if V > visina[a][j]:
                    if j + 1 < 3:
                        visina[a][j + 1] = visina[a][j]
                        how_visina[a][j + 1] = how_visina[a][j]
                    visina[a][j] = V
                    how_visina[a][j] = b
                else:
                    break
            D = dole_diametar[b]
            for j in range(1, -1, -1):
                if D > best_dole_diametar[a][j]:
                    if j + 1 < 2:
                        best_dole_diametar[a][j + 1] = best_dole_diametar[a][j]
                        how_dole_diametar[a][j + 1] = how_dole_diametar[a][j]
                    best_dole_diametar[a][j] = D
                    how_dole_diametar[a][j] = b
                else:
                    break
            it = it[1]
    for i in range(n):
        a = queue[i]
        if dad[a] != -1:
            rez_put[a] = rez_put[dad[a]] + 1
        rez_diametar[a] = rez_diametar[dad[a]]
        if how_visina[b][0] == a:
            rez_diametar[a] = max(rez_diametar[a], (1 + rez_put[b]) + visina[b][1])
            rez_diametar[a] = max(rez_diametar[a], visina[b][1] + visina[b][2])
        elif how_visina[b][1] == a:
            rez_diametar[a] = max(rez_diametar[a], (1 + rez_put[b]) + visina[b][0])
            rez_diametar[a] = max(rez_diametar[a], visina[b][0] + visina[b][2])
        else:
            rez_diametar[a] = max(rez_diametar[a], (1 + rez_put[b]) + visina[b][0])
            rez_diametar[a] = max(rez_diametar[a], visina[b][0] + visina[b][1])
        if how_dole_diametar[b][0] == a:
            rez_diametar[a] = max(rez_diametar[a], best_dole_diametar[b][1])
        else:
            rez_diametar[a] = max(rez_diametar[a], best_dole_diametar[b][0])
        novi_diametar = max(dole_diametar[a], rez_diametar[a])
        novi_diametar = max(novi_diametar, 1 + (dole_diametar[a] + 1) // 2 + (rez_diametar[a] + 1) // 2)
        if novi_diametar < ret:
            ret = novi_diametar
            how = a
    a = how
    b = dad[how]
    print(ret)
    print(a + 1, b + 1)

    print(pol_dijametra(a, b) + 1, pol_dijametra(b, a) + 1)

    return


t = int(input())
for _ in range(t):
    solve()
