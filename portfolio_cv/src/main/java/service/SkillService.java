package service;

import dtos.SkillDto;
import entity.Skill;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import service.implement.SkillServiceImplment;
import repositories.SkillRepository;

import java.util.HashSet;
import java.util.Optional;

@Service

public class SkillService implements SkillServiceImplment {
    private final SkillRepository skillRepository;
    private final Logger log = LoggerFactory.getLogger(SkillService.class);

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    @Override
    public void createSkill(SkillDto skillDto) {
        Skill skill = Skill.builder().category(skillDto.getCategory()).
                skill_name(skillDto.getSkill_name()).framework(skillDto.getFramework()).
                icon(skillDto.getIcon()).
                build();
        //add it in der collection
        skill.getSKillCollection().add(skill);
        //skill muss eindeutig sein
        for(Skill skill_ : skill.getSKillCollection()) {
            if (skill_.getSkill_name().equals(skillDto.getSkill_name())) {
                log.debug("skill can not be created because another skill with the same name existed");
                return;
            }
        }
        skillRepository.save(skill);
    }

//we assume that skill doesn't have a dependencies with another entities and is not transactional
    @Override
    public void deleteSkill(Long id) {
        log.info("Attempting to delete skill with ID: {}", id);

        // Vérifier si le skill existe
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Skill with id {} not found for deletion", id);
                    return new EntityNotFoundException(String.format("Skill with id %d not found", id));
                });
    }


    @Override
    public void getAllSkills() {
        skillRepository.findAll();
    }
}
