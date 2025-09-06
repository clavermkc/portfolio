package controller;

import dtos.SkillDto;
import entity.Message;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SkillService;

@RestController
@RequestMapping("auth/admin")
@AllArgsConstructor
@RequiredArgsConstructor
public class adminController {

    SkillService skillService;
    //uniquement avec authentification admin
    @PostMapping("/admin/{id}")
    public ResponseEntity<SkillDto> postSkill( @RequestBody SkillDto skillDto) {
         skillService.createSkill(skillDto);
        return ResponseEntity.ok().body(skillDto);
    }

}
