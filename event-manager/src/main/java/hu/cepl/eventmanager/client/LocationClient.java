package hu.cepl.eventmanager.client;

import hu.cepl.eventmanager.model.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-gateway")
public interface LocationClient {

    @GetMapping("/api/location/{id}")
    Location getById(@PathVariable Long id);

}
