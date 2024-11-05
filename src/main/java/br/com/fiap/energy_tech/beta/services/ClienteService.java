package br.com.fiap.energy_tech.beta.services;

import br.com.fiap.energy_tech.beta.entities.Cliente;
import br.com.fiap.energy_tech.beta.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Collection<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(UUID id) {
        return repository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        cliente = repository.save(cliente);
        return cliente;
    }

    public Cliente update(UUID id, Cliente cliente) {
        Cliente buscaCliente = repository.getReferenceById(id);
        buscaCliente.setNome(cliente.getNome());
        buscaCliente.setCpf(cliente.getCpf());
        buscaCliente.setEmail(cliente.getEmail());
        buscaCliente.setDataNascimento(cliente.getDataNascimento());
        buscaCliente.setUrlDaFotoPerfil(cliente.getUrlDaFotoPerfil());
        buscaCliente = repository.save(buscaCliente);
        return buscaCliente;
    }

    public void delete(UUID id) {
            repository.deleteById(id);
        }

}
