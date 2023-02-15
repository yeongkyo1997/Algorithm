select j.flavor
from july j join first_half f
on j.flavor = f.flavor
group by f.flavor
order by sum(f.total_order) + sum(j.total_order) desc
limit 3