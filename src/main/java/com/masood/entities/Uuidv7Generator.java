package com.masood.entities;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.github.f4b6a3.uuid.UuidCreator;

public class Uuidv7Generator implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		// Generates an RFC 9562 compliant UUID v7 with Unix epoch timestamp prefix
		return UuidCreator.getTimeOrderedEpoch();
	}

}
