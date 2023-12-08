    package br.com.afroglow.backendAfroGlow.Controllers;

    import br.com.afroglow.backendAfroGlow.Models.Endereco;
    import br.com.afroglow.backendAfroGlow.Service.EnderecoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;

    @RestController
    @RequestMapping("/endereco")
    public class EnderecoController {

        private final EnderecoService enderecoService;

        @Autowired
        public EnderecoController(EnderecoService enderecoService) {
            this.enderecoService = enderecoService;
        }

        @PostMapping
        public ResponseEntity<Endereco> adicionarEndereco(@RequestBody Endereco endereco) {
            enderecoService.adicionarEndereco(endereco);
            return new ResponseEntity<>(endereco, HttpStatus.CREATED);
        }

        @GetMapping("/{enderecoId}")
        public ResponseEntity<Endereco> visualizarEndereco(@PathVariable Integer enderecoId) {
            Endereco endereco = enderecoService.visualizarEndereco(enderecoId);

            if (endereco != null) {
                return new ResponseEntity<>(endereco, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PutMapping
        public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco) {
            enderecoService.atualizarEndereco(endereco);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }

        @DeleteMapping("/{enderecoId}")
        public ResponseEntity<String> deletarEndereco(@PathVariable Integer enderecoId) {
            enderecoService.deletarEndereco(enderecoId);
            return new ResponseEntity<>("Endereço deletado com sucesso!", HttpStatus.OK);
        }
    }
