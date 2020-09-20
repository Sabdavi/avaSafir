package com.avasafir.learning.serveice;

import com.avasafir.learning.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class PhoneService {

    private final EntityManager entityManager;

    public PhoneService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void updatePhone(){
        Phone phone = new Phone();
        phone.setAreaCode(026);
        phone.setNumber(4555009);

        entityManager.persist(phone);
    }
}
