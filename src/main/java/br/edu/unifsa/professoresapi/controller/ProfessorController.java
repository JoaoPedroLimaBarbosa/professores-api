package br.edu.unifsa.professoresapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifsa.professoresapi.model.Professor;
import br.edu.unifsa.professoresapi.service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/nome/{nome}")
    public List<Professor> buscarPorNome(@PathVariable("nome") String nome) {
        return service.buscarPorNome(nome);
    }

    @GetMapping("/area/{area}")
    public List<Professor> buscarPorArea(@PathVariable("area") String area) {
        return service.buscarPorArea(area);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor cadastrar(@RequestBody Professor professor) {
        return service.cadastrar(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable("id") Long id, @RequestBody Professor professor) {
        return service.atualizar(id, professor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") Long id) {
        service.excluir(id);
    }
}
