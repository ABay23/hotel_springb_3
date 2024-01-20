package com.abay23.landonhotel.data.repository;

import com.abay23.landonhotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
//    Optional<Guest> findGuestBy(Long id);
}
