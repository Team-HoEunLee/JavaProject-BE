package JavaProject.Dayoung.domain.area.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QArea is a Querydsl query type for Area
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArea extends EntityPathBase<Area> {

    private static final long serialVersionUID = -1092765994L;

    public static final QArea area = new QArea("area");

    public final StringPath areaName = createString("areaName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QArea(String variable) {
        super(Area.class, forVariable(variable));
    }

    public QArea(Path<? extends Area> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArea(PathMetadata metadata) {
        super(Area.class, metadata);
    }

}

