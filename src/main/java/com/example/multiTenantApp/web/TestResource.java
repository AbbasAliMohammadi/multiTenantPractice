package com.example.multiTenantApp.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.multiTenantApp.domain.Post;
import com.example.multiTenantApp.domain.Tenant;
import com.example.multiTenantApp.domain.TenantWithSameTable;
import com.example.multiTenantApp.service.PostService;
import com.example.multiTenantApp.service.TenantService;
import com.example.multiTenantApp.service.TenantWithSameTableService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestResource {

     private final PostService postService;
     private final TenantService tenantService;
     private final TenantWithSameTableService tenantWithSameTableService;

    @PostMapping
    public Post createPost(@RequestBody Post post, 
                          @RequestHeader("X-Tenant-ID") String tenantId) {
        
            return postService.createPost(post);
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestHeader("X-Tenant-ID") String tenantId) {
        
            return postService.getAllPosts();
       
    }

    @GetMapping("/search")
    public List<Post> searchPosts(@RequestParam String title,
                                 @RequestHeader("X-Tenant-ID") String tenantId) {
     
            return postService.searchPosts(title);
      
    }

    @PostMapping("/tenant")
    public boolean createTenant(@RequestBody Tenant tenant) {
        return tenantService.createTenant(tenant);
    }


    @PostMapping("/tenantWithSameTable")
    public TenantWithSameTable create(@RequestBody TenantWithSameTable post, 
                          @RequestHeader("X-Tenant-ID") String tenantId) {
        
            return tenantWithSameTableService.save(post);
    }

    @GetMapping("/tenantWithSameTable")
    public List<TenantWithSameTable> getAll(@RequestHeader("X-Tenant-ID") String tenantId) {
        
            return tenantWithSameTableService.findAll();
       
    }
}
