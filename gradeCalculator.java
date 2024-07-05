import java.util.Scanner;

public class encryptix {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter your Theory of Computation Marks out of 100:");
        float tc=sc.nextFloat();
        System.out.println("Enter your Operating System Marks out of 100:");
        float os=sc.nextFloat();

        System.out.println("Enter your Computer Graphics Marks out of 100:");
        float cg=sc.nextFloat();

        System.out.println("Enter your Robotics Marks out of 100:");
        float rb=sc.nextFloat();

        System.out.println("Enter your Deep Learning Marks out of 100:");
        float dl=sc.nextFloat();

        float avg= (tc+os+cg+rb+dl)/500;
        float percentage=avg*100;
       float total= (tc+os+cg+rb+dl);
        
        System.out.println("Your Total out of 500 is:"+ total);
        System.out.println("Your percentage is:"+percentage);

        if(percentage<40){
            System.out.println("You are Failed");
        }
        else if(41 <=percentage && percentage <=50){
            System.out.println("Grade:D");
        }
        else if(51 <=percentage && percentage<=60){
            System.out.println("Grade:C");
        }
        else if(61<= percentage && percentage<=70){
            System.out.println("Grade:B");
        }
        else if(71<= percentage && percentage <=80){
            System.out.println("Grade:B+");
        }
        else if(81<= percentage && percentage<=90){
            System.out.println("Grade:A");
        }
        else{
            System.out.println("Grade:A+");
        }


    }
}
