package Hanaan.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/staffs")
public class staffController {
    private final staffService service;

    public staffController(staffService service) {
        this.service = service;
    }

    // GET all staffs
    @GetMapping
    public Collection<Staff> getAll() {
        return service.getAllStaffs();
    }

    // GET staff by ID
    @GetMapping("/{id}")
    public Staff  getStaff(@PathVariable Long id) {
        return service.getStaffById(id);
    }

    // CREATE new staff
    @PostMapping
    public void save(@RequestBody Staff newStaff) {
        service.saveStaff(newStaff);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Staff newStaff) {
        service.updateStaff(id, newStaff);
    }

    // DELETE staff
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}



