package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "tb_usuario")
public class User
{
    @Id
    @PositiveOrZero(message = "El valor no puede ser null ni estar vacío")
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "El valor no puede ser null ni estar vacío")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @PositiveOrZero(message = "El valor no puede ser null ni estar vacío")
    @Column(name = "memberQuantity", nullable = false)
    private Integer memberQuantity;

    @NotBlank(message = "El valor no puede ser null ni estar vacío")
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @NotBlank(message = "El valor no puede ser null ni estar vacío")
    @Column(name = "password", nullable = false, length = 30)
    private String password;


    @ManyToOne
    @JoinColumn(
            name = "device_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_user_device")
    )
    private Device device;


    @ManyToOne
    @JoinColumn(
            name = "eco_service_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_user_ecoService")
    )
    private EcoService ecoService;


    public User()
    {

    }

    public User(Integer id,
                String name,
                Integer memberQuantity,
                String email,
                String password)
    {
        this.id = id;
        this.name = name;
        this.memberQuantity = memberQuantity;
        this.email = email;
        this.password = password;
    }


    // getters - setters

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

    public Integer getMemberQuantity()
    {
        return memberQuantity;
    }

    public void setMemberQuantity(Integer memberQuantity)
    {
        this.memberQuantity = memberQuantity;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Device getDevice()
    {
        return device;
    }

    public void setDevice(Device device)
    {
        this.device = device;
    }

    public EcoService getEcoService()
    {
        return ecoService;
    }

    public void setEcoService(EcoService ecoService)
    {
        this.ecoService = ecoService;
    }

}