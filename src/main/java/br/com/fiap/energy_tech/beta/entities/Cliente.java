package br.com.fiap.energy_tech.beta.entities;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "db_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private Data dataNascimento;
    private String email;
    private String cpf;
    private String urlDaFotoPerfil;

    public Cliente() {};

    public Cliente(UUID id, String nome, Data dataNascimento, String email, String cpf, String urlDaFotoPerfil) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
        this.urlDaFotoPerfil = urlDaFotoPerfil;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUrlDaFotoPerfil() {
        return urlDaFotoPerfil;
    }

    public void setUrlDaFotoPerfil(String urlDaFotoPerfil) {
        this.urlDaFotoPerfil = urlDaFotoPerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", urlDaFotoPerfil='" + urlDaFotoPerfil + '\'' +
                '}';
    }
}
