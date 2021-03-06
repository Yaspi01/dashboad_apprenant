package com.example.odkApprenant.controllers;

import com.example.odkApprenant.model.ListePresence;
import com.example.odkApprenant.services.PresenceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PresenceController {

    @Autowired
    PresenceServiceImp presenceServiceImp;

    @PostMapping("/presence/add")
    public String addPrence(@RequestBody ListePresence listePresence){
        return this.presenceServiceImp.addPresence(listePresence);
    }

    //Get all presence list
    @GetMapping("/presence/all")
    public List<ListePresence> getAllPresenceList(){
        return this.presenceServiceImp.getPresenceList();
    }

    //Get presence list by date
    @GetMapping("/presence/date={date}")
    public List<ListePresence> getTodayPresenceList(
            @PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date){
        return this.presenceServiceImp.getPresenceList(date);
    }

    //Get presence list by a week
    @GetMapping("/presence/week={year}-{month}-{day}")
    public List<ListePresence> getListByWeek(
            @PathVariable("year") int year,
            @PathVariable("month") int month,
            @PathVariable("day") int day
    ){
        return this.presenceServiceImp.getPresenceList(year, month, day);
    }

    //Get presence list by month
    @GetMapping("/presence/month={year}-{month}")
    public List<ListePresence> getMonthPresenceList(
            @PathVariable("year") int year,
            @PathVariable("month") int month)
    {
        return this.presenceServiceImp.getPresenceList(year, month);
    }

    //Get presence list between two periodes of time
    @GetMapping("/presence/entre/{start}&{end}")
    public List<ListePresence> getPresenceListBetween(
            @PathVariable("start") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate start,
            @PathVariable("end") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end){
        return this.presenceServiceImp.getPresenceList(start, end);
    }

}
