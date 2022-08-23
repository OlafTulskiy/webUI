package lesson3DZ;

import java.util.Scanner;

public class MainStartClass {

    public void startAPp () throws InterruptedException {
        Scanner scanner =  new Scanner(System.in);
        while(true) {
            System.out.println("Enter number 1 - 4 to start test or 0 - for exit");
            String result = scanner.nextLine();
            if (Integer.parseInt(result) == 0) {
                System.exit(0);
                break;
            }
            switch (result) {
                case "1":
                    System.out.println("You enter 1");
                    RunFirstTest aa = new RunFirstTest();
                    aa.startTest();
                    break;
                case "2":
                    System.out.println("You enter 2");
                    RunSecondTest bb = new RunSecondTest();
                    bb.startTest();
                    //runSecondTest();
                    break;
                case "3":
                    System.out.println("You enter 3");
                    RunThirdTest cc = new RunThirdTest();
                    cc.startTest();
                    //runThirdTest();
                    break;
                case "4":
                    System.out.println("You enter 4");
                    RunFourTest dd = new RunFourTest();
                    dd.startTest();
                    //runFourTest();
                    break;
                default:
                    System.out.println("You enter wrong number");
                    break;
            }
        }
    }

}
