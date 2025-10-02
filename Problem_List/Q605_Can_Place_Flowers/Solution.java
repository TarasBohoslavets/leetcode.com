package Problem_List.Q605_Can_Place_Flowers;

class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int len = flowerbed.length;
		
		for (int i = 0; i < len; i++) {
			if (flowerbed[i] == 0) {
				boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
				boolean emptyRight = (i == len - 1) || (flowerbed[i + 1] == 0);
				
				if (emptyLeft && emptyRight) {
					flowerbed[i] = 1; // садимо квітку
					count++;
					if (count >= n) return true;
				}
			}
		}
		
		return count >= n;
	}
}