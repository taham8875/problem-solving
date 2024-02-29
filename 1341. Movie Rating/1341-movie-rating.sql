-- Write your PostgreSQL query statement below
(
    SELECT Users.name AS results
    FROM MovieRating
        JOIN Users ON MovieRating.user_id = Users.user_id
    GROUP BY MovieRating.user_id,
        Users.name
    ORDER BY COUNT(MovieRating.user_id) DESC,
        Users.name ASC
    LIMIT 1
)
UNION
(
    SELECT Movies.title AS results
    FROM MovieRating
        JOIN Movies ON MovieRating.movie_id = Movies.movie_id
    WHERE to_char(
            date_trunc('month', MovieRating.created_at),
            'YYYY-MM'
        ) = '2020-02'
    GROUP BY MovieRating.movie_id,
        Movies.title
    ORDER BY avg(rating) DESC,
        Movies.title
    LIMIT 1
)