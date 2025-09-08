package br.com.fiap.sportskids.service;

import br.com.fiap.sportskids.entity.Brinquedo;
import br.com.fiap.sportskids.repository.BrinquedoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // leituras por padrão
public class BrinquedoService {

    private final BrinquedoRepository repository;

    public BrinquedoService(BrinquedoRepository repository) {
        this.repository = repository;
    }

    public List<Brinquedo> findAll() {
        return repository.findAll();
    }

    public Brinquedo findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional // escrita
    public Brinquedo save(Brinquedo b) {
        return repository.save(b);
    }

    @Transactional // escrita
    public void deleteById(Long id) {
        repository.deleteById(id);
        repository.flush();
    }
}
