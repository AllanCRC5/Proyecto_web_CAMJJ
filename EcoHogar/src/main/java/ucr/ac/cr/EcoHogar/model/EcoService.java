package ucr.ac.cr.EcoHogar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

@Entity// para decir que la clase sera una entidad
@Table(name = "EcoService_tb")
public class EcoService
{

    @Id// establece que el dato de abajo sera la llave foranea
    @PositiveOrZero(message = "El id tiene que ser mayor a 0")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public EcoService(Double waterCostPerHour, Double hoursOfLightPd, Double lightCostPerHour, Double litersOfWaterConsumedPd)
    {
        this.waterCostPerlit = waterCostPerHour;
        this.hoursOfLightPd = hoursOfLightPd;
        this.lightCostPerHour = lightCostPerHour;
        this.litersOfWaterConsumedPd = litersOfWaterConsumedPd;
    }


    //crear relaciones
    @OneToMany(mappedBy = "ecoService")//crea la llave foránea
    @JsonIgnore
    private List<User> listUser;


    public EcoService()
    {
        //Valores pre-establecidos de costo de agua y luz en colones y por hora
        this.lightCostPerHour = 100.0;
        this.waterCostPerlit = 0.6;
    }

    public Double getWaterCostPerlit()
    {
        return waterCostPerlit;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setWaterCostPerlit(Double waterCostPerlit)
    {
        this.waterCostPerlit = waterCostPerlit;
    }

    public Double getHoursOfLightPd()
    {
        return hoursOfLightPd;
    }

    public void setHoursOfLightPd(Double hoursOfLightPd)
    {
        this.hoursOfLightPd = hoursOfLightPd;
    }

    public Double getLightCostPerHour()
    {
        return lightCostPerHour;
    }

    public void setLightCostPerHour(Double lightCostPerHour)
    {
        this.lightCostPerHour = lightCostPerHour;
    }

    public Double getLitersOfWaterConsumedPd()
    {
        return litersOfWaterConsumedPd;
    }

    public void setLitersOfWaterConsumedPd(Double litersOfWaterConsumedPd)
    {
        this.litersOfWaterConsumedPd = litersOfWaterConsumedPd;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}//fin clase
