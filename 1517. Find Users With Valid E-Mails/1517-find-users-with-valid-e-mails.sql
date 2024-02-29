-- Write your PostgreSQL query statement below
-- tip: use `https://regex-vis.com/` to visualize the regex pattern
SELECT *
FROM Users
WHERE mail ~ '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\.com$';