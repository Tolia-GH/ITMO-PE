package DataBase;
import Data.DotsTable;
import lombok.NoArgsConstructor;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.postgresql.Driver;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@NoArgsConstructor
public class DataBaseStorage implements Serializable {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(DotsTable.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public void addDot(DotsTable dot){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(dot);
        transaction.commit();
        session.close();
    }

    public void addNewDot(DotsTable dot) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Class.forName("org.postgresql.Driver");
        try(Connection connection = DriverManager.getConnection(url)){
            try(PreparedStatement ps= connection.prepareStatement(
                    "INSERT INTO dotstable(hit,r,time,x,y) values (?,?,?,?,?)"
            )){
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
        };
    }
    public void deleteDot(DotsTable dot){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(dot);
        transaction.commit();
        session.close();
    }
}
