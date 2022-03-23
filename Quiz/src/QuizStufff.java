import java.util.*;
public class QuizStufff {

     public void quizStufff(){

        Scanner scanner = new Scanner(System.in);
        UserInfo user1 = new UserInfo("{NAME NOT SET}", 0, "EMAIL NOT SET");
        UserInfo user2 = new UserInfo("{NAME NOT SET}", 0, "EMAIL NOT SET");
        UserInfo user3 = new UserInfo("{NAME NOT SET}", 0, "EMAIL NOT SET");
        UserInfo user4 = new UserInfo("{NAME NOT SET}", 0, "EMAIL NOT SET");


        for (int o = 0; o < 1; o++) {
            System.out.print("\n--USER SELECTION-- \n     1. " + user1.getName() +"    2. "+ user2.getName()+"    3. "+ user3.getName()+"    4. "+ user4.getName()  + "    (5) EXIT \nOPTION:");
            String selectedUser = scanner.nextLine();
            System.out.println();
        selectedUser.toUpperCase();
            switch (selectedUser) {
                case "1", "ONE" -> {
                    for (int i = 0; i < 1; i++) {
                        System.out.println("Hi " + user1.getName() + "     SCORE: " + user1.getScore());
                        System.out.println("WHAT WOULD YOU LIKE TO DO?\n (1) SET USER INFO   (2) PLAY GAME   (3) CHECK SCORE   (4) SHOW USER INFO   (5) CHANGE PLAYER     (6) EXIT\n");
                        String option = scanner.nextLine();
                        switch (option) {
                            case "1" -> {
                                i--;
                                user1.setUserinfo();
                            }
                            case "2" -> {
                                user1.playGame();
                                i--;
                            }
                            case "3" -> {
                                System.out.println("SCORE: " + user1.getScore() + "\n-----------------------------");
                                i--;
                            }
                            case "4" -> {
                                user1.showUserInfo();
                                i--;
                            }
                            case "5" -> o--;
                            case "6" -> {
                                System.out.println("BYE THEN :)");
                                System.out.println("\n");
                            }
                            default -> {
                                System.out.println("ERROR: USE OPTIONS FROM 1 - 5\n");
                                i--;
                            }
                        }
                    }
                }
                case "2", "TWO" -> {
                    label:
                    for (int i = 0; i < 1; i++) {
                        System.out.println("Hi " + user2.getName() + "     SCORE: " + user2.getScore());
                        System.out.println("WHAT WOULD YOU LIKE TO DO?\n (1) SET USER INFO   (2) PLAY GAME   (3) CHECK SCORE   (4) SHOW USER INFO   (5) CHANGE PLAYER     (6) EXIT\n");
                        String option = scanner.nextLine();
                        switch (option) {
                            case "1":
                                user2.setUserinfo();
                                i--;
                                break;
                            case "2":
                                user2.playGame();
                                i--;
                                break;
                            case "3":
                                System.out.println("SCORE: " + user2.getScore() + "\n-----------------------------");
                                i--;
                                break;
                            case "4":
                                user2.showUserInfo();
                                i--;
                                break;
                            case "5":
                                o--;
                                break;
                            case "6":
                                System.out.println("BYE THEN :)");
                                System.out.println("\n");
                                break label;
                            default:
                                System.out.println("ERROR: USE OPTIONS FROM 1 - 5\n");
                                i--;
                                break;
                        }
                    }
                }
                case "3", "THREE" -> {
                    label:
                    for (int i = 0; i < 1; i++) {
                        System.out.println("Hi " + user3.getName() + "     SCORE: " + user3.getScore());
                        System.out.println("WHAT WOULD YOU LIKE TO DO?\n (1) SET USER INFO   (2) PLAY GAME   (3) CHECK SCORE   (4) SHOW USER INFO   (5) CHANGE PLAYER     (6) EXIT\n");
                        String option = scanner.nextLine();
                        switch (option) {
                            case "1":
                                user3.setUserinfo();
                                i--;
                                break;
                            case "2":
                                user3.playGame();
                                i--;
                                break;
                            case "3":
                                System.out.println("SCORE: " + user3.getScore() + "\n-----------------------------");
                                i--;
                                break;
                            case "4":
                                user3.showUserInfo();
                                i--;
                                break;
                            case "5":
                                o--;
                                break;
                            case "6":
                                System.out.println("BYE THEN :)");
                                System.out.println("\n");
                                break label;
                            default:
                                System.out.println("ERROR: USE OPTIONS FROM 1 - 5\n");
                                i--;
                                break;
                        }
                    }
                }
                case "4", "FOUR" -> {
                    label:
                    for (int i = 0; i < 1; i++) {
                        System.out.println("Hi " + user4.getName() + "     SCORE: " + user4.getScore());
                        System.out.println("WHAT WOULD YOU LIKE TO DO?\n (1) SET USER INFO   (2) PLAY GAME   (3) CHECK SCORE   (4) SHOW USER INFO   (5) CHANGE PLAYER     (6) EXIT\n");
                        String option = scanner.nextLine();
                        switch (option) {
                            case "1":
                                user4.setUserinfo();
                                i--;
                                break;
                            case "2":
                                user4.playGame();
                                i--;
                                break;
                            case "3":
                                System.out.println("SCORE: " + user4.getScore() + "\n-----------------------------");
                                i--;
                                break;
                            case "4":
                                user4.showUserInfo();
                                i--;
                                break;
                            case "5":
                                o--;
                                break;
                            case "6":
                                System.out.println("BYE THEN :)");
                                System.out.println("\n");
                                break label;
                            default:
                                System.out.println("ERROR: USE OPTIONS FROM 1 - 5\n");
                                i--;
                                break;
                        }
                    }
                }
                case "5", "FIVE" -> System.out.println("BYE Then :)");
                default -> {
                    System.out.println("!!!--ERROR--!!!\n");
                    o--;
                }
            }
        }
    }
}

