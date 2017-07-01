/**
 * 605. Can Place Flowers
 * @author LiPeng
 * @since 2017/7/120:05
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (flowerbed.length == 1 || flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        cnt++;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i-1] == 0) {
                        flowerbed[i] = 1;
                        cnt++;
                    }
                } else {
                    if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        cnt++;
                    }
                }
            }
        }
        return cnt >= n;
    }

    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 && (flowerbed.length == 1 || flowerbed[i+1] == 0))
                        || (i == flowerbed.length - 1 && flowerbed[i-1] == 0)
                        || (i != 0 && i != flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)){
                    flowerbed[i] = 1;
                    cnt++;
                }
            }
        }
        return cnt >= n;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count ++;
            }
            if(count >= n)
                return true;
            i++;
        }
        return false;
    }
}
