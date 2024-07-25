package com.recursos.platform.steps.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import com.recursos.platform.steps.domain.Step;
import com.recursos.platform.steps.domain.StepId;
import com.recursos.platform.steps.domain.StepRepository;
import com.recursos.shared.domain.Service;
import com.recursos.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Service
@Transactional("platform-transaction_manager")
public class MySqlStepRepository extends HibernateRepository<Step> implements StepRepository {
    public MySqlStepRepository(@Qualifier("platform-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Step.class);
    }

    @Override
    public void save(Step step) {
        persist(step);
    }

    @Override
    public Optional<? extends Step> search(StepId id) {
        return byId(id);
    }
}
