package spring.renzo.reto.tech.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import spring.renzo.reto.tech.app.models.ClienteDTO;

@Repository
public interface ClienteDAO extends MongoRepository<ClienteDTO, String> {

}
