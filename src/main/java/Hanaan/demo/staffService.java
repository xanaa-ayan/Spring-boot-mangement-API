package Hanaan.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class staffService {
    private final Map<Long, Staff> staffs = new ConcurrentHashMap<>();
    private final AtomicLong autoId = new AtomicLong();

    // Get all staffs
    public Collection<Staff> getAllStaffs() {
        return staffs.values();
    }

    // Get staff by ID
    public Staff getStaffById(Long id) {
        return staffs.get(id);
    }

    // Save new staff
    public void saveStaff(Staff newStaff) {
        Long id = newStaff.getId() != null
                ? newStaff.getId()
                : autoId.incrementAndGet();
        newStaff.setId(id);
        staffs.put(id, newStaff);
    }

    // Update staff
    public Staff updateStaff(Long id, Staff newStaff) {
        if (staffs.containsKey(id)) {
            Staff existing = staffs.get(id);
            existing.setName(newStaff.getName());
            existing.setPosition(newStaff.getPosition());
            staffs.put(id, existing);
        }
        return newStaff;
    }



    // Delete staff
    public void delete(Long id) {
        staffs.remove(id);
    }


}
