package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.Entity;

@Entity
public class User {

    private Integer idFamily;
    private String name;
    private Integer memberQuantity;
    private String email;
    private  String password;

    public User() {
    }

    public User(Integer idFamily, String name, Integer memberQuantity, String email, String password) {
        this.idFamily = idFamily;
        this.name = name;
        this.memberQuantity = memberQuantity;
        this.email = email;
        this.password = password;
    }

    public Integer getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(Integer idFamily) {
        this.idFamily = idFamily;
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