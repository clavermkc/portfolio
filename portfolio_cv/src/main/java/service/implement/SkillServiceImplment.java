package service.implement;

import dtos.SkillDto;
import repositories.SkillRepository;
import service.SkillService;

public interface SkillServiceImplment {
void createSkill(SkillDto skillDto);
void deleteSkill(Long id);
void getAllSkills();
}
