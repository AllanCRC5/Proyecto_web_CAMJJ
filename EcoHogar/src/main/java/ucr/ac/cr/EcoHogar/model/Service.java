package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Service {

    @Id
    private Integer id;
    private String name;
    private Double waterCostPerlit;
    private Double hoursOfLight;
    private Double lightCostPerHour;
    private Double litersOfWaterConsumed;

    public Service(Double waterCostPerHour, Double hoursOfLight, Double lightCostPerHour, Double litersOfWaterConsumed) {
        this.waterCostPerlit = waterCostPerHour;
        this.hoursOfLight = hoursOfLight;
        this.lightCostPerHour = lightCostPerHour;
        this.litersOfWaterConsumed = litersOfWaterConsumed;
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

    public Double getHoursOfLight() {
        return hoursOfLight;
    }

    public void setHoursOfLight(Double hoursOfLight) {
        this.hoursOfLight = hoursOfLight;
    }

    public Double getLightCostPerHour() {
        return lightCostPerHour;
    }

    public void setLightCostPerHour(Double lightCostPerHour) {
        this.lightCostPerHour = lightCostPerHour;
    }

    public Double getLitersOfWaterConsumed() {
        return litersOfWaterConsumed;
    }

    public void setLitersOfWaterConsumed(Double litersOfWaterConsumed) {
        this.litersOfWaterConsumed = litersOfWaterConsumed;
    }
}
