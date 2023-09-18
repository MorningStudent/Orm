package student.examples;

import student.examples.orm.entities.DummyEntity;
import student.examples.orm.repositories.DummyRepository;

public class App {
    public static void main( String[] args ) {
       
        DummyRepository drp = new DummyRepository();
        DummyEntity dme = drp.read(1);
        drp.delete(dme);


    }
}
