import java.util.*;
import java.io.*;
public class CSV {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, ArrayList<User>> records = new HashMap<String, ArrayList<User>>();
        Map<String, ArrayList<User>> filtered_records = new HashMap<String, ArrayList<User>>();
        ArrayList<User> list_of_users = new ArrayList<User>();
        Scanner scanner = new Scanner(new File("example.csv"));
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data_points = line.trim().split(",");
            User current_user = new User(data_points[0],data_points[1],data_points[2],Integer.parseInt(data_points[3]),data_points[4]);
            list_of_users.add(current_user);
            if(records.containsKey(data_points[4])) {
                records.get(data_points[4]).add(current_user);
            } else {
                filtered_records.put(data_points[4], new ArrayList<User>());
                records.put(data_points[4], new ArrayList<User>());
                records.get(data_points[4]).add(current_user);
            }
        }
        for(Map.Entry<String, ArrayList<User>> entry : records.entrySet()) {
            ArrayList<User> users = entry.getValue();
            HashMap<String, User> auxilary = new HashMap<String, User>();
            for(User user : users) {
                if(auxilary.containsKey(user.UserId)) {
                    if(auxilary.get(user.UserId).version < user.version) {
                        auxilary.put(user.UserId, user);
                    }
                } else {
                    auxilary.put(user.UserId, user);
                }
            }
            for(User user : auxilary.values()) {
                filtered_records.get(entry.getKey()).add(user);
            }
        }
        for(ArrayList<User> something : filtered_records.values()) {
            something.sort((e1, e2) -> {
                if(e1.LastName.compareToIgnoreCase(e2.LastName) != 0) {
                    return e1.LastName.compareToIgnoreCase(e2.LastName);
                }
                return e1.FirstName.compareToIgnoreCase(e2.FirstName);
            });
        }
        for(HashMap.Entry<String, ArrayList<User>> everything : filtered_records.entrySet()) {
            String filename = everything.getKey();
            ArrayList<User> users = everything.getValue();
            File theCompany = new File(filename);
            FileWriter writer = new FileWriter(filename);
            for(User user : users) {
                writer.write(user.prettyPrint());
            }
            writer.close();
        }
    }
}