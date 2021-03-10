import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class sparseArray {
    public sparseArray() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        int chessArray[][]=new int[11][11];
        chessArray[1][2]=1;
        chessArray[2][3]=2;
        chessArray[10][10]=6;

        for (int [] row: chessArray) {

            for(int data:row){
                System.out.printf("%d\t",data);
            }

            System.out.println();
        }
        System.out.println("#############1");
        int sum=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if(chessArray[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);

        //创建对应稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        int count=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if(chessArray[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArray[i][j];
                }
            }
        }
        //遍历稀疏数组
        for (int i = 0; i <sparseArr.length ; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();
        System.out.println("#################2");


        int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int [] row:
             chessArr2) {
            for (int data:
                 row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将稀疏数组写入d盘
        File file =new File("D:\\map.data");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                fileOutputStream.write((chessArray[i][j]+"").getBytes());
            }
            fileOutputStream.write(("\n").getBytes());
        }

        //拷贝稀疏数组
        File file2 =new File("D:\\map_sparse.data");
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        fileOutputStream2.write("11\t".getBytes());
        fileOutputStream2.write("11\t".getBytes());
        fileOutputStream2.write((sum+""+"\t").getBytes());
        fileOutputStream2.write(("\n").getBytes());
        for (int i = 1; i <sparseArr.length ; i++) {

            fileOutputStream2.write((sparseArr[i][0]+"\t").getBytes());
            fileOutputStream2.write((sparseArr[i][1]+"\t").getBytes());
            fileOutputStream2.write((sparseArr[i][2]+"\t").getBytes());
            fileOutputStream2.write(("\n").getBytes());
        }


        fileOutputStream.close();
        fileOutputStream2.close();
    }



}
