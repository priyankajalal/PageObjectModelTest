package tutorial.JavaPractice;


public class FibbonaciWithRecursion {
    public static void main(String args[]){

        for (int i=0;i<=10;i++) {
            System.out.println(fibb(i));
        }
    }

    static int fibb(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        return fibb(n-2)+fibb(n-1);

    }
}
