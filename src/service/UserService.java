package service;

import model.User;
import repository.UserRepository;

public class UserService {
    private UserRepository repository = new UserRepository();

    public void criar(Long id, String nome, String email){
        repository.salvar(new User(id,nome,email));
    }

    public boolean atualizar(Long id,String nome, String email){
        User user = repository.buscarId(id);
        if (user != null){
            user.setNome(nome);
            user.setEmail(email);
            return true;
        }
        return false;
    }

    public boolean deletat(Long id){
        User user = repository.buscarId(id);
        if (user != null) {
            repository.deletar(id);
            return true;
        }
        return false;
    }
}
