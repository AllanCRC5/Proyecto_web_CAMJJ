package ucr.ac.cr.EcoHogar.model.DTO;

public class RegisterRequest {

    Integer id;
    String name;
    Integer memberQuantity;
    String email;
    String password;
    Integer deviceId;
    Integer ecoServiceId;

    public RegisterRequest() {
    }


    public RegisterRequest(Integer id, String name, Integer memberQuantity, String email, String password, Integer deviceId, Integer ecoServiceId) {
        this.id = id;
        this.name = name;
        this.memberQuantity = memberQuantity;
        this.email = email;
        this.password = password;
        this.deviceId = deviceId;
        this.ecoServiceId = ecoServiceId;
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

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getEcoServiceId() {
        return ecoServiceId;
    }

    public void setEcoServiceId(Integer ecoServiceId) {
        this.ecoServiceId = ecoServiceId;
    }
}
