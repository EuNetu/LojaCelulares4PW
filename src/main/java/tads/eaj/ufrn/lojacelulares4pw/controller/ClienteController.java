package tads.eaj.ufrn.lojacelulares4pw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public List<Cliente> listar(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){

        Optional<Cliente> cliente = service.getClienteById(id);

        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(cliente.get());
        }
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Cliente cliente){
        service.save(cliente);
        return ResponseEntity.created(URI.create("/clientes/" + cliente.getId())).body(cliente);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        return service.getClienteById(id)
                .map( record -> {
                    if (record.getId() == cliente.getId()){
                        service.update(cliente);
                        return ResponseEntity.ok(cliente);
                    }else{
                        return ResponseEntity.notFound().build();
                    }

                }).orElse(ResponseEntity.notFound().build());
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
