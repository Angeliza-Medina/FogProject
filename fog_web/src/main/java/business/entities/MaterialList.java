package business.entities;

import java.util.ArrayList;

public class MaterialList {
   ArrayList<MaterialListComponent> materialListComponents;

   public MaterialList(ArrayList<MaterialListComponent> materialListComponents){
      this.materialListComponents = materialListComponents;
   }

   public ArrayList<MaterialListComponent> getProducts() {
      return materialListComponents;
   }

   public void setProducts(ArrayList<MaterialListComponent> materialListComponents) {
      this.materialListComponents = materialListComponents;
   }
}
