package com.abay23.landonhotel.web.api;

import com.abay23.landonhotel.data.entity.Reservation;
import com.abay23.landonhotel.data.repository.ReservationRepository;
import com.abay23.landonhotel.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/reservation")
public class ReservationApiController {

    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAllReservations(){
        return this.reservationRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody Reservation reservation){
        return this.reservationRepository.save(reservation);
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") long id){
        Optional<Reservation> reservation = this.reservationRepository.findById(id);
        if ( reservation.isEmpty()){
            throw new NotFoundException("No reservation was found by id: " + id);
        }
        return reservation.get();
    }
}
