package com.example.odkApprenant.services;

import com.example.odkApprenant.model.Profil;
import com.example.odkApprenant.model.Utilisateur;
import com.example.odkApprenant.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImp implements UsersService{

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public void saveUsers(Utilisateur utilisateur) {
        this.utilisateurRepository.save(utilisateur);
    }

    @Override
    @Transactional
    public void editUsers(Long id, Utilisateur utilisateur) {
        Utilisateur current = this.utilisateurRepository.getById(id);
        current.setNom(utilisateur.getNom());
        current.setPrenom(utilisateur.getPrenom());
        current.setAge(utilisateur.getTelephone());
        current.setTelephone(utilisateur.getTelephone());
        current.setEmail(utilisateur.getEmail());
        current.setLogin(utilisateur.getLogin());
        current.setPassword(utilisateur.getPassword());
        current.setUtilisateurStatus(utilisateur.getUtilisateurStatus());
        current.setDateCreation(utilisateur.getDateCreation());
        current.setDateModification(utilisateur.getDateModification());
    }

    @Override
    public Optional<Utilisateur> getUsersById(Long id) {
        return this.utilisateurRepository.findById(id);
    }

    @Override
    public List<Utilisateur> getAllUsers() {
        return (List<Utilisateur>) this.utilisateurRepository.findAll();
    }

    @Override
    public void deleteUsers(Long id) {
        this.utilisateurRepository.deleteById(id);
    }

    @Override
    public Utilisateur getAuth(String login, String password) {
        return this.utilisateurRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public List<Utilisateur> getAllUsersByProfil(Profil profil) {
        return this.utilisateurRepository.getUsersByProfil(profil);
    }
}
