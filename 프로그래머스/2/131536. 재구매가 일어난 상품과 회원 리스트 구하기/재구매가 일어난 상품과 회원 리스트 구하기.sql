-- 코드를 입력하세요
SELECT user_id, product_id
# select *
from online_sale
group by user_id, product_id
having count(sales_date) >= 2
order by user_id, product_id desc