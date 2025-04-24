package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
    /*ID , Nome missao, Dificuldade (rank)*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String Rank;

    // OneToMany: uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;

    public MissoesModel() {
    }

    public MissoesModel(String nome, String rank, NinjaModel ninja) {
        this.nome = nome;
        Rank = rank;
        this.ninja = ninja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public NinjaModel getNinja() {
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }
}
