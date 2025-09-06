package dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {
    private String category;
    private String skill_name;
    private String framework;
    /*that icon is used to display the skill */
    private ImageIcon icon;

}
