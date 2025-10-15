package Problem_List.Q620_Not_Boring_Movies;

public class Solution {
	/*
	-- Write your PostgreSQL query statement below
SELECT id, movie, description, rating
FROM Cinema
WHERE MOD(id, 2) = 1
  AND description <> 'boring'
ORDER BY rating DESC;
	 */
}
