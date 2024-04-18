-- 코드를 입력하세요
SELECT MCDP_CD as '진료과코드', count(*) as '5월예약건수'
from appointment
where month(APNT_YMD) = '05' and year(APNT_YMD) = '2022'
group by mcdp_cd
order by 5월예약건수 asc, 진료과코드 asc