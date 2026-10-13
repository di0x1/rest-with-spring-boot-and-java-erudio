package br.com.di0x1.services;
import br.com.di0x1.exeption.ResouceNotFoundException;
import br.com.di0x1.model.Person;
import br.com.di0x1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository repository;


    public List<Person> findAll() {
        logger.info("Finding all person");
        return repository.findAll();
    }

    public Person create(Person person){
        logger.info("Creating one person");
        return repository.save(person);
    }

    public Person findById(Long id){
        logger.info("Finding one person");

        return repository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
    }

    public Person update(Person person){
        logger.info("Updating a person");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }
}
