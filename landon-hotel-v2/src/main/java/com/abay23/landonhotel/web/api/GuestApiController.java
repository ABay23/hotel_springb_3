package com.abay23.landonhotel.web.api;

import com.abay23.landonhotel.data.entity.Guest;
import com.abay23.landonhotel.data.repository.GuestRepository;
import com.abay23.landonhotel.web.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guest")
public class GuestApiController {

    private final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> getAllReservations(){
        return this.guestRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@RequestBody Guest guest){
        return this.guestRepository.save(guest);
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id") long id){
        Optional<Guest> guest = this.guestRepository.findById(id);
        if (guest.isEmpty()){
            throw new BadRequestException("Guest Not found with id: " + id);
        }
        return guest.get();
    }

    @PutMapping("/{id}")
    public Guest updatedGuest(@PathVariable("id") long id, @RequestBody Guest guest){
        if (id != guest.getId()){
            throw new BadRequestException("Id on path does not match the body!");
        }
        return this.guestRepository.save(guest);
    }
}
