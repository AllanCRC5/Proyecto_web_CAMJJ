package ucr.ac.cr.EcoHogar.model;

import jakarta.persistence.Entity;

@Entity
public class Family {
    private Integer idFamily;
    private String memberName;
    private Integer memberQuantity;
    private Integer ageMember;

    public Family(Integer idFamily, String memberName, Integer memberQuantity, Integer ageMember) {
        this.idFamily = idFamily;
        this.memberName = memberName;
        this.memberQuantity = memberQuantity;
        this.ageMember = ageMember;
    }

    public Family() {
    }

    public Integer getIdFamily() {
        return idFamily;
    }

    public void setIdFamily(Integer idFamily) {
        this.idFamily = idFamily;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getMemberQuantity() {
        return memberQuantity;
    }

    public void setMemberQuantity(Integer memberQuantity) {
        this.memberQuantity = memberQuantity;
    }

    public Integer getAgeMember() {
        return ageMember;
    }

    public void setAgeMember(Integer ageMember) {
        this.ageMember = ageMember;
    }
}
