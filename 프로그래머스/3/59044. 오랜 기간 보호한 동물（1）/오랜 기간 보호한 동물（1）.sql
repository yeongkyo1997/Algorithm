SELECT ins.name, ins.datetime
FROM ANIMAL_INS ins
LEFT JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID 
WHERE outs.datetime is null
order by ins.datetime
limit 3