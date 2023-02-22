<?php
$n = intval(fgets(STDIN));
for( $t=1; $n>$t; $t++ ) $n -= $t;
$a = $n;
$b = $t - $n + 1;
if( $t%2 == 1 ) list($a, $b) = [$b, $a];
echo "$a/$b";