package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Service {

    @Id
    @PositiveOrZero(message = "El id tiene que ser mayor a 0")
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotBlank(message="El valor no puede ser null ni estar vacío")
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @PositiveOrZero(message = "El valor no puede ser null ni estar vacío")
    @Column(name = "waterCostPerlit", nullable = false)
    private Double waterCostPerlit;//variable fija:
    @PositiveOrZero(message = "El valor no puede ser null ni estar vacío")
    @Column(name = "hoursOfLightPd", nullable = false)
    private Double hoursOfLightPd;
    @PositiveOrZero(message = "El valor no puede ser null ni estar vacío")
    @Column(name = "lightCostPerHour", nullable = false)
    private Double lightCostPerHour;//variable fija:
    @PositiveOrZero(message = "El valor no puede ser null ni estar vacío")
    @Column(name = "litersOfWaterConsumedPd", nullable = false)
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
