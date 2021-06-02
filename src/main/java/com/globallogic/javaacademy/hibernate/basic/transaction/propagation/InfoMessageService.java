package com.globallogic.javaacademy.hibernate.basic.transaction.propagation;

import com.globallogic.javaacademy.hibernate.basic.entity.InfoMessage;
import com.globallogic.javaacademy.hibernate.basic.repository.InfoMessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfoMessageService {

    private final InfoMessageRepository errorMessageRepository;

    public InfoMessageService(InfoMessageRepository errorMessageRepository) {
        this.errorMessageRepository = errorMessageRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(String message) {
        final InfoMessage errorMessage = new InfoMessage();
        errorMessage.setMessage(message);
        errorMessageRepository.save(errorMessage);
    }
}
