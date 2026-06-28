package ucr.ac.cr.EcoHogar.model.DTO;

public class EcoServiveRequest
{
    private Integer id;
    private String name;
    private Double waterCostPerlit;
    private Double hoursOfLightPd;
    private Double lightCostPerHour;
    private Double litersOfWaterConsumedPd;

    public EcoServiveRequest() {}

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

    public Double getWaterCostPerlit() {
        return waterCostPerlit;
    }

    public void setWaterCostPerlit(Double waterCostPerlit) {
        this.waterCostPerlit = waterCostPerlit;
    }

    public Double getHoursOfLightPd() {
        return hoursOfLightPd;
    }

    public void setHoursOfLightPd(Double hoursOfLightPd) {
        this.hoursOfLightPd = hoursOfLightPd;
    }

    public Double getLightCostPerHour() {
        return lightCostPerHour;
    }

    public void setLightCostPerHour(Double lightCostPerHour) {
        this.lightCostPerHour = lightCostPerHour;
    }

    public Double getLitersOfWaterConsumedPd() {
        return litersOfWaterConsumedPd;
    }

    public void setLitersOfWaterConsumedPd(Double litersOfWaterConsumedPd) {
        this.litersOfWaterConsumedPd = litersOfWaterConsumedPd;
    }
}//fin clase