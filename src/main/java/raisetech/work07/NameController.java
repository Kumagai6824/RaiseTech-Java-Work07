package raisetech.work07;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@Validated
public class NameController {
    @GetMapping("/names")
    public UserInfo getUserInfo(
            @RequestParam(value = "name")
            @Valid
            @NotBlank
            @Pattern(regexp = "[a-zA-Z0-9]{1,20}")
            String name,
            @RequestParam(value = "dateOfBirth")
            @Valid
            @NotBlank
            @Pattern(regexp = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$")
            String dateOfBirth
    ) {
        return new UserInfo(name, dateOfBirth);
    }

    @PostMapping("/names")
    public ResponseEntity<Map<String, String>> create(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost8081")
                .path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
    }
}
