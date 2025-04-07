loop{l=gets.split.map(&:to_i);n=l.shift;break if n==0
h=l+[0];s=[];m=0
h.each_with_index{|hh,i|
while s[0]&&h[s[-1]]>=hh;ht=h[s.pop];wd=s[0]?i-s[-1]-1:i;m=[m,ht*wd].max end;s<<i}
puts m}