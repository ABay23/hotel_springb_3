package com.abay23.landonhotel;


import com.abay23.landonhotel.data.entity.Guest;
import com.abay23.landonhotel.data.entity.Reservation;
import com.abay23.landonhotel.data.entity.Room;
import com.abay23.landonhotel.data.repository.GuestRepository;
import com.abay23.landonhotel.data.repository.ReservationRepository;
import com.abay23.landonhotel.data.repository.RoomRepository;
import com.abay23.landonhotel.service.RoomReservationService;
import com.abay23.landonhotel.service.model.RoomReservation;
import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomReservationService roomReservationService;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, RoomReservationService roomReservationService) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomReservationService = roomReservationService;
    }

    @Override
    public void run(String... args) throws Exception {
        //* I'm leaving this here as a reference of the first step testing the DB
//        System.out.println("***GUESTS***");
//        List<Guest> guests = this.guestRepository.findAll();
//        guests.forEach(System.out::println);
//
//        System.out.println("***ROOMS***");
//        List<Room> rooms = this.roomRepository.findAll();
////        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
//        rooms.forEach(System.out::println);
//
//        System.out.println("***RESERVATIONS***");
//        List<Reservation> reservations = this.reservationRepository.findAll();
//        reservations.forEach(System.out::println);

        List<RoomReservation> reservations = this.roomReservationService.getRoomReservationForDate("2023-08-28");
        reservations.forEach(System.out::println);
    }
}
