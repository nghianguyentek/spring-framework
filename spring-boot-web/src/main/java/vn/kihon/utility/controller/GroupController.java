package vn.kihon.utility.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.kihon.utility.Group;

import java.util.Collections;
import java.util.List;

@RestController
class GroupController {
    @GetMapping(value = "/groups",
            produces = "application/json")
    ResponseEntity<List<Group>> getGroups() {
        return ResponseEntity.ok(Collections.emptyList());
    }
}
