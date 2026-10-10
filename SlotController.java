package com.vaccination.booking.controller;

import com.vaccination.booking.model.Slot;
import com.vaccination.booking.repository.SlotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
@CrossOrigin
public class SlotController {

    private final SlotRepository slotRepository;

    public SlotController(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @PostMapping
    public Slot addSlot(@RequestBody Slot slot) {
        slot.setAvailableSlots(slot.getCapacity());
        return slotRepository.save(slot);
    }

    @GetMapping
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @GetMapping("/center/{centerId}")
    public List<Slot> getSlotsByCenter(@PathVariable int centerId) {
        return slotRepository.findByCenterId(centerId);
    }
}