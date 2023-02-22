$n=<>;
$n =~ s/c=|c-|dz=|d-|lj|nj|s=|z=/_/g;
printf("%d\n", ($n =~ s/(.)/$1/sg) - 1);