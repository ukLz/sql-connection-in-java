import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class PrviZadatak {
    public static void main(String[] args)
    {
            try
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/korisnik","root","");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM korisnici");
                int broj = 1;
                while (resultSet.next())
                {
                    System.out.println(
                            broj + ". korisnik:" + "\n" +
                            resultSet.getString("ime") + " " +
                            resultSet.getString("prezime") + ", " +
                            resultSet.getString("rodjendan") + ", " +
                            resultSet.getInt("brojtelefona") + ", " +
                            resultSet.getString("email") + "\n" ); broj++;
                }
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
    }
}