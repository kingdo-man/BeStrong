package com.kingdoman.bestrong.spring.proxy.spring;

/**
 * @author Bingabing
 */

@SuppressWarnings("ALL")
public interface CustomerService {

    /**
     * 添加顾客
     */
    void addCustomer();

    /**
     * 更新顾客
     */
    void updateCustomer();

    /**
     * 删除顾客
     *
     * @param id 顾客ID
     * @return 删除行数
     */
    Integer deleteCustomer(Integer id);
}
