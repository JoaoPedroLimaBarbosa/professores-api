package br.edu.unifsa.professoresapi.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.unifsa.professoresapi.model.Professor;
import br.edu.unifsa.professoresapi.repository.ProfessorRepository;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> listarTodos() {
        return repository.findAll();
    }

    public List<Professor> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Professor> buscarPorArea(String area) {
        return repository.findByAreaIgnoreCase(area);
    }

    public Professor cadastrar(Professor professor) {
        // garante que o banco vai gerar um id novo
        professor.setId(null);
        return repository.save(professor);
    }

    public Professor atualizar(Long id, Professor dados) {
        Professor professor = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Professor não encontrado"));

        professor.setNome(dados.getNome());
        professor.setEmail(dados.getEmail());
        professor.setArea(dados.getArea());
        professor.setTelefone(dados.getTelefone());

        return repository.save(professor);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Professor não encontrado");
        }
        repository.deleteById(id);
    }
}
