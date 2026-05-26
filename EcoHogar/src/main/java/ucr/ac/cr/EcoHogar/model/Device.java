package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Device {
    @Id
    private Integer idDevice;
    private String name;
    private Double usedLight;

    public Device(Integer idDevice, String name, Double usedLight) {
        this.idDevice = idDevice;
        this.name = name;
        this.usedLight = usedLight;
    }

    public Device() {
    }

    public Integer getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Integer idDevice) {
        this.idDevice = idDevice;
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
}
