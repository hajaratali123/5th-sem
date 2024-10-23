import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class methods {

    Queryes q=new Queryes();
    private static Connection connection ;

   

    public methods(Connection connection) {
        this.connection = connection;
    }
  


    public  void insertRecord(int id, String name) {
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(q.insertQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            System.out.println("Person created successfully.");
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void showRecords() {
       
        try (PreparedStatement preparedStatement = connection.prepareStatement(q.selectQuery);
             var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", \nName: " + resultSet.getString("name"));
                System.out.println("_________________________");
             
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(int currentId, String newname, int newId) {
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(q.updateQuery)) {
            preparedStatement.setString(1, newname);
            preparedStatement.setInt(2, newId);
            preparedStatement.setInt(3, currentId);
            preparedStatement.executeUpdate();
            System.out.println("Person updated successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(int deleteid) {
   
        try (PreparedStatement preparedStatement = connection.prepareStatement(q.deleteQuery)) {
            preparedStatement.setInt(1, deleteid);
            preparedStatement.executeUpdate();
            System.out.println("Person deleted successfully.");
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

