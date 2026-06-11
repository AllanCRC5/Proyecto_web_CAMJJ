package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity// para decir que la clase sera una entidad
@Table(name = "tb_usuario")// se renombra la tabla para evitar un problema con la base de datos
public class User
{
    @Id// establece que el dato de abajo sera la llave foranea
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
    @Column(name = "password",  nullable = false, length = 30)
    private  String password;


    // Conexion con clase Device
    @ManyToOne
    @JoinColumn
            (
                    name = "Device_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_user_device")
            )
    private Device Device;



    //Conexion con clase Service
    @ManyToOne
    @JoinColumn
            (
                    name = "EcoService_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_user_ecoService")
            )
    private EcoService EcoService;


    public User()
    {

    }


    public User(Integer id, String name, Integer memberQuantity, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.memberQuantity = memberQuantity;
        this.email = email;
        this.password = password;
    }



    public Integer getId()
    {
        return id;
    }

    public void setId(Integer idFamily)
    {
        this.id = idFamily;
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
        return Device;
    }

    public void setDevice(Device device)
    {
        Device = device;
    }

    public EcoService getEcoService()
    {
        return EcoService;
    }

    public void setEcoService(EcoService ecoService)
    {
        EcoService = ecoService;
    }
}//fin clase