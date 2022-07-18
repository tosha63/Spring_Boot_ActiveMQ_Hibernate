package ru.shtanko.spring_framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shtanko.spring_framework.entity.BodyMessage;

@Repository
public interface BodyMessageRepository extends JpaRepository<BodyMessage, Long> {
}
