
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Controller class used to let users log in.
 * Mainly used in usecase 1
 */
public class UserAuthCtrl extends DBConn {

  /***
   * Checks if there exists a user with the given email and password.
   * @param email
   * @param password
   * @return true if a matching user was found, false otherwise.
   */
  public boolean login(String email, String password) {
    try {
      String query = "Select * From User Where Email = (?) And user_Password = (?)";
      PreparedStatement statement = conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);

      // Checks if result set has an entry
      ResultSet result = statement.executeQuery();
      return result.next();
    } catch (Exception e) {
      System.out.println("db error during login query");
    }
    return false;
  }

}
