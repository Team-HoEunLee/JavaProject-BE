package JavaProject.Dayoung.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1898250158L;

    public static final QUser user = new QUser("user");

    public final StringPath accountId = createString("accountId");

    public final ListPath<Long, NumberPath<Long>> areaIds = this.<Long, NumberPath<Long>>createList("areaIds", Long.class, NumberPath.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduction = createString("introduction");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final EnumPath<JavaProject.Dayoung.domain.user.domain.type.Role> role = createEnum("role", JavaProject.Dayoung.domain.user.domain.type.Role.class);

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

