package modelos;

public class Producto {

    private String nombreProducto;
    private Double valorProducto;

    public Producto(String nombreProducto, Double valorProducto) {
        this.nombreProducto = nombreProducto;
        this.valorProducto = valorProducto;
    }
    @Override
    public String toString() {
        return this.getNombreProducto() + " - " + this.getValorProducto();
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(Double valorProducto) {
        this.valorProducto = valorProducto;
    }
}
