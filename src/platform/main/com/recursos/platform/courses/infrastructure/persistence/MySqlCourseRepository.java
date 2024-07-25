package com.recursos.platform.courses.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import com.recursos.platform.courses.domain.Course;
import com.recursos.platform.courses.domain.CourseId;
import com.recursos.platform.courses.domain.CourseRepository;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.criteria.Criteria;
import com.recursos.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("platform-transaction_manager")
public class MySqlCourseRepository extends HibernateRepository<Course> implements CourseRepository {
    public MySqlCourseRepository(@Qualifier("platform-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Course.class);
    }

    @Override
    public void save(Course course) {
        persist(course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return byId(id);
    }

    @Override
    public List<Course> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
