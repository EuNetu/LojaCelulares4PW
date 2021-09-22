package tads.eaj.ufrn.lojacelulares4pw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tads.eaj.ufrn.lojacelulares4pw.model.Celular;
import tads.eaj.ufrn.lojacelulares4pw.model.Cliente;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByDeletedIsNull();
    Optional<Cliente> findByDeletedIsNullAndId(Long id);
}
