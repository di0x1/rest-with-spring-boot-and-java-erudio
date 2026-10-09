package br.com.di0x1;

import br.com.di0x1.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for(int i=0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firtsname" + i);
        person.setLastName("Lastname"+ i);
        person.setAddress("Brazil");
        person.setGender("furry");

        return person;

    }

    public Person findById(String id){
        logger.info("Finding one person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Ricardo");
        person.setLastName("Iuji");
        person.setAddress("Maringa");
        person.setGender("Male");

        return person;
    }
}
