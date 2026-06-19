package ucr.ac.cr.EcoHogar.model.DTO;

public class DeviceRequest
{
    private Integer id;
    private String name;
    private Double usedLigth;
    private Double quantity;

    public DeviceRequest()
    {

    }//Fin constructor

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUsedLigth() {
        return usedLigth;
    }

    public void setUsedLigth(Double usedLigth) {
        this.usedLigth = usedLigth;
    }
}//Fin clase




