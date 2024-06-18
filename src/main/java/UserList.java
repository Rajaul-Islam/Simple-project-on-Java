import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class UserList {

    public void writeUser() throws IOException, ParseException {

//        Scanner input = new Scanner(System.in);
//        System.out.println("enter the student name");
//        String name = input.nextLine();
//        System.out.println("enter the student id");
//        String id = input.nextLine();
//        System.out.println("enter the student department");
//        String department = input.nextLine();


        String fileLocation = "./src/main/resources/userList.json";
        JSONParser parser = new JSONParser();
        JSONArray userArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject userObj = new JSONObject();
        userObj.put("username","rabbi");
        userObj.put("password","1234");
        userObj.put("role","student");
        userArray.add(userObj);
        FileWriter writer = new FileWriter(fileLocation);
        writer.write(userArray.toJSONString());
        writer.flush();
        writer.close();



    }

    public void  readJsonArray() throws ParseException, IOException {
        JSONArray studentArray = Utils.readJsonArray("user");


        for (int i = 0; i < studentArray.size(); i++) {
            System.out.println("Details of student number" + (i + 1));
            JSONObject studentObj = (JSONObject) studentArray.get(i);
            String name = studentObj.get("username").toString();
            String id = studentObj.get("role").toString();
            String department = studentObj.get("password").toString();
            System.out.println(name + "\n" + id + "\n" + department);

        }

    }

    public static void main(String[] args) throws IOException, ParseException {
        UserList user = new UserList();
//                user.writeUser();
                user.readJsonArray();
    }
}
