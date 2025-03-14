-- 코드를 입력하세요
SELECT a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, ROUND(AVG(b.REVIEW_SCORE), 2) as SCORE
FROM REST_INFO a
JOIN REST_REVIEW b
ON a.REST_ID = b.REST_ID
WHERE a.ADDRESS LIKE '서울%'
GROUP BY a.REST_ID
ORDER BY ROUND(AVG(b.REVIEW_SCORE), 2) DESC, a.FAVORITES DESC


/*
SELECT A.REST_ID    
        ,A.REST_NAME    
        ,A.FOOD_TYPE    
        ,A.FAVORITES    
        ,A.ADDRESS  
        ,ROUND(AVG(B.REVIEW_SCORE),2) AS SCORE
FROM REST_INFO A
INNER JOIN REST_REVIEW B ON A.REST_ID = B.REST_ID
WHERE A.ADDRESS LIKE '서울%'
GROUP BY A.REST_ID
ORDER BY ROUND(AVG(B.REVIEW_SCORE),2)  DESC,A.FAVORITES DESC
*/