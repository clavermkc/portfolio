package controller;

import dtos.SkillDto;
import entity.Message;
import entity.Skill;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SkillService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("auth/admin")
@AllArgsConstructor
@RequiredArgsConstructor
public class adminController {

    SkillService skillService;
    //uniquement avec authentification admin
    @PostMapping("/post-skill")
    public ResponseEntity<SkillDto> postSkill( @RequestBody SkillDto skillDto) {
         skillService.createSkill(skillDto);
        return ResponseEntity.ok().body(skillDto);
    }
    @GetMapping("/getSkills")
    public List<SkillDto> getSkills(@RequestBody List<SkillDto> skillDtoSet) {
        //was passiert wenn das schiefgeht?
        return skillService.getAllSkills();


    }
    @GetMapping("/get-skill/{id}")
    public ResponseEntity<SkillDto> getSkill(@PathVariable Long id) {

        return ResponseEntity.ok().body( skillService.getSkillDtoById(id));
    }

}
