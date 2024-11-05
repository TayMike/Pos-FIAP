package br.com.fiap.energy_tech.beta.services;

import br.com.fiap.energy_tech.beta.entities.Eletrodomestico;
import br.com.fiap.energy_tech.beta.repositories.EletrodomesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class EletrodomesticoService {

    @Autowired
    private EletrodomesticoRepository repository;

    public Collection<Eletrodomestico> findAll() {
        return repository.findAll();
    }

    public Optional<Eletrodomestico> findById(UUID id) {
        return repository.findById(id);
    }

    public Eletrodomestico save(Eletrodomestico eletrodomestico) {
        eletrodomestico = repository.save(eletrodomestico);
        return eletrodomestico;
    }

    public Eletrodomestico update(UUID id, Eletrodomestico eletrodomestico) {
        Eletrodomestico buscaEletrodomestico = repository.getReferenceById(id);
        buscaEletrodomestico.setNome(eletrodomestico.getNome());
        buscaEletrodomestico.setDescricao(eletrodomestico.getDescricao());
        buscaEletrodomestico.setPreco(eletrodomestico.getPreco());
        buscaEletrodomestico.setUrlDaImagem(eletrodomestico.getUrlDaImagem());
        buscaEletrodomestico = repository.save(buscaEletrodomestico);
        return buscaEletrodomestico;
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
