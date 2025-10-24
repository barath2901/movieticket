package Movie.Booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.getConnection;


public class Database {

    public Connection con;
    public Database() throws SQLException{
        con= getConnection("jdbc:mysql://turntable.proxy.rlwy.net:17416/railway","root","yoCpchyKjlCGehRHXayJCOmZqSFnCGGV");
    }
    public int AddTicket(String movie,String seat,String members){
        try{
            PreparedStatement stmt = con.prepareStatement("Insert into ticke (movie,ceat,members) values(?,?,?)");
            stmt.setString(1,movie);
            stmt.setString(2,seat);
            stmt.setString(3,members);
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    public List<Map<String, String>> GetAllUser() {
        List<Map<String, String>> users = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM ticke");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, String> user = new HashMap<>();
                user.put("movie", rs.getString("movie"));
                user.put("ceat", rs.getString("ceat"));
                user.put("members", rs.getString("members"));
                user.put("id", String.valueOf(rs.getInt("id")));
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
    }
    public int DelTicket(String id) throws SQLException {
        String query = "DELETE FROM ticke WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, id);
        int result = stmt.executeUpdate();
        System.out.println("Delete result = " + result);
        return result;
    }


}






