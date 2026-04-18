import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StockPortfolioJDBC {

    public static void main(String[] args) {

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/stockdb",
                "root",
                "password"
            );

            // Step 3: Create Statement
            Statement stmt = con.createStatement();

            // Step 4: Insert Data
            String insertQuery = 
                "INSERT INTO portfolio VALUES (1, 'TCS', 10, 3500)";
            stmt.executeUpdate(insertQuery);

            System.out.println("Record Inserted Successfully");

            // Step 5: Retrieve Data
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM portfolio"
            );

            System.out.println("\nStock Portfolio Details:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("stock_id") + " | " +
                    rs.getString("stock_name") + " | " +
                    rs.getInt("quantity") + " | " +
                    rs.getDouble("price")
                );
            }

            // Step 6: Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
