select factory_id, factory_name, address
from food_factory
where left(address, 2) = "강원"
order by 1