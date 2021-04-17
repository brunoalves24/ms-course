package io.github.brunoalves24.hrworker.resources;

import io.github.brunoalves24.hrworker.entity.Worker;
import io.github.brunoalves24.hrworker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
    private final WorkerRepository workerRepository;
    private final Environment environment;

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    public WorkerResource(WorkerRepository workerRepository, Environment environment) {
        this.workerRepository = workerRepository;
        this.environment = environment;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workerList = workerRepository.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = " + environment.getProperty("local.server.port"));

        Optional<Worker> worker = workerRepository.findById(id);
        if(worker.isPresent())
            return ResponseEntity.ok(worker.get());

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }




}
