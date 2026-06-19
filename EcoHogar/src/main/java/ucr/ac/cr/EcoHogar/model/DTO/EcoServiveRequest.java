package ucr.ac.cr.EcoHogar.model.DTO;

public class EcoServiveRequest
{
    private Integer id;
    private String name;
    private Double waterCostPerLit;
    private Double hoursOfLigthPd;
    private Double ligthCostPerHour;
    private Double litersOfWaterConsumedPd;


    public EcoServiveRequest()
    {

    }//Fin constructor

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWaterCostPerLit() {
        return waterCostPerLit;
    }

    public void setWaterCostPerLit(Double waterCostPerLit) {
        this.waterCostPerLit = waterCostPerLit;
    }

    public Double getHoursOfLigthPd() {
        return hoursOfLigthPd;
    }

    public void setHoursOfLigthPd(Double hoursOfLigthPd) {
        this.hoursOfLigthPd = hoursOfLigthPd;
    }

    public Double getLigthCostPerHour() {
        return ligthCostPerHour;
    }

    public void setLigthCostPerHour(Double ligthCostPerHour) {
        this.ligthCostPerHour = ligthCostPerHour;
    }

    public Double getLitersOfWaterConsumedPd() {
        return litersOfWaterConsumedPd;
    }

    public void setLitersOfWaterConsumedPd(Double litersOfWaterConsumedPd) {
        this.litersOfWaterConsumedPd = litersOfWaterConsumedPd;
    }
}//fin clase
