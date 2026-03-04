package com.eazybites.jobportal.scopes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
public class ScopeController {

    private final RequestScopedBean requestScopedBean;
    private final SessionScopedBean sessionScopedBean;
    private final ApplicationScopedBean applicationScopedBean;

    @GetMapping("/request")
    public ResponseEntity<String> testRequestScope(){
        requestScopedBean.setUsername("John Doe");
        return ResponseEntity.ok(requestScopedBean.getUsername());
    }

    @GetMapping("/session")
    public ResponseEntity<String> testSessionScope(){
        sessionScopedBean.setUsername("John Doe");
        return ResponseEntity.ok(sessionScopedBean.getUsername());
    }

    @GetMapping("/application")
    public ResponseEntity<Integer> testApplicationScope(){
        applicationScopedBean.incrementVisitsCount();
        return ResponseEntity.ok(applicationScopedBean.getVisitorsCount());
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> testScope(){
        return ResponseEntity.ok(applicationScopedBean.getVisitorsCount());
    }
}
