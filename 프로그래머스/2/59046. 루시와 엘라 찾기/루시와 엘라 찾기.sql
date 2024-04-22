-- 코드를 입력하세요
SELECT animal_id, name, SEX_UPON_INTAKE
from animal_ins
where name like 'Lucy' or name like 'Ella' or name like 'Pickle'
or name like 'Rogan' or name like 'Sabrina%' or name like 'Mitty'
order by animal_id