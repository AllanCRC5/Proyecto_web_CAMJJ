package ucr.ac.cr.EcoHogar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.EcoHogar.model.DTO.EcoServiceResponse;
import ucr.ac.cr.EcoHogar.model.DTO.EcoServiveRequest;
import ucr.ac.cr.EcoHogar.model.EcoService;
import ucr.ac.cr.EcoHogar.service.EcoServiceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/EcoHogar/service")
public class EcoServiceController
{

    @Autowired
    private EcoServiceService service;

    @GetMapping("/all")
    public ResponseEntity<?> findAll()
    {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name)
    {
        EcoServiceResponse response = this.service.findByName(name);

        if (response == null)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No se encuentra un servicio con ese nombre");
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Validated @RequestBody EcoServiveRequest request,
                                  BindingResult result)
    {
        if (result.hasErrors())
        {
            Map<String, String> errors = new HashMap<>();

            for (FieldError error : result.getFieldErrors())
            {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errors);
        }

        EcoServiceResponse response = this.service.save(request);

        if (response == null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El servicio con ese id ya está registrado");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
