
public class SpareseArray {
    public static void main(String[] args) {
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[6][10] = 2;

        for (int[] chess : chessArray) {
            //for循环增强底层是迭代器遍历 但是 简化迭代器的书写格式。
            // (注意：增强for循环的底层还是使用了迭代器遍历。)。
            // for（int【】 array ：chessArray）{}
            // for(数据类型 变量名 :遍历的目标){ //数据类型 变量名:声明一个变量用来接收遍历目标遍历后的元素
            //
            //}
            // for增强和正常for一样 ，小一级循坏 ，数组变成字符，二维先转成一维数组再转成字符
            //多位数组的嵌套层只会 获取上一层级的内存地址[I@10f87f48

//            for (int data : chess) {
//                System.out.printf("%d\t", data);
//
//            }

            for (int data :chess){
                //  %s  字符串      %c             字符
                //      %d             有符号十进制整数
                //      %f              浮点数(包括float和doulbe)
                //  \t 代表一个空格
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //遍历原始的二维数组得到有效个数sum
        int sum=0;
        for (int i = 0; i <chessArray.length ; i++) {
            for (int j = 0; j <chessArray.length ; j++) {
                if (chessArray[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建数组必须给予行数与列数 int【x】【y】
        int SparseArray[][]=new int[sum+1][3];
        SparseArray[0][0]=chessArray.length;
        SparseArray[0][1]=chessArray[0].length;
        SparseArray[0][2]=sum;

        //需要获取具体个数，不能需要使用传统for循环
        int count=0;
        for (int i = 0; i <chessArray.length ; i++) {
            for (int j = 0; j <chessArray.length    ; j++) {

                if (chessArray[i][j] != 0){
                    count++;
                    SparseArray[count][0]=i;
                    SparseArray[count][1]=j;
                    SparseArray[count][2]=chessArray[i][j];
                }

            }
        }

        //遍历稀疏数组 输出
        System.out.println("----------------------");
        for (int i= 0;i<SparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",SparseArray[i][0],SparseArray[i][1],SparseArray[i][2]);
        }
        System.out.println();
//        System.out.println("\t".length());

        //转回 原始数组
        // 1创建原始数组
        int[][] chessNew=new int[SparseArray[0][0]][SparseArray[0][1]];


        //遍历稀疏数组给原始数组赋值
        for (int i = 1; i <SparseArray.length ; i++) {
            chessNew[SparseArray[i][0]][SparseArray[i][1]]=SparseArray[i][2];
        }


        for (int[] chess : chessNew) {
            //for循环增强底层是迭代器遍历 但是 简化迭代器的书写格式。
            // (注意：增强for循环的底层还是使用了迭代器遍历。)。
            // for（int【】 array ：chessArray）{}
            // for(数据类型 变量名 :遍历的目标){ //数据类型 变量名:声明一个变量用来接收遍历目标遍历后的元素
            //
            //}
            // for增强和正常for一样 ，小一级循坏 ，数组变成字符，二维先转成一维数组再转成字符
            //多位数组的嵌套层只会 获取上一层级的内存地址[I@10f87f48

//            for (int data : chess) {
//                System.out.printf("%d\t", data);
//
//            }

            for (int data :chess){
                //  %s  字符串      %c             字符
                //      %d             有符号十进制整数
                //      %f              浮点数(包括float和doulbe)
                //  \t 代表一个空格
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }



    }
}
