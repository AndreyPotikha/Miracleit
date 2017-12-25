package miracle.workWithSql.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {

    private int id;
    private String name;
    private String skills;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", skills='").append(skills).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
