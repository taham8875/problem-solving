-- Write your PostgreSQL query statement below
WITH count_requests AS (
    SELECT DISTINCT requester_id,
        COUNT(requester_id) over(PARTITION by requester_id) AS requester_id_count
    FROM RequestAccepted
),
count_acceptances AS (
    SELECT DISTINCT accepter_id,
        COUNT(accepter_id) over(PARTITION by accepter_id) AS accepter_id_count
    FROM RequestAccepted
),
union_results AS (
    (
        SELECT *
        FROM count_requests
    )
    UNION ALL
    (
        SELECT *
        FROM count_acceptances
    )
)
SELECT requester_id AS id,
    sum(requester_id_count) AS num
FROM union_results
GROUP BY requester_id
ORDER BY num DESC
LIMIT 1