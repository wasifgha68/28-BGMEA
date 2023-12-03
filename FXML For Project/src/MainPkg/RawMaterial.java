package MainPkg;
import java.io.Serializable;

public class RawMaterial implements Serializable {
    

    private int rawMaterialID;
    private String SupplierName;
    private String materialName;
    private double quantity;
    private double unitPrice;
    private double totalPrice;

    public RawMaterial(int rawMaterialID, String SupplierName, String materialName, double quantity, double unitPrice) {
        this.rawMaterialID = rawMaterialID;
        this.SupplierName= SupplierName;
        this.materialName = materialName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }

    
    public int getRawMaterialID() {
        return rawMaterialID;
    }

    public void setRawMaterialID(int rawMaterialID) {
        this.rawMaterialID = rawMaterialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
        this.totalPrice = quantity * unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }
    public double calculateTotalPrice() {
        return this.quantity * this.unitPrice;
    }

    
    
    
    
}
