$n = <>;
for (a..z) {
    $pos = $_;
    ($loc_num, $flag) = (0) x 2;
    for (0..(length $n)-1) {
        if (substr($n, $_, 1) eq $pos) {
            $flag = 1;
            $loc_num = $_;
            last;
        }
    }
    printf("%s ", ($flag eq 1 ? $loc_num : -1));
}