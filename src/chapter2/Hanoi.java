package chapter2;

/**
 * 汉诺塔
 * Created by Xingfeng on 2016-11-07.
 */
public class Hanoi {

    public void towerOfHanoi(int n, char frompeg, char topeg, char auxpeg) {

        if (n == 1) {
            System.out.println("Move disk 1 from peg " + frompeg + " to peg " + topeg);
            return;
        }

        towerOfHanoi(n - 1, frompeg, auxpeg, topeg);
        System.out.println("Move disk " + n + " from peg " + frompeg + " to peg " + topeg);
        towerOfHanoi(n - 1, auxpeg, topeg, frompeg);

    }

    public static void main(String[] args) {
        new Hanoi().towerOfHanoi(3, 'A', 'B', 'C');
    }

}
