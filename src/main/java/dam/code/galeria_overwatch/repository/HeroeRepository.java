package dam.code.galeria_overwatch.repository;

import dam.code.galeria_overwatch.model.Heroe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroeRepository extends JpaRepository<Heroe, String> {
}