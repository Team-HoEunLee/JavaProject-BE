package JavaProject.Dayoung.domain.quiz.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserAreaSolved is a Querydsl query type for UserAreaSolved
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAreaSolved extends EntityPathBase<UserAreaSolved> {

    private static final long serialVersionUID = -1794232338L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAreaSolved userAreaSolved = new QUserAreaSolved("userAreaSolved");

    public final JavaProject.Dayoung.domain.area.domain.QArea area;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> solvedCount = createNumber("solvedCount", Long.class);

    public final JavaProject.Dayoung.domain.user.domain.QUser user;

    public QUserAreaSolved(String variable) {
        this(UserAreaSolved.class, forVariable(variable), INITS);
    }

    public QUserAreaSolved(Path<? extends UserAreaSolved> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserAreaSolved(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserAreaSolved(PathMetadata metadata, PathInits inits) {
        this(UserAreaSolved.class, metadata, inits);
    }

    public QUserAreaSolved(Class<? extends UserAreaSolved> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.area = inits.isInitialized("area") ? new JavaProject.Dayoung.domain.area.domain.QArea(forProperty("area")) : null;
        this.user = inits.isInitialized("user") ? new JavaProject.Dayoung.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

