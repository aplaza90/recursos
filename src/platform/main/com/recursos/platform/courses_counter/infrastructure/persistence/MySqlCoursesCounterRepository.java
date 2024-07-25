package com.recursos.platform.courses_counter.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import com.recursos.platform.courses_counter.domain.CoursesCounter;
import com.recursos.platform.courses_counter.domain.CoursesCounterRepository;
import com.recursos.shared.domain.Service;
import com.recursos.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("platform-transaction_manager")
public class MySqlCoursesCounterRepository extends HibernateRepository<CoursesCounter> implements CoursesCounterRepository {
    public MySqlCoursesCounterRepository(@Qualifier("platform-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, CoursesCounter.class);
    }

    @Override
    public void save(CoursesCounter counter) {
        persist(counter);
    }

    @Override
    public Optional<CoursesCounter> search() {
        List<CoursesCounter> coursesCounter = all();

        return 0 == coursesCounter.size() ? Optional.empty() : Optional.ofNullable(coursesCounter.get(0));
    }
}
