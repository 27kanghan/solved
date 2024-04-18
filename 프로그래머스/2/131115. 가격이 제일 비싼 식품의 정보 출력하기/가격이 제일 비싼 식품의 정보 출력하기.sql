-- 코드를 입력하세요
SELECT product_id, product_name, product_cd, category, max(price) as price
from food_product
group by product_name
order by max(price) desc limit 1