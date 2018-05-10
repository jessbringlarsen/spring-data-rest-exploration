package dk.bringlarsen.bportal.service;

import dk.bringlarsen.bportal.model.Player;
import dk.bringlarsen.bportal.repository.PlayerJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportServiceImpl implements ImportService {

    private Logger logger = LoggerFactory.getLogger(ImportServiceImpl.class);

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Override
    public void doImport() throws IOException {
        List<Player> playerList = parse();
        playerJpaRepository.saveAll(playerList);
    }

    private List<Player> parse() throws IOException {
        List<Player> playerList = new ArrayList<>();
        try(InputStream is = ImportServiceImpl.class.getClassLoader().getResourceAsStream(("data/PlayerRatingsTableTennisEngland.csv"))) {
            String content = StreamUtils.copyToString(is, Charset.defaultCharset());
            String[] lines = content.split("\n");
            for (String line : lines) {
                String[] lineSplit = line.split("\"");
                Player player = new Player();
                player.setName(lineSplit[1]);
                playerList.add(player);
            }
        }
        return playerList;
    }

    public static void main(String[] args) throws IOException {

    }
}