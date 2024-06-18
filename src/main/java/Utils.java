import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Utils {

    public static JSONArray readJsonArray(String user) throws IOException, ParseException {
        if(user.equals("user")){
            String fileLocation = "./src/main/resources/userList.json";
            JSONParser parser = new JSONParser();
            JSONArray studentArray = (JSONArray) parser.parse(new FileReader(fileLocation));
            return studentArray;
        }
        else {
            String fileLocation = "./src/main/resources/questionList.json";
            JSONParser parser = new JSONParser();
            JSONArray studentArray = (JSONArray) parser.parse(new FileReader(fileLocation));
            return studentArray;
        }

    }

    public static void writeJsonArray(JSONArray studentArray) throws IOException {
        String fileLocation = "./src/main/resources/userList.json";
        FileWriter writer = new FileWriter(fileLocation);
        writer.write(studentArray.toJSONString());
        writer.flush();
        writer.close();
    }

    public static Scanner scannerInput(){
        Scanner scanInput = new Scanner(System.in);

        return scanInput;
    }
}

