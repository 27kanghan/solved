-- 코드를 입력하세요
SELECT animal_type, count(*) as count
from animal_ins
where animal_type in ('Cat', 'Dog')
group by ANIMAL_TYPE
order by ANIMAL_TYPE