package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

//LOCALHOST:8080/
@RestController
@RequestMapping("missoes")
public class MissoesController {

    // GET - Mandar uma requisição para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missoes listadas com sucesso";
    }

    // POST - mandar uma requisição apra criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso!";
    }

    //PUT - Requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";

    }

    // DELETE - requisição para deletar as missoes
    @DeleteMapping("/deletar")
        public String deletarMissao(){
                return "Missao deletada com sucesso";
    }

}
