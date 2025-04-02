package hu.cepl.personmanager.client;

import hu.cepl.personmanager.model.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${api.gateway.eureka.id}")
public interface LocationClient {

    @GetMapping("/api/location/{id}")
    Location getById(@PathVariable Long id);

}
