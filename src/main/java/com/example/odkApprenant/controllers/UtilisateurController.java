package com.example.odkApprenant.controllers;

import com.example.odkApprenant.model.Profil;
import com.example.odkApprenant.model.Utilisateur;
import com.example.odkApprenant.services.UsersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {
    @Autowired
    private UsersServiceImp usersServiceImp;

    //Ajouter un utilisateur, l'attribut profile est la principale différence
    @PostMapping("/user/save")
    public String saveApprenant(@RequestBody Utilisateur utilisateur){
        this.usersServiceImp.saveUsers(utilisateur);
        return "Enregistrement reussi...";
    }

    //La mise en jour d'un utilisateur
    @PutMapping("/user/update/{id}")
    public String editApprenant(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur){
        this.usersServiceImp.editUsers(id, utilisateur);
        return "Apprenant modifié avec success...";
    }

    //Recuperer un utilisateur par son id
    @GetMapping("/user/get/{id}")
    public Optional<Utilisateur> getApprenantById(@PathVariable("id") Long id){
        return this.usersServiceImp.getUsersById(id);
    }

    //Recuperer tous les utilisateurs
    @GetMapping("/users/all")
    public List<Utilisateur> getAllUsers(){
        return (List<Utilisateur>) usersServiceImp.getAllUsers();
    }

    //Recuperer les utilisateurs par profil
    @GetMapping("/users/{profil}")
    public List<Utilisateur> getAllUserByProfil(@PathVariable("profil") Profil profil){
        return this.usersServiceImp.getAllUsersByProfil(profil);
    }

    //Supprimer un utilisateur par son id
    @DeleteMapping("/user/delete/{id}")
    public String deleteAnUsers(@PathVariable("id") Long id){
        this.usersServiceImp.deleteUsers(id);
        return "Apprenant effacé avec succèss...";
    }

    @GetMapping("/auth/{login}&{password}")
    public Utilisateur checkUser(@PathVariable("login") String login,
                                 @PathVariable("password") String password){
        return this.usersServiceImp.getAuth(login, password);
    }
}
