package Lab1.domain.dto;

import Lab1.domain.Post;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    String name;
    List<Post> posts;
}

