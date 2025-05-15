package dev.java10x.CadastroDeNinjas.Ninjas.Controller;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
import jdk.javadoc.doclet.Reporter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // #C.R.U.D
    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome()+ " (ID): " + novoNinja.getId());
    }
    // Mostrar todos os ninjas(CREATE)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
       List<NinjaDTO> ninjas = ninjaService.listarNinjas();
       return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninjas por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> ListarNinjasPorId(@PathVariable long id){
    NinjaDTO ninja = ninjaService.ListarNinjasPorId(id);

    if (ninja != null){
        return ResponseEntity.ok(ninja);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID: " + id + " não existe nos nossos registros");
    }

    }

    // Aterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
      NinjaDTO alterarNinja =  ninjaService.atualizarNinja(id,ninjaAtualizado);

      if (alterarNinja != null){
          return ResponseEntity.ok(alterarNinja);
      } else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .body("Ninja com o ID: " + id + " não existe nos nossos registros");
      }
}

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if (ninjaService.ListarNinjasPorId(id) != null ){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("O ninja com o ID " + id + " não foi encontrado!");
        }
    }
}
