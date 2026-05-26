package ucr.ac.cr.EcoHogar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.EcoHogar.model.DTO.UserDTO;
import ucr.ac.cr.EcoHogar.model.User;
import ucr.ac.cr.EcoHogar.service.FamilyService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/family")
public class FamilyController {


    @Autowired
    private FamilyService familyService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(this.familyService.finAll());
    }

    @PostMapping("/save")
    public  ResponseEntity<?> saveUser(@Validated @RequestBody User user, BindingResult result){
        if (result.hasErrors()){
            Map<String, String> errors=new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        UserDTO dto=this.familyService.saveUser(user);
        if (dto==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID: "+user.getIdFamily()+ "ya esta registrado.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        if(this.familyService.findByName(name).isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El nombre no se encuentra registrado");
        }
        return ResponseEntity.ok(this.familyService.findByName(name));
    }


}
