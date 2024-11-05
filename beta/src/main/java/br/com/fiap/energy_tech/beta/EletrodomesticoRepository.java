package br.com.fiap.energy_tech.beta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, UUID> {

}
