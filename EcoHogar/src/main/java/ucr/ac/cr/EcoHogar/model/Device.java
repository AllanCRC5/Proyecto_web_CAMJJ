package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Device
{
    @Id
    private Integer id;
    private String name;
    private Double usedLight;
    private Integer quantity;

    public Device(Integer id, String name, Double usedLight, Integer quantity) {
        this.id = id;
        this.name = name;
        this.usedLight = usedLight;
        this.quantity = quantity;
    }

    public Device() {
    }

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

    public Double getUsedLight() {
        return usedLight;
    }

    public void setUsedLight(Double usedLight) {
        this.usedLight = usedLight;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
