package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Service {

    @Id
    private Integer id;
    private String name;
    private Double waterCostPerlit;//variable fija:
    private Double hoursOfLightPd;
    private Double lightCostPerHour;//variable fija:
    private Double litersOfWaterConsumedPd;

    public Service(Double waterCostPerHour, Double hoursOfLightPd, Double lightCostPerHour, Double litersOfWaterConsumedPd) {
        this.waterCostPerlit = waterCostPerHour;
        this.hoursOfLightPd = hoursOfLightPd;
        this.lightCostPerHour = lightCostPerHour;
        this.litersOfWaterConsumedPd = litersOfWaterConsumedPd;
    }

    public Service() {
    }

    public Double getWaterCostPerlit() {
        return waterCostPerlit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
