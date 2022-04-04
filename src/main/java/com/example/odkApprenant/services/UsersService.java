package com.example.odkApprenant.services;

import com.example.odkApprenant.model.Profil;
import com.example.odkApprenant.model.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersService {
    public void saveUsers(Utilisateur utilisateur);
    public void editUsers(Long id, Utilisateur utilisateur);
    public Optional<Utilisateur> getUsersById(Long id);
    public List<Utilisateur> getAllUsers();
    public List<Utilisateur> getAllUsersByProfil(Profil profil);
    public void deleteUsers(Long id);
    public Utilisateur getAuth(String login, String password);
}
