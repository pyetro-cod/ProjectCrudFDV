package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository = new UserRepository();
    private Long contadorId = 1L;


    public void criar(String nome, String email){
        repository.salvar(new User(contadorId++, nome,email));
    }

    public List<User> listar() {
        return repository.listaUsers();
    }

    public boolean atualizar(Long id, String nome, String email) {
        User usuario = repository.buscarId(id);
        if (usuario != null) {
            usuario.setNome(nome);
            usuario.setEmail(email);
            return true;
        }
        return false;
    }

    public boolean deletar(Long id){
        User user = repository.buscarId(id);
        if (user != null) {
            repository.deletar(id);
            return true;
        }
        return false;
    }
}
