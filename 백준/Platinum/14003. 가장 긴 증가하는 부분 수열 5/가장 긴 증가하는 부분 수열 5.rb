n=gets.to_i;a=gets.split.map(&:to_i);t=[];ti=[];p={}
a.each_with_index{|x,i|k=t.bsearch_index{|y|y>=x}||t.size;t[k]=x;ti[k]=i;p[i]=ti[k-1]if k>0}
l=t.size;puts l;r=[];c=ti[-1];while c;r.unshift a[c];c=p[c]end;puts r*' '