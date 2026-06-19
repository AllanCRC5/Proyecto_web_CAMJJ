package ucr.ac.cr.EcoHogar.model.DTO;

public class UserRequest
{
    private Integer id;
    private String  name;
    private Integer memberQuantity;
    private String email;
    private String password;


    public UserRequest()
    {

    }// fin vacio

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

    public Integer getMemberQuantity() {
        return memberQuantity;
    }

    public void setMemberQuantity(Integer memberQuantity) {
        this.memberQuantity = memberQuantity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)  {
        this.password = password;
    }
}// fin class
