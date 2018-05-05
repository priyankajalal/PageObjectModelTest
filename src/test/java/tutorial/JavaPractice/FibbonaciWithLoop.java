package tutorial.JavaPractice;


public class FibbonaciWithLoop {
    public static void main(String args[]){
        int n=0;
        int n1=0;
        int n2=1;
        while(n<=13)
        {
            n = n1+n2;
            n1=n2;
            n2=n;
            System.out.println(n);
        }

    }

}
