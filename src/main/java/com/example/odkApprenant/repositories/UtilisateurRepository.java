package com.example.odkApprenant.repositories;

import com.example.odkApprenant.model.Profil;
import com.example.odkApprenant.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    public Utilisateur findByLoginAndPassword(String login, String password);
    public List<Utilisateur> getUsersByProfil(Profil profil);
}
