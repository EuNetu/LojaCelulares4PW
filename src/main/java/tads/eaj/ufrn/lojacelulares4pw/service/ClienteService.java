package tads.eaj.ufrn.lojacelulares4pw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.lojacelulares4pw.model.Cliente;
import tads.eaj.ufrn.lojacelulares4pw.repository.ClienteRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public void setRepository(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> findAll(){
        return repository.findAllByDeletedIsNull();
    }

    public Optional<Cliente> getClienteById(Long id){
        return repository.findByDeletedIsNullAndId(id);
    }

    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente){
        return repository.saveAndFlush(cliente);
    }

    public Cliente delete(Long id){
        Cliente cliente = repository.getById(id);
        cliente.setDeleted(new Date());
        return repository.saveAndFlush(cliente);
    }
}
