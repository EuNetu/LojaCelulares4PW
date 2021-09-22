package tads.eaj.ufrn.lojacelulares4pw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.lojacelulares4pw.dto.request.ClienteRequestDTO;
import tads.eaj.ufrn.lojacelulares4pw.dto.response.ClienteResponseDTO;
import tads.eaj.ufrn.lojacelulares4pw.model.Cliente;
import tads.eaj.ufrn.lojacelulares4pw.service.ClienteService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lojadecelulares")
public class ClienteController {

    private ClienteService service;

    @Autowired
    public void setService(ClienteService service) {
        this.service = service;
    }
    @GetMapping
    public List<ClienteResponseDTO> listar(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable Long id){

        Optional<Cliente> cliente = service.getClienteById(id);

        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(new ClienteResponseDTO(cliente.get()));
        }
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(@RequestBody ClienteRequestDTO clienteDTO){
        Cliente cliente = service.save(clienteDTO.build());
        return ResponseEntity.created(URI.create("/clientes/" + cliente.getId())).body(new ClienteResponseDTO(cliente));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> newCliente = service.getClienteById(id);
        if (newCliente.isPresent() && newCliente.get().getId() == cliente.getId()){
            return ResponseEntity.ok(new ClienteResponseDTO(service.save(cliente)));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        return service.getClienteById(id)
                .map(record -> {
                    service.delete(record.getId());
                    return ResponseEntity.ok(200);
                }).orElse(ResponseEntity.notFound().build());
    }

}
