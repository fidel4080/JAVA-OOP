public class TwoDarray {
    public static void main(String[] args) {
        
        int[][] MyArray = new int[4][5];

        //fill the array

        for(int rows = 0; rows < 4; rows++){
            for(int cols = 0; cols < 5; cols++){
                MyArray[rows][cols] = rows + cols;
            }
        }

        //display sum
        for(int rows = 0; rows < 4; rows++){
            for(int cols = 0; cols < 5; cols++){
                System.out.print(MyArray[rows][cols] +"\t");
            }
        }
    }
}
