$n=<>;
for (1..$n) {
    ($m, $o) = (split / +/, <>);
    $d = $o - $m;
    $move = int (sqrt($d-0.5)*2.0);
    printf("%d\n", $move);
}