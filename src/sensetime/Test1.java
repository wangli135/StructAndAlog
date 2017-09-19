package sensetime;

import java.util.*;

/**
 * Created by Xingfeng on 2017-09-17.
 */
public class Test1 {

    static class Value implements Comparable<Value> {

        int groupId;
        int val;

        public Value(int groupId, int val) {
            this.groupId = groupId;
            this.val = val;
        }

        @Override
        public int compareTo(Value o) {
            return val - o.val;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int K = scanner.nextInt();
            int N = scanner.nextInt();

//            List<Value> list = new ArrayList<>(K * N);
//
//            for (int i = 0; i < K; i++) {
//
//                for (int j = 0; j < N; j++) {
//
//                    list.add(new Value(i, scanner.nextInt()));
//
//                }
//
//            }
//
//            handle(list, K, N);

            Value[][] values = new Value[K][N];

            for (int i = 0; i < K; i++) {

                for (int j = 0; j < N; j++) {

                    values[i][j] = new Value(i, scanner.nextInt());

                }

            }

            handle2(values, K, N);


        }

    }

    private static void handle(List<Value> list, int k, int n) {

        Collections.sort(list);

        int minLeft = 0, minRight = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {

            boolean[] used = new boolean[k];
            int size = k;
            for (int j = i; j < list.size(); j++) {

                if (!used[list.get(j).groupId]) {
                    used[list.get(j).groupId] = true;
                    size--;
                }

                if (size == 0) {

                    int left = list.get(i).val;
                    int right = list.get(j).val;
                    if (right - left < minRight - minLeft) {
                        minLeft = left;
                        minRight = right;
                    } else if (right - left == minRight - minLeft) {

                        if (left < minLeft) {
                            minLeft = left;
                            minRight = right;
                        }

                    }

                    break;

                }


            }

        }


        System.out.println(minLeft + " " + minRight);

    }

    private static void handle2(Value[][] values, int k, int n) {

        int[] indexArray = new int[k];//记录每一组的索引

        PriorityQueue<Value> queue = new PriorityQueue<>(k);
        int minLeft = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            int val = values[i][0].val;
            if (val < minLeft)
                minLeft = val;
            if (val > maxRight)
                maxRight = val;

            queue.offer(values[i][0]);
            indexArray[i] = 1;

        }

        int max = maxRight;

        while (true) {

            Value value = queue.remove();

            int groupId = value.groupId;
            int index = indexArray[groupId];

            if (index == n)
                break;


            int newMax = values[groupId][index].val;
            queue.offer(values[groupId][indexArray[groupId]++]);
            int newMin = queue.peek().val;


            if (newMax > max) {
                max = newMax;
            }

            if (max - newMin < maxRight - minLeft) {
                minLeft = newMin;
                maxRight = max;
            } else if (max - newMin == maxRight - minLeft) {
                if (newMin < minLeft) {
                    minLeft = newMin;
                    maxRight = max;
                }
            }


        }

        System.out.println(minLeft + " " + maxRight);

    }

}
