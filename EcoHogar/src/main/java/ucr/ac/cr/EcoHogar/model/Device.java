package ucr.ac.cr.EcoHogar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity// para decir que la clase sera una entidad
public class Device
{
    @Id// establece que el dato de abajo sera la llave foranea
    @PositiveOrZero(message = "El valor no puede ser null ni puede estar vacío")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message="El valor no puede ser null ni puede estar vacío")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @PositiveOrZero(message = "El valor no puede ser null ni puede estar vacío")
    @Column(name = "usedLight", nullable = false)
    private Double usedLight;

    @PositiveOrZero(message = "El valor no puede ser null ni puede estar vacío")
    @Column(name = "quantity", nullable = false)
    private Double quantity;

    public Device(Integer id, String name, Double usedLight, Double quantity)
    {
        this.id = id;
        this.name = name;
        this.usedLight = usedLight;
        this.quantity = quantity;
    }

    //crear relaciones
    @OneToMany(mappedBy = "Device")//crea la llave foránea
    @JsonIgnore
    private List<User> listUser;



    public Device()
    {

    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getUsedLight()
    {
        return usedLight;
    }

    public void setUsedLight(Double usedLight)
    {
        this.usedLight = usedLight;
    }

    public Double getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Double quantity)
    {
        this.quantity = quantity;
    }
}//fin clase
