package JavaProject.Dayoung.domain.quiz.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSolvedQuiz is a Querydsl query type for SolvedQuiz
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSolvedQuiz extends EntityPathBase<SolvedQuiz> {

    private static final long serialVersionUID = -563271861L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSolvedQuiz solvedQuiz = new QSolvedQuiz("solvedQuiz");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QQuiz quiz;

    public final NumberPath<Long> receivedScore = createNumber("receivedScore", Long.class);

    public final NumberPath<Long> solvedCount = createNumber("solvedCount", Long.class);

    public final JavaProject.Dayoung.domain.user.domain.QUser user;

    public QSolvedQuiz(String variable) {
        this(SolvedQuiz.class, forVariable(variable), INITS);
    }

    public QSolvedQuiz(Path<? extends SolvedQuiz> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSolvedQuiz(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSolvedQuiz(PathMetadata metadata, PathInits inits) {
        this(SolvedQuiz.class, metadata, inits);
    }

    public QSolvedQuiz(Class<? extends SolvedQuiz> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.quiz = inits.isInitialized("quiz") ? new QQuiz(forProperty("quiz")) : null;
        this.user = inits.isInitialized("user") ? new JavaProject.Dayoung.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

