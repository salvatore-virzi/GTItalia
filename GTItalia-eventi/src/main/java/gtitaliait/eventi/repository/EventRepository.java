package gtitaliait.eventi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gtitaliait.eventi.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
Event findByNome(String nome); 
}