import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * @author LiPeng
 * @since 2017/6/2122:22
 */
public class MajorityElement {
    public int majorityElement0(int[] nums) {
        int res = nums[0], cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                res = nums[i];
                cnt = 1;
            }
        }
        return res;
    }

    public int majorityElement(int[] nums) {
        int major = 0, n = nums.length;
        for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
            int bitCounts = 0;
            for (int j = 0; j < n; j++) { //32位中的某一位置上的1多于n/2就把它或（|）到major上
                if ((nums[j] & mask) != 0) bitCounts++;
                if (bitCounts > n / 2) {
                    major |= mask;
                    break;
                }
            }
        }
        return major;
    }


    // Sorting
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Hashtable
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int ret=0;
        for (int num: nums) {
            if (!myMap.containsKey(num))
                myMap.put(num, 1);
            else
                myMap.put(num, myMap.get(num)+1);
            if (myMap.get(num)>nums.length/2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    // Moore voting algorithm
    public int majorityElement3(int[] nums) {
        int count = 0, ret = 0;
        for (int num: nums) {
            if (count == 0)
                ret = num;
            if (num != ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    // Bit manipulation
    public int majorityElement4(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums)
            for (int i=0; i<32; i++)
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length/2 ? 1 : 0;
            ret += bit[i] * (1 << (31 - i));
        }
        return ret;
    }
}
