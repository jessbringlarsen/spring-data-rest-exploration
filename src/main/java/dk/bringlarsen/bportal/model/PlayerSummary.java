package dk.bringlarsen.bportal.model;

import org.springframework.hateoas.ResourceSupport;

public class PlayerSummary extends ResourceSupport {

    private String name;

    public PlayerSummary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
