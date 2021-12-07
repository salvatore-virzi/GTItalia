package gtitaliait.eventi.csv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

import gtitaliait.eventi.model.Track;
import gtitaliait.eventi.model.TrackAc;
import gtitaliait.eventi.model.TrackAcc;

public class FileTrack {
	private final String PATH_FILE = "D:\\salvo\\eclipe\\eclipse-workspace-6\\GTItalia-eventi\\src\\main\\resources\\static\\csv-file\\tracks.csv";

	public List<Track> readFileGame() {
		File fileCars = new File(PATH_FILE);
		String readFile;
		List<Track> listTracks = new ArrayList<>();

		try {
			readFile = FileUtils.readFileToString(fileCars, "UTF-8");
			List<String> listFileTracks = Arrays.asList(readFile.split("\n"));
			int n = 0;
			for (String p : listFileTracks) {
				if (n != 0) {
					String[] split = p.split(",");
					if(split[1].equalsIgnoreCase("AC")) {
						TrackAc tracks = new TrackAc();
						tracks.setNome(split[0]);
						tracks.setUrlPhoto(split[2]);
						listTracks.add(tracks);
					} else if(split[1].equalsIgnoreCase("ACC")) {
						TrackAcc tracks = new TrackAcc();
						tracks.setNome(split[0]);
						tracks.setUrlPhoto(split[2]);
						listTracks.add(tracks);
					}}else {
						n++;					
				}
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listTracks;

		}
}
