package DataBase;

import Data.DotsTable;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@NoArgsConstructor
public class DataBaseStorage implements Serializable {

    public void addNewDot(DotsTable dot) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Class.forName("org.postgresql.Driver");
        try(Connection connection = DriverManager.getConnection(url,"postgres","123456")){
            try(PreparedStatement ps= connection.prepareStatement(
                    "INSERT INTO web_lab3.dotstable(hit,r,time,x,y) values (?,?,?,?,?)"
            )) {
                ps.setBoolean(1,dot.isHit());
                ps.setDouble(2,dot.getR());
                ps.setObject(3,dot.getTime());
                ps.setDouble(4,dot.getX());
                ps.setDouble(5,dot.getY());
                ps.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
