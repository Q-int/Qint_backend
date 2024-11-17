package org.example.qint_backend.domain.question.service;

import lombok.RequiredArgsConstructor;
import org.example.qint_backend.domain.question.presentation.dto.request.MoveToNextProblemRequest;
import org.example.qint_backend.domain.user.domain.User;
import org.example.qint_backend.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MoveToNextProblemService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(MoveToNextProblemRequest request) {
        User user = userFacade.getCurrentUser();
        boolean moveToNextProblem = request.isMoveToNextProblem();

        if(!moveToNextProblem) {
            user.resetAnswersCounts(
                    user.getCorrectAnswers(),
                    user.getIncorrectAnswers()
            );
        }
    }
}