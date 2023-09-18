package student.examples.orm.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import student.examples.orm.entities.DummyEntity;
import student.examples.orm.entities.Entity;

public class DummyRepository extends Repository {

    @Override
    public void create(Entity entity) {
        super.create(entity);
        Statement st;
        DummyEntity dummyEntity = (DummyEntity)entity;
        try {
            st = conn.createStatement();
            st.executeUpdate("INSERT INTO DummyEntity VALUES (" + entity.getId() + ", '" + dummyEntity.getTestValue() + "');");
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public DummyEntity read(int id) {
        Entity entity = super.read(id);
        Statement st;
        DummyEntity dummyEntity = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM DummyEntity WHERE entity_id=" + id +";");
            rs.next();
            dummyEntity = new DummyEntity(entity.getId(), entity.getCreatedAt(), rs.getString(2));
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return dummyEntity;
    }

    @Override
    public void update(Entity entity) {
        super.update(entity);
        Statement st;
        DummyEntity dummyEntity = (DummyEntity)entity;
        try {
            st = conn.createStatement();
            st.executeUpdate("UPDATE DummyEntity SET test_value='" + dummyEntity.getTestValue() + "' WHERE entity_id=" + entity.getId() + ";");
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Entity entity) {
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM DummyEntity WHERE entity_id=" + entity.getId() + ";");
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        super.delete(entity);
    }

    

    
    
}
