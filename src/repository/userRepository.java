package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class userRepository {

    private List<User> usuarios = new ArrayList<>();

    public void salvar(User user){
        usuarios.add(user);
    }

    public List<User> listaUsers(){
        return usuarios;
    }

    public User buscarId(Long id){
        return usuarios.stream()
                .filter(u -> u.getId()
                .equals(id)).findFirst().orElse(null);
    }

    public void deletar(Long id){
        usuarios.removeIf(u -> u.getId().equals(id));
    }
}
