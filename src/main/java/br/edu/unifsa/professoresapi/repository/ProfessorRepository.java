package br.edu.unifsa.professoresapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifsa.professoresapi.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    // filtro parcial e sem diferenciar maiúscula/minúscula
    List<Professor> findByNomeContainingIgnoreCase(String nome);

    // filtro exato por área, sem diferenciar maiúscula/minúscula
    List<Professor> findByAreaIgnoreCase(String area);
}
