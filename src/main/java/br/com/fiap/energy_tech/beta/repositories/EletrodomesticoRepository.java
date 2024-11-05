package br.com.fiap.energy_tech.beta.repositories;

import br.com.fiap.energy_tech.beta.entities.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, UUID> {

    List<Eletrodomestico> findByTipo(String tipo);
}
