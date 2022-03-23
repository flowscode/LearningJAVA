import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class UserInfo extends Quiz {

    Scanner scanner = new Scanner(System.in);

    private String name;
    private int age;
    private String emailAddress;
    private int score = 0;
    String[] question1 = {"BOB", "JOHN", "RICK", "STEVE"};
    String[] question2 = {"CAKE", "PIE", "ICE-CREAM", "TART"};

    public UserInfo(String userName, int userAge, String userEmail){
        this.name = userName;
        this.age = userAge;
        this.emailAddress = userEmail;
    }

    void setUserinfo() {
        System.out.print("ENTER NAME: ");
        this.name = scanner.nextLine();
        System.out.print("ENTER AGE: ");
        this.age = scanner.nextInt();
        //System.out.println();
        System.out.print("ENTER EMAIL ADDRESS: ");
        scanner.nextLine();
        this.emailAddress = scanner.nextLine();
        System.out.println();

    }

    String showUserInfo(){
        String info = "\n--- USER INFO --- \n" + "NAME: " + this.name + "\nAGE: " + this.age + "\nSCORE: " + this.score + "\nEMAIL: " + this.emailAddress;
        System.out.println(info+"\n-----------------------------");
        System.out.println();
        return info;
    }

    String setName(String name){
        this.name = name;
        return this.name;
    }

    int setAge(int age){
        this.age = age;
        return this.age;
    }

    String setEmail(String email){
        this.emailAddress = email;
        return this.emailAddress;
    }

    String getName() {
        String name = this.name;
        return name;
    }

    int getScore() {
        int score = this.score;
        return score;
    }


    //THE GAME //
    void playGame() {
        String answer;
        for (int a = 0; a < 1; a++){
            System.out.println("Hello " + this.name + ". Are you ready to play? \n (Y) = YES    (N) = NO\n");
            System.out.print("INPUT OPTION ----> ");
            answer = scanner.nextLine();
            if (answer.equals("y") || answer.equals("Y")) {
                answer.toUpperCase();
                System.out.println("Great, LETS PLAY!! :D\n");

                System.out.println("""
                        (A) Order these comedians from BEST to WORST. (REMEMBER: My opinion, not yours ;)
                             (1) BOB    (2) JOHN    (3) RICK    (4) STEVE
                        """);
                for (int i = 0; i < 1; i++) {
                int answerA = scanner.nextInt();
                System.out.println();
                    if (answerA == 3421){
                        System.out.println("Exactly what i think :D --- 100 Points!!!");
                        this.score = this.score + 100;
                    } else if(answerA == 3412 || answerA == 4321){
                        System.out.println("mmmmmm, Half correct :) --- 50 Points");
                        this.score = this.score + 50;
                    } else if (answerA < 1234 || answerA > 4321) {
                        System.out.println("{ERROR} -- TRY AGAIN --");
                        System.out.println();
                        System.out.println("""
                                (A) Order these comedians from BEST to WORST. (REMEMBER: My opinion, not yours ;)

                                     (1) BOB     (2) JOHN     (3) RICK     (4) STEVE
                                """);
                        i--;
                    } else {
                        System.out.println("Not good enough :(");
                    }
                }
                System.out.println("""
                        (B) Order these desserts from WORST to BEST. (REMEMBER: My opinion, not yours ;)

                             (1) CAKE     (2) PIE     (3) ICE-CREAM     (4) TART
                             """);
                for (int j = 0; j < 1; j++) {
                int answerB = scanner.nextInt();
                System.out.println();
                    if (answerB == 2431){
                        System.out.println("Exactly what i think :D --- 100 Points!!!");
                        this.score = this.score + 100;
                    } else if(answerB == 2413 || answerB == 4231){
                        System.out.println("mmmmmm, Half correct :) --- 50 Points");
                        this.score = this.score + 50;
                    } else if (answerB < 1234 || answerB > 4321) {
                        System.out.println("{ERROR} -- TRY AGAIN --");
                        System.out.println("""
                                    (B) Order these desserts from WORST to BEST. (REMEMBER: My opinion, not yours ;)
                                    
                                         (1) CAKE     (2) PIE     (3) ICE-CREAM     (4) TART
                                    """);
                        j--;
                    } else {
                        System.out.println("Not good enough :(");
                    }
                }

            } else if (answer.equals("n") || answer.equals("N")) {
                answer.toUpperCase();
                System.out.println("BYE Then :)");
            } else {
                System.out.println("ERROR: Use only N or Y ");
                a--;
            }
        }


    }

}
