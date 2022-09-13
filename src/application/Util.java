package application;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import model.ServiceOrder;

public class Util {

	public static ObjectContainer createManager(){
		
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);
		
        config.common().objectClass(ServiceOrder.class).cascadeOnUpdate(true);
        config.common().objectClass(ServiceOrder.class).cascadeOnDelete(true);
        config.common().objectClass(ServiceOrder.class).cascadeOnActivate(true);
      
		config.common().objectClass(ServiceOrder.class).objectField("tutor").indexed(true);

        config.common().objectClass(ServiceOrder.class).minimumActivationDepth(5);

		ObjectContainer manager = Db4oEmbedded.openFile(config, "pet_databse.db4o");
		return manager;
	}

}
