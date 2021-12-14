package business.services;

import business.persistence.Database;
import business.persistence.MaterialListMapper;

public class MaterialListFacade {
   MaterialListMapper materialListMapper;

   public MaterialListFacade(Database database){
      materialListMapper = new MaterialListMapper(database);
   }
}
