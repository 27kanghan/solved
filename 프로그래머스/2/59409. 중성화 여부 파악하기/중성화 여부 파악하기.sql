-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME,
CASE
    WHEN SEX_UPON_INTAKE LIKE '%Neutered%'
    THEN 'O'
    WHEN SEX_UPON_INTAKE LIKE '%Spayed%'
    THEN 'O'
    ELSE 'X'
    END AS 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

# SELECT
#     ANIMAL_ID
#     , name
#     , case  when SEX_UPON_INTAKE like 'Neutered%' or SEX_UPON_INTAKE like 'Spayed%' then 'O'
#         else 'X'
#         End as "중성화"

# from ANIMAL_INS