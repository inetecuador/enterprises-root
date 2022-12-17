package com.base.common;

/**
 * IBaseService.
 *
 * @param <T>
 * @author vsangucho on 2022/12/15
 * @version 1.0
 */
public interface IBaseService<T> {

    /**
     * Save entity
     *
     * @param obj Entity to save
     */
    void save(T obj);
}
