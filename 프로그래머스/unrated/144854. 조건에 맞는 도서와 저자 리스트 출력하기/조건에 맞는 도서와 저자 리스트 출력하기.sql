select book.book_id, author.author_name, date_format(book.published_date, "%Y-%m-%d") as published_date
from book
inner join author
using(author_id)
where book.category = "경제"
order by 3