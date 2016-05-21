package com.lapsa.insurance.domain;

import java.util.UUID;

public abstract class BaseDomain<T> {

    protected final UUID internalId = UUID.randomUUID();

    protected T id;

    @Override
    public int hashCode() {
	return this.getClass().hashCode()
		* (id != null ? id.hashCode() : internalId.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null
		&& this.getClass().isInstance(obj)
		&& ((id == null && internalId.equals(this.getClass().cast(obj).internalId))
			|| (id != null && getId().equals((this.getClass().cast(obj)).id)));
    }

    // GENERATED

    public T getId() {
	return id;
    }

    public void setId(T id) {
	this.id = id;
    }

}