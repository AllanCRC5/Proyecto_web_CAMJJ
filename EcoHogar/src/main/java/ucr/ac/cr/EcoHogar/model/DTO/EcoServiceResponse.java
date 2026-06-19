package ucr.ac.cr.EcoHogar.model.DTO;

public class EcoServiceResponse
{
    private Integer id;
    private String name;
    private Double waterCostPerLit;
    private Double hoursOfLigthPd;
    private Double ligthCostPerHour;
    private Double litersOfWaterConsumedPd;

    public EcoServiceResponse(Integer id, String name, Double waterCostPerLit, Double ligthCostPerHour, Double hoursOfLigthPd, Double litersOfWaterConsumedPd) {
        this.id = id;
        this.name = name;
        this.waterCostPerLit = waterCostPerLit;
        this.ligthCostPerHour = ligthCostPerHour;
        this.hoursOfLigthPd = hoursOfLigthPd;
        this.litersOfWaterConsumedPd = litersOfWaterConsumedPd;
    }//fin clase


    public Integer getId() {
        return id;
    }

    public Double getWaterCostPerLit() {
        return waterCostPerLit;
    }

    public String getName() {
        return name;
    }

    public Double getHoursOfLigthPd() {
        return hoursOfLigthPd;
    }

    public Double getLitersOfWaterConsumedPd() {
        return litersOfWaterConsumedPd;
    }

    public Double getLigthCostPerHour() {
        return ligthCostPerHour;
    }
}//fin class
