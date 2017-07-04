package ali;

import juc.Test;

import java.util.*;

/**
 * Created by Xingfeng on 2017-04-26.
 */
public class Test2 {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String process(String pocket, String card) {

//        //首先将pocket进行处理，将J转为11，Q转为12，K转为13，A转为14,2转为15，然后排序
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < pocket.length(); i++) {
//            char c = pocket.charAt(i);
//            //如果出现10
//            if (c == '0') {
//                list.add(10);
//            } else if (c == 'J') {
//                list.add(11);
//            } else if (c == 'Q') {
//                list.add(12);
//            } else if (c == 'K') {
//                list.add(13);
//            } else if (c == 'A') {
//                list.add(14);
//            } else if (c == '2') {
//                list.add(15);
//            } else {
//                list.add(c - '0');
//            }
//        }
//
//        //对List进行排序
//        Collections.sort(list);
//
//        //按照同样的规则对card进行处理
//        List<Integer> cardList = new ArrayList<>();
//        for (int i = 0; i < card.length(); i++) {
//            char c = card.charAt(i);
//            //如果出现10
//            if (c == '0') {
//                cardList.add(10);
//            } else if (c == 'J') {
//                cardList.add(11);
//            } else if (c == 'Q') {
//                cardList.add(12);
//            } else if (c == 'K') {
//                cardList.add(13);
//            } else if (c == 'A') {
//                cardList.add(14);
//            } else if (c == '2') {
//                cardList.add(15);
//            } else {
//                cardList.add(c - '0');
//            }
//        }
//
//        //将pocket按照长度为1，长度为2，长度为3分成三个List
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        List<Integer> list3 = new ArrayList<>();
//
//        List<Integer>[] listArray = new List[]{list1, list2, list3};
//
//        int prev = list.get(0);
//        int num = 1;
//        for (int i = 1; i < list.size(); i++) {
//
//            if (list.get(i) == prev) {
//                num++;
//            } else {
//                if (num == 1) {
//                    list1.add(prev);
//                } else if (num == 2) {
//                    list2.add(prev);
//                } else {
//                    list3.add(prev);
//                }
//
//                num = 1;
//                prev = list.get(i);
//
//            }
//
//
//        }
//
//        if (num == 1) {
//            list1.add(prev);
//        } else if (num == 2) {
//            list2.add(prev);
//        } else {
//            list3.add(prev);
//        }
//
//        int len = cardList.size();
//        String result = "";
//
//        int index = len - 1;
//
//
//        List<Integer> minList = new ArrayList<>();
//
//
//        while (index < listArray.length) {
//
//            List<Integer> cur = listArray[index];
//            //从当前长度匹配的中查找
//            for (int i = 0; i < cur.size(); i++) {
//
//                int temp = cur.get(i);
//                //如果大，那么直接返回结果
//                if (temp > cardList.get(0)) {
//                    minList.add(index);
//                    minList.add(temp);
//                    break;
//
//                }
//            }
//
//            //长度匹配的没有找到，那么在长度大1的情况下查找
//            index++;
//
//        }
//
//        int temp=0;
//        //minList中保存了长度大于等于card的最小值
//        if(minList.get(0)==card.length()){
//            temp=minList.get(1);
//        }else{
//            temp=20;
//            for(int j=3;j<minList.size();j+=2){
//
//            }
//        }
//        String val = "";
//        if (temp == 10) {
//            val = "0";
//        } else if (temp == 11) {
//            val = "J";
//        } else if (temp == 12) {
//            val = "Q";
//        } else if (temp == 13) {
//            val = "K";
//        } else if (temp == 14) {
//            val = "A";
//        } else if (temp == 15) {
//            val = "2";
//        } else {
//            val = temp + "";
//        }
//
//        //拼凑结果
//        for (int k = 0; k < card.length(); k++) {
//            result += val;
//        }
//        return result;
//
//
//        //仍然没有查找到，那么输出张数最多的
//        //首先判断长度为3的存不存在
//        int temp = 0, k = 0;
//        if (list3.size() > 0) {
//            temp = list3.get(list3.size() - 1);
//            k = 3;
//        } else if (list2.size() > 0) {
//            temp = list2.get(list2.size() - 1);
//            k = 2;
//        } else if (list1.size() > 0) {
//            temp = list1.get(list1.size() - 1);
//            k = 1;
//        }
//
//        String val = "";
//        if (temp == 10) {
//            val = "0";
//        } else if (temp == 11) {
//            val = "J";
//        } else if (temp == 12) {
//            val = "Q";
//        } else if (temp == 13) {
//            val = "K";
//        } else if (temp == 14) {
//            val = "A";
//        } else if (temp == 15) {
//            val = "2";
//        } else {
//            val = temp + "";
//        }
//
//        while (k > 0) {
//            result += val;
//            k--;
//        }
//
//
//        return result;

        return "";


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _pocket;
        try {
            _pocket = in.nextLine();
        } catch (Exception e) {
            _pocket = null;
        }

        String _card;
        try {
            _card = in.nextLine();
        } catch (Exception e) {
            _card = null;
        }

        res = process(_pocket, _card);
        System.out.println(res);
    }

}
