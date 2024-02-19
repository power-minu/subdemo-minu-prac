package minu.subran.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import minu.subran.domain.Member;
import minu.subran.domain.Recipe;

@Getter
@Setter
@NoArgsConstructor
public class RecipeRequest {

    @NotBlank(message = "빵을 선택하세요.")
    private String bread;

    @NotBlank(message = "메뉴를 선택하세요.")
    private String mainStuff;

    public Recipe toEntity() {
        return Recipe.builder()
                .bread(this.bread)
                .mainStuff(this.mainStuff)
                .build();
    }
}
