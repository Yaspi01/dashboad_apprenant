package com.example.odkApprenant.repositories;

import com.example.odkApprenant.model.ListePresence;
import com.example.odkApprenant.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PresenceRepository extends JpaRepository<ListePresence, Long> {
    public ListePresence getPresenceListByDateAndUtilisateur(LocalDate localDate, Utilisateur utilisateur);
    public List<ListePresence> getPresenceListByDate(LocalDate localDate);
    public List<ListePresence> getPresenceListByDateGreaterThanEqualAndDateLessThanEqual(LocalDate min, LocalDate max);
}