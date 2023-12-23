package com.gcu.data;

import java.util.List;

/**
 * Generic interface for performing basic CRUD operations on entities.
 *
 * @param <T> The type of entity for which CRUD operations are defined.
 */
public interface DataAccessInterface<T> {

    /**
     * Retrieves a list of all entities of type T from the data source.
     *
     * @return A list of all entities in the data source.
     */
    public List<T> findAll();

    /**
     * Retrieves an entity of type T from the data source based on its unique identifier.
     *
     * @param id The unique identifier of the entity.
     * @return The entity with the specified identifier, or null if not found.
     */
    public T findById(String id);

    /**
     * Creates a new entity in the data source.
     *
     * @param t The entity to be created.
     * @return True if the entity was successfully created, false otherwise.
     */
    public boolean create(T t);

    /**
     * Updates an existing entity in the data source.
     *
     * @param t The entity to be updated.
     * @return True if the entity was successfully updated, false otherwise.
     */
    public boolean update(T t);

    /**
     * Deletes an entity from the data source.
     *
     * @param t The entity to be deleted.
     * @return True if the entity was successfully deleted, false otherwise.
     */
    public boolean delete(T t);
}
