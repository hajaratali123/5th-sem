import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CreateDb {
    
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // methods dbMethods = new methods();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java_demo";
            String user = "root";
            String password = "lord@newland";

            Connection connection  = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");

            methods dbMethods = new methods(connection);

            for (;;) {
                System.out.println("Enter the choice");
                System.out.println("1: Inserting the value");
                System.out.println("2: Show all value");
                System.out.println("3: Update value");
                System.out.println("4: Delete Record");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the Id and name ");
                        int id = sc.nextInt();
                        
                        String name = sc.nextLine();

                        dbMethods.insertRecord(id, name);
                        break;

                    case 2:
                        dbMethods.showRecords();
                        break;

                    case 3:
                        System.out.print("Enter the Id: ");
                        int currentId = sc.nextInt();
                        sc.nextLine(); // consume the newline character

                        System.out.print("Enter the name: ");
                        String newname = sc.nextLine();

                        System.out.print("Enter the new Id: ");
                        int newId = sc.nextInt();

                        dbMethods.updateRecord(currentId, newname, newId);
                        break;

                    case 4:
                        System.out.println("Enter the employee id to Delete");
                        int deleteid = sc.nextInt();
                        dbMethods.deleteRecord(deleteid);
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
