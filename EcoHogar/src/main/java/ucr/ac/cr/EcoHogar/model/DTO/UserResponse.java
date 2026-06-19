package ucr.ac.cr.EcoHogar.model.DTO;

public class UserResponse
{
    private Integer id;
    private String  name;
    private Integer memberQuantity;
    private String email;
    private String password;

    public UserResponse(Integer id, String name, Integer memberQuantity, String password, String email)
    {
        this.id = id;
        this.name = name;
        this.memberQuantity = memberQuantity;
        this.password = password;
        this.email = email;
    }//fin constructor

    public Integer getId() {
        return id;
    }

    public Integer getMemberQuantity() {
        return memberQuantity;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}//fin class
