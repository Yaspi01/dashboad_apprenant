package com.example.odkApprenant.services;

import com.example.odkApprenant.model.ListePresence;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface PresenceService {

    //Add to an user to presence list
    public String addPresence(ListePresence listePresence);

    //Get all presence list
    public List<ListePresence> getPresenceList();

    //Get presence list by date
    public List<ListePresence> getPresenceList(LocalDate localDate);

    //Get presence list by week
    public List<ListePresence> getPresenceList(int year, int month, int day);

    //Get presence list by month
    public List<ListePresence> getPresenceList(int year, int month);

    //Get presence list between two periodes of time
    public List<ListePresence> getPresenceList(LocalDate min, LocalDate max);
}
