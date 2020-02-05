package com.octo.dto.criteria;

import com.octo.domain.enums.Level;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchCriteriaDTO implements Serializable {

    private Level level;
    private List<String> tags;
    private String username;

    public SearchCriteriaDTO(Level level, List<String> tags) {
        this.level = level;
        this.tags = tags;
    }
}
