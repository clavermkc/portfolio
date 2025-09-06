package service.implement;

import dtos.SkillDto;
import entity.Skill;
import repositories.SkillRepository;
import service.SkillService;

import java.util.List;
import java.util.Set;

public interface SkillServiceImplment {
void createSkill(SkillDto skillDto);
void deleteSkill(Long id);
List<SkillDto> getAllSkills();
SkillDto getSkillDtoById(Long id);
}
