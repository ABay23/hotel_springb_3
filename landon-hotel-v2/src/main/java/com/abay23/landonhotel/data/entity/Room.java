package com.abay23.landonhotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="rooms")
public class Room {
    @Id
    @Column(name="room_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="room_number")
    private String roomNumber;

    @Column(name="bed_info")
    private String bedInfo;


}
