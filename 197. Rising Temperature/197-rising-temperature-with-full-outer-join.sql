-- Write your PostgreSQL query statement below
-- with full outer joins
SELECT w2.id
FROM Weather w1
full join Weather w2
on 1 = 1
where  w2.recordDate - w1.recordDate = 1 and  w2.temperature > w1.temperature