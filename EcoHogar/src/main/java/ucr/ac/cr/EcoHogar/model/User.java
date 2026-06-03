package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class User
{

    @Id
    private Integer id;
    private String name;
    private Integer memberQuantity;
    private String email;
    private  String password;

    public User() {
    }

    public User(Integer id, String name, Integer memberQuantity, String email, String password) {
        this.id = id;
        this.name = name;
        this.memberQuantity = memberQuantity;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idFamily) {
        this.id = idFamily;
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

    public void setPassword(String password) {
        this.password = password;
    }
}