-- Write your PostgreSQL query statement below
select customer_id, sum(case when transaction_id is null then 1 else 0 end) as count_no_trans 
from Visits
left join Transactions
on Visits.visit_id = Transactions.visit_id
group by customer_id
having sum(case when transaction_id is null then 1 else 0 end) != 0