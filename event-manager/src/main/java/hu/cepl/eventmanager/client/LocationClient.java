package hu.cepl.eventmanager.client;

import hu.cepl.eventmanager.config.FeignConfig;
import hu.cepl.eventmanager.model.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${location-manager.eureka.id}", configuration = FeignConfig.class)
public interface LocationClient {

    @GetMapping("/api/location/{id}")
    Location getById(@PathVariable Long id);

}
