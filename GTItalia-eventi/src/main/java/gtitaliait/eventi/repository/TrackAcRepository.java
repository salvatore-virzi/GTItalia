package gtitaliait.eventi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtitaliait.eventi.model.TrackAc;

public interface TrackAcRepository extends JpaRepository<TrackAc, Long>{

	List<TrackAc> findByNome(String nome);
}
