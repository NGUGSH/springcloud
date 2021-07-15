package com.gsh.mylb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Component
public class MyLoadBalancer implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = incrementAndGetModulo();
        int i = index % serviceInstances.size();
        return serviceInstances.get(i);
    }

   public int incrementAndGetModulo(){
       int current;
       int index;
        do{
            current = this.atomicInteger.get();
            index = current>2000000?0:current+1;
        }while(!this.atomicInteger.compareAndSet(current,index));
        return index;
   }
}
