loop{l=gets.split.map(&:to_i);n=l.shift;break if n==0
h=l+[0];s=[];m=0
h.each_with_index{|z,i|
while s[0]&&h[s[-1]]>=z;t=h[s.pop];w=s[0]?i-s[-1]-1:i;m=[m,t*w].max end;s<<i}
puts m}