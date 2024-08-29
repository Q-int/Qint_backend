package org.example.qint_backend.domain.question.domain.repository;

import org.example.qint_backend.domain.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}