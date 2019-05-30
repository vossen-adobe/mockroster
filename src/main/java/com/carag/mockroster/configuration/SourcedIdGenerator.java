package com.carag.mockroster.configuration;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class SourcedIdGenerator  implements IdentifierGenerator {


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {


         return UUID.randomUUID().toString();
    }
}
