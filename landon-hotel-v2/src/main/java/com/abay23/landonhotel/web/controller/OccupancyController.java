package com.abay23.landonhotel.web.controller;

import com.abay23.landonhotel.service.RoomReservationService;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/occupancy")
public class OccupancyController {

    private final RoomReservationService service;

    public OccupancyController(RoomReservationService service) {
        this.service = service;
    }

    @GetMapping
    public String getOccupancy(Model model, @RequestParam(value = "date", required = false) String dateString){
//        Date date = new Date();
        java.util.Date utilDate = new java.util.Date();
        Date date = new Date(utilDate.getTime());
        if (StringUtils.isNotBlank(dateString)){
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                date = (Date) format.parse(dateString);
            }
            catch (Exception e){
                //do nothing ???
            }
        }
        model.addAttribute("date", date);
        model.addAttribute("reservations", this.service.getRoomReservationForDate(dateString));
        return "occupancy";

    }
}

