package org.bloom.entity;

/**
 * Represents a guardian entity
 */
public interface Guardian extends Entity{
    /**
     * Gets if the guardian entity is a elder
     * @return if the guardian entity is a elder
     */
    boolean isElder();

    /**
     * Sets if the guardian entity is a elder or not
     * @param flag the flag for the set operation
     */
    void setElder(boolean flag);
}
