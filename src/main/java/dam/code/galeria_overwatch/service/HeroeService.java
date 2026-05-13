package dam.code.galeria_overwatch.service;

import dam.code.galeria_overwatch.model.Habilidad;
import dam.code.galeria_overwatch.model.Heroe;
import dam.code.galeria_overwatch.repository.HeroeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroeService {

    private final HeroeRepository repo;

    public HeroeService(HeroeRepository repo) {
        this.repo = repo;
    }

    public List<Heroe> listar() {
        return repo.findAll();
    }

    public Heroe guardar(Heroe heroe) {
        if (heroe.getHabilidades() != null) {
            for (Habilidad h : heroe.getHabilidades()) {
                h.setHeroe(heroe);
            }
        }
        return repo.save(heroe);
    }

    public Heroe buscarPorId(String id) {
        return repo.findById(id).orElse(null);
    }

}