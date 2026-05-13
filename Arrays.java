public class Arrays {
    public static void main(String[] arg){
        // int [] MyArray = new int[100];

        // for(int i = 0; i < 100; i++){
        //     MyArray[i] = i+1;
        //     System.out.println(MyArray[i]);
        // }

        int [][] MyArray = new int[10][10];

        System.out.print("    ");
        for (int i = 1; i<= 10; i++){
            System.out.printf("%4d",i);
        }
        System.out.println();

        for (int rows = 0; rows < MyArray.length; rows++) {
            System.out.printf("%4d",(rows + 1));
            for(int cols = 0; cols < MyArray[rows].length; cols++ ){
                MyArray[rows][cols] = (rows + 1) + (cols + 1);
                System.out.printf("%4d",MyArray[rows][cols]);
            }
            System.out.println();
        }
    }
}
