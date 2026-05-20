package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.Entity;

@Entity
public class Service {
    private Double waterCostPerHour;
    private Double hoursOfLight;
    private Double lightCostPerHour;
    private Double litersOfWaterConsumed;

    public Service(Double waterCostPerHour, Double hoursOfLight, Double lightCostPerHour, Double litersOfWaterConsumed) {
        this.waterCostPerHour = waterCostPerHour;
        this.hoursOfLight = hoursOfLight;
        this.lightCostPerHour = lightCostPerHour;
        this.litersOfWaterConsumed = litersOfWaterConsumed;
    }

    public Service() {
    }

    public Double getWaterCostPerHour() {
        return waterCostPerHour;
    }

    public void setWaterCostPerHour(Double waterCostPerHour) {
        this.waterCostPerHour = waterCostPerHour;
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
