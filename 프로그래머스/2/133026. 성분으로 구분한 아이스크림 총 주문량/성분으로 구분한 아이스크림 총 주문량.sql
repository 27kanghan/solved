-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, sum(total_order)
from first_half
join icecream_info
using (flavor)
group by INGREDIENT_TYPE
order by total_order