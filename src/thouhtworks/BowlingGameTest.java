package thouhtworks;

public class BowlingGameTest {

    public static void main(String[] args) {

        String bowlingCode = "X|X|X|X|X|X|X|X|X|X||XX";           //300
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 300);

        bowlingCode = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";  //150
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 150);

        bowlingCode = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";   //90
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 90);
         bowlingCode = "X|7/|9-|X|-8|8/|-6|X|X|X||81";      //167
        assertEquals(new BowlingGame().getBowlingScore(bowlingCode), 167);

    }

    private static void assertEquals(int bowlingScore, int i) {

        if (bowlingScore == i) {
            System.out.println("Right");
        } else {
            System.out.println("Wrong");
        }

    }

}

