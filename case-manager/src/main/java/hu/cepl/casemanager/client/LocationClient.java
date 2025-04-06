package hu.cepl.casemanager.client;

import hu.cepl.casemanager.config.FeignConfig;
import hu.cepl.casemanager.model.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${location-manager.eureka.id}", configuration = FeignConfig.class)
public interface LocationClient {

    @GetMapping("/api/location/{id}")
    Location getById(@PathVariable Long id);

}
