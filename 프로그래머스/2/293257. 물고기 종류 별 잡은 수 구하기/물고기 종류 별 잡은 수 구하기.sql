-- 코드를 작성해주세요
select  count(*) as FISH_COUNT, fish_name
from fish_info
join fish_name_info
using (fish_type)
group by fish_name
order by fish_count desc