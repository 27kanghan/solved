-- 코드를 입력하세요
SELECT title, a.board_id, reply_id, b.writer_id, b.contents,
date_format(b.created_date, '%Y-%m-%d') as created_date
from used_goods_board a
join used_goods_reply b
using (board_id)
where a.CREATED_DATE like '2022-10%'
order by b.created_date asc, title asc