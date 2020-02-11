/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esira;

import esira.domain.Disciplina;
import esira.domain.Estudante;
import esira.domain.Faculdade;
import esira.domain.Inscricao;
import esira.domain.Users;
import esira.service.CRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author user
 */
@Controller
public class RestFulModuleController {

    @Autowired
    @Qualifier("CRUDService")
    CRUDService crudService;

    @RequestMapping(value = "/students/all",
            method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = {"Accept=application/json"})
    public ResponseEntity<Object> studentsAll() {
        try {
            List<Estudante> list = crudService.getAll(Estudante.class);
            
            if(list == null){
                return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
            }

            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user/all",
            method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<Object> users() {
        try {
            List<Users> list = crudService.getAll(Users.class);

            if(list == null){
                return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
            }
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/enroll/{id}",
            method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<Object> enroll(@PathVariable("id") String id) {
        try {
            Map<String, Object> par = new HashMap<String, Object>();
            par.put("id", id);
            List<Inscricao> list = crudService.findByJPQuery("SELECT i FROM Inscricao i WHERE i.idEstudante.idEstudante = :id", par);

            if(list == null){
                return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
            }
            
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/subjest/all",
            method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<Object> subjetsAll() {
        try {
            List<Disciplina> list = crudService.getAll(Disciplina.class);
            
            if(list == null){
                return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
            }
            
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    @RequestMapping(value = "/faculty/all",
            method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<Object> facultyall() {
        try {
            List<Faculdade> list = crudService.getAll(Faculdade.class);
            
            if(list == null){
                return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
            }
            
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
