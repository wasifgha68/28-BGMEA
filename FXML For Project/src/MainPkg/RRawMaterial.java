package MainPkg;
import java.io.Serializable;

public class RRawMaterial implements Serializable {
    private static final long serialVersionUID = 1L;

    private int rawMaterialID;
    private String materialName;
    private double quantity;
    private double unitPrice;
    private double totalPrice;

    public RRawMaterial(int rawMaterialID, String materialName, double quantity, double unitPrice,double totalPrice) {
        this.rawMaterialID = rawMaterialID;
        this.materialName = materialName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }

    // Getters and Setters for all fields
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

    @Override
    public String toString() {
        return "RawMaterialID: " + rawMaterialID +
                ", MaterialName: " + materialName +
                ", Quantity: " + quantity +
                ", UnitPrice: " + unitPrice +
                ", TotalPrice: " + totalPrice;
    }
}
