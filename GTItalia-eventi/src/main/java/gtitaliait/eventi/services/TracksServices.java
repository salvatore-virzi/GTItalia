package gtitaliait.eventi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtitaliait.eventi.csv.FileTrack;
import gtitaliait.eventi.model.Track;
import gtitaliait.eventi.model.TrackAc;
import gtitaliait.eventi.model.TrackAcc;
import gtitaliait.eventi.repository.TrackAcRepository;
import gtitaliait.eventi.repository.TrackAccRepository;

@Service
public class TracksServices {
	@Autowired
	TrackAccRepository trackAccRepository;
	@Autowired
	TrackAcRepository trackAcRepository;
	
	FileTrack fileTrack = new FileTrack();
	
	public void saveAll() {
		for(Track t: fileTrack.readFileGame()) {
			if(t instanceof TrackAc) {
				trackAcRepository.save((TrackAc)t);
			} else if(t instanceof TrackAcc) {
				trackAccRepository.save((TrackAcc)t);
			}
		}
	}
	public List<TrackAc> getAll(){
		return trackAcRepository.findAll();
	}
	//search AC
	public TrackAc searchTrackForName(String name) {
		return trackAcRepository.findByNome(name).get(0);
	}
	
}
