-- Write your PostgreSQL query statement below
SELECT user_id,
    concat(UPPER(left(name, 1)), LOWER(substring(name, 2))) AS name
FROM Users
ORDER BY user_id