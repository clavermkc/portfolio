package dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.Data;

import javax.swing.*;
@Data
public class SkillDto {
    private String category;
    private String skill_name;
    private String framework;
    /*that icon is used to display the skill */
    private ImageIcon icon;

}
