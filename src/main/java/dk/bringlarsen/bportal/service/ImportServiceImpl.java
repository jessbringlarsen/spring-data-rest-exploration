package dk.bringlarsen.bportal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.Collection;
import java.util.Collections;

@Service
public class ImportServiceImpl implements ImportService {

    private Logger logger = LoggerFactory.getLogger(ImportServiceImpl.class);

    @Async
    @Override
    public ListenableFuture<Collection<String>> doImport() {
        return new ListenableFutureTask<>(() -> {
            logger.info("doImport!");
          /*  DBTURatingServices service = new DBTURatingServices(new DBTURatingServiceProperties());
            List<Player> players = service.getPlayers();
            logger.info(String.format("Got %s players", players.size()));
            */
            return Collections.emptyList();
        });
    }
}