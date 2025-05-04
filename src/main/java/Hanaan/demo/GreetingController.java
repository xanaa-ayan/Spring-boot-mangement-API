package Hanaan.demo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Staff Management System!";
    }
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("/success")
    public ResponseEntity<String> success() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Success");
        return new ResponseEntity<>("Success!", headers, HttpStatus.OK);
    }
    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: Resource not found");
    }
    @PostMapping("/create")
    public ResponseEntity<String> create() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/created-resource");
        return new ResponseEntity<>("Resource created", headers, HttpStatus.CREATED);
    }

}
