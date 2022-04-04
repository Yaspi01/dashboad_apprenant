package com.example.odkApprenant.services;

import com.example.odkApprenant.model.ListePresence;
import com.example.odkApprenant.repositories.PresenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.time.temporal.TemporalAdjusters.previousOrSame;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class PresenceServiceImp implements PresenceService{

    @Autowired PresenceRepository presenceRepository;

    //Add an user to presence list
    @Override
    public String addPresence(ListePresence listePresence) {
        ListePresence user = this.presenceRepository.getPresenceListByDateAndUsers(
                LocalDate.now(), listePresence.getUtilisateur()
        );
        if (user==null){
            this.presenceRepository.save(listePresence);
            return "Apprenant ajouter avec succèss";
        }else{
            return "L'apprenant existe déjà pour la séance...";
        }
    }

    //Get all presence list
    @Override
    public List<ListePresence> getPresenceList() {
        return this.presenceRepository.findAll();
    }

    //Get presence list by date
    @Override
    public List<ListePresence> getPresenceList(LocalDate localDate) {
        return this.presenceRepository.getPresenceListByDate(localDate);
    }

    //Get all users by a week
    @Override
    public List<ListePresence> getPresenceList(int year, int month, int day) {
        LocalDate week = LocalDate.of(year, month, day);
        LocalDate monday = week.with(previousOrSame(DayOfWeek.MONDAY));
        LocalDate friday = week.with(nextOrSame(DayOfWeek.FRIDAY));
        return this.presenceRepository.getPresenceListByDateGreaterThanEqualAndDateLessThanEqual(monday, friday);
    }

    //Get all users by a month
    @Override
    public List<ListePresence> getPresenceList(int year, int month) {
        LocalDate initial = LocalDate.of(year, month, 1);
        LocalDate start = initial.withDayOfMonth(1);
        LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
        return this.presenceRepository.getPresenceListByDateGreaterThanEqualAndDateLessThanEqual(start, end);
    }

    //Get all users between two periode of time
    @Override
    public List<ListePresence> getPresenceList(LocalDate min, LocalDate max) {
        return this.presenceRepository.getPresenceListByDateGreaterThanEqualAndDateLessThanEqual(min, max);
    }

}
