package com.rafarha.ecommerce.controller;

import com.rafarha.ecommerce.controller.dto.UserDto;
import com.rafarha.ecommerce.controller.form.UserForm;
import com.rafarha.ecommerce.domain.User;
import com.rafarha.ecommerce.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final String URI_NAME = "/api/users";

    @Autowired
    private IUserService userService;

    @GetMapping("{/id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long pId) {
	User user = userService.searchUserById(pId);
	if (user == null) {
	    ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(new UserDto(user));

    }

    @GetMapping
    public List<UserDto> listAllUsers() {
	return UserDto.converter(userService.searchAllUsers());
    }

    @PostMapping
    public ResponseEntity<?> saveUsers(@RequestBody @Valid UserForm pUserForm, UriComponentsBuilder pUriComponentsBuilder) {
	final User user = userService.saveUser(UserForm.converter(pUserForm));
	URI uri = pUriComponentsBuilder.path(URI_NAME + "{/id}").buildAndExpand(user, user.getId()).toUri();
	return ResponseEntity.created(uri).body(new UserDto(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsers(@PathVariable("id") Long pId, @RequestBody @Valid UserForm pUserForm) {
	User user = userService.updateUser(pId, UserForm.converter(pUserForm));
	if (user == null) {
	    ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(new UserDto(user));
    }

}
