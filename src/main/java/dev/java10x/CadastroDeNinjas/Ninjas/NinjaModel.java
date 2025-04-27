package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 *Entity transforma uma classe em uma entidade do BD
 * JPA = Java Persistence API
 */
@Entity
@Table(name = "tb_cadastro")
@Data // Data: criou getters e setters automaticamente
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

   @Column(name = "nome")
   private String nome;

   @Column(unique = true)
   private String email;

   @Column(name = "img_url")
   private String imgUrl;

   @Column(name = "idade")
   private int idade;

   // @ManyToOne: um ninja tem uma única missão | Chave estrangeira
   @ManyToOne
   @JoinColumn(name = "missoes_id")// Foreing Key ou Chave estrangeira
   private MissoesModel missoes;
}

