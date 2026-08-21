class Solution {
    public int minEatingSpeed(int[] piles, int h){
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        for (int speed = 1; speed <= max; speed++) {
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + speed - 1) / speed;
            }
            if (hours <= h) {
                return speed;
            }
        }
        return max;
    }
}
