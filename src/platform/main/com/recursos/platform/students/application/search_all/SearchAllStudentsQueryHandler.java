package com.recursos.platform.students.application.search_all;

import com.recursos.platform.students.application.StudentsResponse;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllStudentsQueryHandler implements QueryHandler<SearchAllStudentsQuery, StudentsResponse> {
    private final AllStudentsSearcher searcher;

    public SearchAllStudentsQueryHandler(AllStudentsSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public StudentsResponse handle(SearchAllStudentsQuery query) {
        return searcher.search();
    }
}
