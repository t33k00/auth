package com.db.webapp.Controller;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.webapp.Repository.UserRepository;
import com.db.webapp.Service.SecurityService;
import com.db.webapp.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin
@RestController
public class UserRestController {
    @Autowired
    SecurityService uRepo;
    
    @Autowired
    private UserRepository repo2;

    @PostMapping("register")
    public ResponseEntity<String> register(
        @RequestParam String username, 
        @RequestParam String password, 
        @RequestParam String email)
        {
            User u = uRepo.register(username, email, password);
            return new ResponseEntity<>(u.getUsername(), HttpStatus.OK);
        }

    @PostMapping("login")
    public ResponseEntity<String> login(
        @RequestParam String username, 
        @RequestParam String password)
        {
            String token = uRepo.login(username, password);

            if(token == null){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            return new ResponseEntity<>(token, HttpStatus.OK);
        }
 
    @GetMapping("private")
    public ResponseEntity<String> getPrivateData(@RequestHeader("Authorization") String bearer){

        if(bearer.startsWith("Bearer")){
            String token = bearer.split(" ")[1];
            String username = uRepo.validateJwt(token);
            if(username!=null){
                return new ResponseEntity<>("Private data for "+username, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("loginbasic")
    public ResponseEntity<String> loginBasic(@RequestHeader("Authorization") String basicAuth)
        {

            String token = null;
            //"Basic uname:pw"
            if(basicAuth.startsWith("Basic")){
                String credentials = basicAuth.split(" ")[1];
                String[] user = new String( Base64.getDecoder().decode(credentials)).split(":");
                token = uRepo.login(user[0], user[1]);
            }

        
            if(token == null){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            return new ResponseEntity<>(token, HttpStatus.OK);
        }


   
        @GetMapping("data")List<String>data(){
            return repo2.getdata();
    
        }
}
