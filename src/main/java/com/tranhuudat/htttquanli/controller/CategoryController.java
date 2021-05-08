package com.tranhuudat.htttquanli.controller;

import java.util.List;

import com.tranhuudat.htttquanli.model.Category;

import com.tranhuudat.htttquanli.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") long id){
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{page}/{pageSize}")
    public ResponseEntity<List<Category>> getPage(@PathVariable("page") int page,@PathVariable("pageSize") int pageSize){
        Page<Category> pageModel= categoryService.findAll(page, pageSize);
        List<Category> listCate= pageModel.getContent();
        return new ResponseEntity<>(listCate, HttpStatus.OK);
    }


    @PostMapping(value="/add")
    public ResponseEntity<Category> pEntity(@RequestBody Category category) {
        category= categoryService.addOrUpdate(category);
        if(category==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(category,HttpStatus.OK);
        }
    }


    @PutMapping(value="edit/{id}")
    public ResponseEntity<Category> putMethodName(@PathVariable long id, @RequestBody  Category entity) {
        Category category= categoryService.findById(id);
        if(category==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(categoryService.addOrUpdate(entity), HttpStatus.OK);
        }
    }
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        Category category= categoryService.findById(id);
        if(category==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            categoryService.delete(id);
            return new ResponseEntity<Category>( HttpStatus.OK);
        }
    }

}
