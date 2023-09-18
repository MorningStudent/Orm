package student.examples.orm.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import student.examples.orm.entities.Entity;

public abstract class Repository {

    private final String url = "jdbc:postgresql://localhost/e_shop?user=postgres&password=1234&ssl=false";
    protected Connection conn;

    public Repository() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Entity entity) {
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate("INSERT INTO Entity VALUES (" +
            "'DummyEntity', " + entity.getId() + ", '" + entity.getCreatedAt() + "');");
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    public Entity read(int id) {
        Statement st;
        Entity entity = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Entity WHERE id=" + id +";");
            rs.next();
            entity = new Entity(rs.getInt(2), rs.getString(3)) {};
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return entity;
    }

    public void update(Entity entity) {
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate("UPDATE Entity SET created_at='" + entity.getCreatedAt() + "' WHERE id=" + entity.getId() + ";");
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    public void delete(Entity entity) {
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM Entity WHERE id=" + entity.getId() + ";");
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

}
