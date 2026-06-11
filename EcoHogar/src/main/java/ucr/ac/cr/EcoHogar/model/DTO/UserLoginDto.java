package ucr.ac.cr.EcoHogar.model.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class UserLoginDto {
@Email(message = "Ingrese un correo electrónico válido")
private String email;
    @NotBlank(message = "La contraseña es obligatoria")

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%?&]).{8,}$",
            message = "La contraseña debe tener mínimo 8 caracteres, una mayúscula, un número y un símbolo"
    )
private String password;

    public UserLoginDto()
    {

    }

    public UserLoginDto(Integer id, String name, String email)
    {

        this.email = email;
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

