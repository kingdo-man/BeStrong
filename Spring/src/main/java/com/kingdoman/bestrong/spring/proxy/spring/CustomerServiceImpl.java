package com.kingdoman.bestrong.spring.proxy.spring;

import org.springframework.stereotype.Service;

/**
 * @author Bingabing
 */

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

    @Override
    public void addCustomer() {
        System.out.println("添加顾客");
    }

    @Override
    public void updateCustomer() {
        System.out.println("更新顾客");
    }

    /**
     * @param id 顾客ID
     * @return 删除行数
     */
    @Override
    public Integer deleteCustomer(Integer id) {
        System.out.println("删除顾客");
        return 1;
    }
}
