package business.entities;

public class Screw extends MaterialListComponent{
   private int piecesPrPack;

   public Screw(int productId, String productName, String unit, double price, String desc, int piecesPrPack) {
      super(productId, productName, unit, price, desc);
      this.piecesPrPack = piecesPrPack;
   }

   public int getPiecesPrPack() {
      return piecesPrPack;
   }

   public void setPiecesPrPack(int piecesPrPack) {
      this.piecesPrPack = piecesPrPack;
   }
}
