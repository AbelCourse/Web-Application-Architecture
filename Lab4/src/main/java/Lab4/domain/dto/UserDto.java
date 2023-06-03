package Lab4.domain.dto;

import Lab4.domain.Post;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    String name;
    List<Post> posts;
}

