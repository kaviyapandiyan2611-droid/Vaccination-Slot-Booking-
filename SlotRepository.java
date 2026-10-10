package com.vaccination.booking.repository;

import com.vaccination.booking.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Integer> {

    List<Slot> findByCenterId(int centerId);
}