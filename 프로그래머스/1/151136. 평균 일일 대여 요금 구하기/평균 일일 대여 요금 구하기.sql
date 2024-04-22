-- 코드를 입력하세요
SELECT round(AVG(DAILY_FEE)) as average_fee
from car_rental_company_car
where car_type = 'suv'