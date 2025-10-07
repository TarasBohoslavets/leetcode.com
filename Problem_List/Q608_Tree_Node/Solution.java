package Problem_List.Q608_Tree_Node;

public class Solution {
	/*
	-- Write your PostgreSQL query statement below
SELECT id,
CASE
  WHEN p_id IS NULL THEN 'Root'
  WHEN EXISTS (
      SELECT 1 FROM Tree AS child WHERE child.p_id = Tree.id
  ) THEN 'Inner'
  ELSE 'Leaf'
END AS type
FROM Tree;
	 */
}
