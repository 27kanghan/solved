select book.category, sum(book_sales.sales) as total_sale
from book
join book_sales
on book.book_id = book_sales.book_id
where DATE_FORMAT(BOOK_SALES.SALES_DATE,"%Y-%m-%d") LIKE "2022-01%"
group by book.category 
order by book.category