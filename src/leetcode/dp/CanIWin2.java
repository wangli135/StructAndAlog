package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/can-i-win/description/
 * Created by wangl on 2017/7/31.
 */
public class CanIWin2 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        return canIWin(desiredTotal, new int[maxChoosableInteger], new HashMap<>());
    }

    private boolean canIWin(int total, int[] state, HashMap<String, Boolean> hashMap) {
        String curr = Arrays.toString(state);
        if (hashMap.containsKey(curr)) return hashMap.get(curr);
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) {
                state[i] = 1;
                //如果超过了或者没有超过，但是后面的人没赢
                //都是我赢
                if (total <= i + 1 || !canIWin(total - (i + 1), state, hashMap)) {
                    hashMap.put(curr, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        hashMap.put(curr, false);
        return false;
    }

    public static void main(String[] args) {

        System.out.println(new CanIWin2().canIWin(10, 11));

    }

}
