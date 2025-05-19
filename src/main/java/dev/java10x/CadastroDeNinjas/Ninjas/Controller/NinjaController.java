package dev.java10x.CadastroDeNinjas.Ninjas.Controller;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // #C.R.U.D
    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um  novo ninja", description = "Essa rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
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
    @Operation(summary = "Lista o ninja por ID", description = "Essa rota lista um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninha não encontrado")
    })
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
    @Operation(summary = "Altera o ninja por ID", description = "Essa rota altera um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninha não encontrado, não foi possível alterar")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter (description = "usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){

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
