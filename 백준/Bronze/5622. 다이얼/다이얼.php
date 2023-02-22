<?php
function time_for_char($ch) {
    if( $ch < 'D' ) return 3;
    if( $ch < 'G' ) return 4;
    if( $ch < 'J' ) return 5;
    if( $ch < 'M' ) return 6;
    if( $ch < 'P' ) return 7;
    if( $ch < 'T' ) return 8;
    if( $ch < 'W' ) return 9;
    return 10;
}
$chs = str_split(rtrim(fgets(STDIN)));
$time = 0;
foreach($chs as $ch) {
    $time += time_for_char($ch);
}
echo $time;