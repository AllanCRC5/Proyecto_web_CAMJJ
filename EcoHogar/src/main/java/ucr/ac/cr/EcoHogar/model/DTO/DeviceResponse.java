package ucr.ac.cr.EcoHogar.model.DTO;

public class DeviceResponse
{
    private Integer id;
    private String name;
    private Double usedLigth;
    private Double quantity;

    public DeviceResponse(Integer id, String name, Double usedLigth, Double quantity)
    {
        this.id = id;
        this.name = name;
        this.usedLigth = usedLigth;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getUsedLigth() {
        return usedLigth;
    }

    public Double getQuantity() {
        return quantity;
    }
}//fin clase
