package hu.cepl.locationmanager.component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class RequestValidationFilter extends OncePerRequestFilter {

    @Value("${allowed.services}")
    private List<String> allowedServices;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String serviceName = request.getHeader("X-Service-Name");

        if (serviceName == null || !allowedServices.contains(serviceName)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Service not allowed");
            return;
        }

        filterChain.doFilter(request, response);
    }

}
