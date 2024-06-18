import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UsreTask {
    public static void studentTask () throws IOException, ParseException {
//
//        if(str.equals("q")){
//            return;
//        }
        JSONArray studentArray = Utils.readJsonArray("question");

        Scanner input = Utils.scannerInput();
        int count = 0;
        int  i =1;
        for (Object questionJsonObj: studentArray) {
                 if(i>10){
                    break;
                 }
            JSONObject questionObj = (JSONObject) questionJsonObj;
            System.out.println("Question."+i+++questionObj.get("question"));
            System.out.println("1. "+questionObj.get("option 1"));
            System.out.println("2. "+questionObj.get("option 2"));
            System.out.println("3. "+questionObj.get("option 3"));
            System.out.println("4. "+questionObj.get("option 4"));
            System.out.println("answer"+questionObj.get("answerkey"));
            int userAnswerKey = input.nextInt();

            Long answerkey = (Long) questionObj.get("answerkey");



            if(answerkey.intValue()==userAnswerKey)
                count++;

            if (count >= 8 && count <= 10) {
                System.out.println("Excellent! You have got " + count + " out of 10");
            } else if (count > 5 && count < 8) {
                System.out.println("Good. You have got " + count + " out of 10");
            } else if (count > 2 && count <= 5) {
                System.out.println("Very poor! You have got " + count + " out of 10");
            } else if (count >= 0 && count <= 2) {
                System.out.println("Very sorry you are failed. You have got " + count + " out of 10");
            } else {
                System.out.println("Invalid marks. Please enter a value between 0 and 10.");
            }

        }




    }
    public static void adminTask() throws IOException, ParseException {
        String fileLocation = "./src/main/resources/questionList.json";
        JSONParser parser = new JSONParser();
        JSONArray userArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject userObj = new JSONObject();
        Scanner input = Utils.scannerInput();

        System.out.println("Input your question");
        String question = input.nextLine();
        System.out.println("Input option 1");
        String option1 = input.nextLine();
        System.out.println("Input option 2");
        String option2 = input.nextLine();
        System.out.println("Input option 3");
        String option3 = input.nextLine();
        System.out.println("Input option 4");
        String option4 = input.nextLine();
        System.out.println("What is the Answer key");
        String answerkey = input.nextLine();



        userObj.put("question",question);
        userObj.put("option 1",option1);
        userObj.put("option 2",option2);
        userObj.put("option 3",option2);
        userObj.put("option 4",option4);
        userObj.put("answerkey",answerkey);
        userArray.add(userObj);
        FileWriter writer = new FileWriter(fileLocation);
        writer.write(userArray.toJSONString());
        writer.flush();
        writer.close();
        System.out.println("Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
        String ifContinue = input.nextLine();
        if(ifContinue.equals("q"))
            return;
        else if (ifContinue.equals("s")) {
            adminTask();
        }

    }
}
