package ucr.ac.cr.EcoHogar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.EcoHogar.model.DTO.RegisterRequest;
import ucr.ac.cr.EcoHogar.model.DTO.UserLoginDto;
import ucr.ac.cr.EcoHogar.model.DTO.UserRequest;
import ucr.ac.cr.EcoHogar.model.DTO.UserResponse;
import ucr.ac.cr.EcoHogar.model.User;
import ucr.ac.cr.EcoHogar.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/family")
@CrossOrigin("*")
public class UserController
{
    @Autowired
    private UserService userService;


    @PostMapping("login")
    public ResponseEntity<?> login (@Validated @RequestBody UserLoginDto dto, BindingResult result)
    {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        User user = this.userService.login(dto.getEmail(), dto.getPassword());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectos");
        }
        return ResponseEntity.ok("Bienvenido "+user.getName());
    }

    //Obtener todos-funcionaa
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll()
    {
        return ResponseEntity.ok(this.userService.findAll());
    }//fin metodo

    //Obtener por id-funciona
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id)
    {
        UserResponse user = this.userService.findByID(id);

        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha podido encontrar un usuario con ese id");
        }//fin if
        return ResponseEntity.ok(user);
    }//Fin metodo


    //findByName, se revisa después
//    @GetMapping("/name/{name}/{id}")
//    public ResponseEntity<?> findByName(@PathVariable String name, Integer id)
//    {
//        User user=this.userService.findByID(id);
//        if(user==null)
//        {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El nombre no se encuentra registrado");
//        }//fin if
//        return ResponseEntity.ok(this.userService.findByName(name));
//    }//fin metodo


    //Editar-funciona
    @PutMapping("/id/{id}")
    public ResponseEntity<?>edit(@Validated @PathVariable Integer id, @RequestBody UserRequest user, BindingResult result)
    {
        if (result.hasErrors())
        {
            Map<String, String> errors=new HashMap<>();
            for (FieldError error : result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }//fin if

        UserResponse userEd = this.userService.findByID(id);

        if(userEd == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se encuentra el usuario con ese id");
        }//fin if
        return ResponseEntity.ok(this.userService.editUser(id, user));
    }//fin metodo


    //Guardar usuario
    @PostMapping("/save")
    public  ResponseEntity<?> saveUser(@Validated @RequestBody RegisterRequest request, BindingResult result)
    {
        if (result.hasErrors())
        {
            Map<String, String> errors=new HashMap<>();
            for (FieldError error : result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }//fin if

        UserResponse dto=this.userService.save(request);

        if (dto==null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID: "+request.getId()+ "ya esta registrado.");
        }//fin if
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }//fin metodo



    //El consume de agua al mes
    @GetMapping("/agua/{id}")
    public ResponseEntity<?> waterConsumptionPerMonth(@PathVariable Integer id)
    {
        UserResponse user = this.userService.findByID(id);

        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha podido encontrar un usuario con ese id");
        }//fin if
        return ResponseEntity.ok().body(this.userService.waterConsumptionPerMonth(id));
    }


    //El consumo de luz al mes
    @GetMapping("/luz/{id}")
    public ResponseEntity<?> lightConsumptionPerMonth(@PathVariable Integer id)
    {
        UserResponse user = this.userService.findByID(id);

        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha podido encontrar un usuario con ese id");
        }//fin if
        return ResponseEntity.ok().body(this.userService.ligthConsumptionPerMonth(id));
    }


    //El consumo de agua al año
    @GetMapping("/agua-año/{id}")
    public ResponseEntity<?> waterConsumptionPerYear(@PathVariable Integer id)
    {
        UserResponse user = this.userService.findByID(id);

        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha podido encontrar un usuario con ese id");
        }//fin if
        return ResponseEntity.ok().body(this.userService.waterConsumptionPerYear(id));
    }


    //El consume de luz al año
    @GetMapping("/luz-año/{id}")
    public ResponseEntity<?> lightConsumptionPerYear(@PathVariable Integer id)
    {
        UserResponse user = this.userService.findByID(id);

        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha podido encontrar un usuario con ese id");
        }//fin if
        return ResponseEntity.ok().body(this.userService.lightConsumptionPerYear(id));
    }


    //El consume de luz al año
    @GetMapping("/eco-indice/{id}")
    public ResponseEntity<?> ecoIndex(@PathVariable Integer id)
    {
        UserResponse user = this.userService.findByID(id);

        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha podido encontrar un usuario con ese id");
        }//fin if
        return ResponseEntity.ok().body(this.userService.ecoIndex(id));
    }

}//fin clase
