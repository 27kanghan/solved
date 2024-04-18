-- 코드를 입력하세요
SELECT count(*) as users
from USER_INFO 
where joined >= '2021-01-01' and joined <= '2021-12-31' AND age between 20 and 29;