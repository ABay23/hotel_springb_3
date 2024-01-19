package com.abay23.landonhotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@Entity
@Data
@ToString
@Table(name="reservations")
public class Reservation {
    @Id
    @Column(name="reservation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="room_id")
    private Integer roomId;

    @Column(name="guest_id")
    private Integer guestId;

    @Column(name="res_date")
    private Date reservationDate;

}
