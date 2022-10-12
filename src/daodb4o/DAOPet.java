package daodb4o;

import java.util.List;
import com.db4o.query.Query;
import application.Create;
import model.Pet;

public class DAOPet {
    public Pet read(Object chave){
        String name = (String) chave;
        Query q = Create.manager.query();
        q.constrain(Pet.class);
        q.descend("name").constrain(name);
        List<Pet> resultados = q.execute();
        if (resultados.size()>0)
            return resultados.get(0);
        else
            return null;
    }

    public int size(){
        Query q = Create.manager.query();
        q.constrain(Pet.class);
        return q.execute().size();
    }
}
