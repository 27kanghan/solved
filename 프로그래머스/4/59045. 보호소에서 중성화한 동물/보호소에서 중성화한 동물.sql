-- 코드를 입력하세요
SELECT a.animal_id, a.aNIMAL_TYPE, a.name
from animal_ins a
join animal_outs b
using (animal_id)
where a.SEX_UPON_INTAKE like '%intact%' && (b.SEX_UPON_OUTCOME like '%spayed%' OR b.SEX_UPON_OUTCOME like '%neutered%')
order by animal_id
