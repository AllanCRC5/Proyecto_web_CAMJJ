package ucr.ac.cr.EcoHogar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.EcoHogar.model.Service;
import ucr.ac.cr.EcoHogar.service.ServiceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/EcoHogar/service")
public class EcoServiceController
{


    @Autowired
    private ServiceService service;

    @GetMapping("/all")
    public ResponseEntity<?>findAll()
    {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?>findByName(@PathVariable String name){
        if (this.service.findByName(name)==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encuentra un " +
                    "servicio con ese nombre");
        }
        return ResponseEntity.ok(this.service.findByName(name));
    }

    @PostMapping("/save")
    public ResponseEntity<?>save(@Validated @RequestBody Service service, BindingResult result){
        if (result.hasErrors()){
            Map<String, String>errors=new HashMap<>();
            for (FieldError error : result.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Service service1=this.service.save(service);
        if (service1==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    "El servicio con ese id ya está registrado");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service1);
    }
}
