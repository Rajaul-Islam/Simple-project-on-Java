import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;


public class CheckUser {


    public CheckUser() throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your UserName");
        String role = input.nextLine();
        System.out.println("Enter Your Password");
        String password = input.nextLine();

        JSONArray users = Utils.readJsonArray("user");
        for (Object userObj : users) {
            JSONObject userJsonObj = (JSONObject) userObj;

            char choice;
            if (role.equals("student") && password.equals("1234")) {
//                do {
//
//                    System.out.println("Welcome to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' for start.");
//                    choice = input.next().charAt(0);
//
//                    if (choice == 's') {
//                        UsreTask.studentTask();
//                    }
//                    System.out.println("Would you like to start again? press 's' for start or 'q' for quit.");
//                    choice = input.next().charAt(0);
//                    if (choice == 's')
//                        UsreTask.studentTask();
//                } while (choice != 'q');

                System.out.println("Welcome salman to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start");
                String studentCall = input.nextLine();

                int i = 0;
                while (studentCall.equals("s")) {
                    if (i == 0) {
                            UsreTask.studentTask();

                    } else if(studentCall.equals("s")){
                        System.out.println("Would you like to start again? press s for start or q for quit");
                        studentCall = input.nextLine();
                        if (studentCall.equals("s"))
                            UsreTask.studentTask();
                    }
                    i++;
                }


            } else if (role.equals("admin") && password.equals("1234")) {
                System.out.println("Welcome admin! Please create new questions in the question bank.");
                UsreTask.adminTask();
                break;

            }


        }

    }

    public static void main(String[] args) throws ParseException, IOException {

        CheckUser users = new CheckUser();

    }
}
