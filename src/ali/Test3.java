package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-26.
 */
public class Test3 {


    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String process(String[] input) {

        List<List<Integer>> result = new ArrayList<>();
        int len = input.length;
        //创建一个二维数组,data[i][j]表示i想和j成为队友
        boolean[][] data = new boolean[len + 1][len + 1];

        String[] array = null;
        //预处理input
        for (int i = 0; i < len; i++) {

            array = input[i].split(" ");
            //只愿意自己一队
            if (array.length == 1 && array[0].equals("self")) {
                data[i + 1][i + 1] = true;
            } else {
                for (int i1 = 0; i1 < array.length; i1++) {
                    int val = Integer.parseInt(array[i1]);
                    data[i + 1][val] = true;//表示i想与j成为队友
                }
            }

        }


        int index = 0;
        List<Integer> line = new ArrayList<>();
        //保存后面不需要遍历的队员
        List<Integer> notSelect = new ArrayList<>();
        //处理data，对于队员i，遍历整行，查看他想做队友的人是否也愿意和他做队友
        for (int i = 1; i < data.length; i++) {

            if (notSelect.contains(i)) {
                continue;
            }

            boolean willing = true;
            line.add(i);
            for (int j = 1; j < data[i].length; j++) {

                if (data[i][j]) {
                    if (data[j][i]) {
                        line.add(j);
                    } else {
                        willing = false;
                        break;
                    }
                }

            }

            if (willing) {
                result.add(new ArrayList<>(line));
                //添加以后不需要遍历的队员
                for (int j = 1; j < data[i].length; j++) {
                    if (data[i][j]) {
                        notSelect.add(j);
                    }
                }
            }

            line.clear();


        }


        StringBuilder sb = new StringBuilder();
        if(result.size()==0){
            sb.append("na");
        }else{
            for (int i = 0; i < result.size(); i++) {
                line = result.get(i);
                for (int i1 = 0; i1 < line.size(); i1++) {
                    sb.append(line.get(i1) + " ");
                }
                sb.deleteCharAt(sb.length() - 1).append(",");
            }

            sb.deleteCharAt(sb.length() - 1);
        }


        return sb.toString();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for (int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = process(_input);
        System.out.println(res);
    }

}
