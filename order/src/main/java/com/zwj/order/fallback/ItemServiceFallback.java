package com.zwj.order.fallback;

import com.zwj.order.entity.Item;
import com.zwj.order.feign.ItemFeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 此类中的方法专门用于服务降级，该类一般要实现调用远程服务的接口（这样保证方法名一致）
 */
@Component
public class ItemServiceFallback implements ItemFeignClient {
    @Override
    public Item queryItemById(@PathVariable("id")Long id) {
        return new Item(id, "服务降级方法queryItemById", null, "服务降级方法queryItemById", null);
    }
}
