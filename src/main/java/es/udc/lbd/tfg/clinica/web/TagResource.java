package es.udc.lbd.tfg.clinica.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.udc.lbd.tfg.clinica.model.service.TagService;
import es.udc.lbd.tfg.clinica.model.service.dto.TagDTO;

@RestController
@RequestMapping("/api/tags")
public class TagResource {

    @Autowired
    private TagService tagService;

    @GetMapping
    public List<TagDTO> findAll() {
        return tagService.findAll();
    }
}
