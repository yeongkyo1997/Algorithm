select animal_id, name
from animal_ins
where not intake_condition = "aged"
order by 1