package JavaProject.Dayoung.domain.quiz.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuiz is a Querydsl query type for Quiz
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuiz extends EntityPathBase<Quiz> {

    private static final long serialVersionUID = -1210585498L;

    public static final QQuiz quiz = new QQuiz("quiz");

    public final ListPath<Long, NumberPath<Long>> areaIds = this.<Long, NumberPath<Long>>createList("areaIds", Long.class, NumberPath.class, PathInits.DIRECT2);

    public final ListPath<Long, NumberPath<Long>> codeIds = this.<Long, NumberPath<Long>>createList("codeIds", Long.class, NumberPath.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<JavaProject.Dayoung.domain.quiz.domain.type.Level> level = createEnum("level", JavaProject.Dayoung.domain.quiz.domain.type.Level.class);

    public final StringPath question = createString("question");

    public final StringPath title = createString("title");

    public QQuiz(String variable) {
        super(Quiz.class, forVariable(variable));
    }

    public QQuiz(Path<? extends Quiz> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuiz(PathMetadata metadata) {
        super(Quiz.class, metadata);
    }

}

