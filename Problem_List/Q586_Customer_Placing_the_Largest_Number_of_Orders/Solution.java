package Problem_List.Q586_Customer_Placing_the_Largest_Number_of_Orders;

public class Solution {
	/*
	-- Write your PostgreSQL query statement below
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(order_number) DESC
LIMIT 1;
	 */
}
