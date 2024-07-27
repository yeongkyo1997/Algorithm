select d.id, d.email, d.first_name, d.last_name
from DEVELOPERS d
join SKILLCODES s on (s.name = 'Python' or s.name = 'C#')
where s.code & d.skill_code != 0
group by d.id, d.email, d.first_name, d.last_name
order by 1
