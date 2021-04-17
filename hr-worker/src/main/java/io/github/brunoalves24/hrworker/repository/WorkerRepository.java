package io.github.brunoalves24.hrworker.repository;

import io.github.brunoalves24.hrworker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
